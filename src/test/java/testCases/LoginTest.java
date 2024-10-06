package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class LoginTest extends BaseClass {
	
	@Test(groups= {"regression", "master"})
	public void validateLogin() {
		
		logger.info("********* Starting Login Test*************");
		logger.debug("capturing application debug logs......");
		
		try {
		//Create Object of HomePage, since all locators and actions methods there to land on login page
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		homepage.clickOnLogin();
		logger.info("********* Clicked on HomePage Login Button *************");
		
		//You should land on LoginPage now from HomePage
		//Now create object of LoginPage and start calling the methods from there to test
		LoginPage loginpage = new LoginPage(driver);
		logger.info("********* Adding credentials *************");
		loginpage.setEml(prop.getProperty("email"));
		loginpage.setPasswd(prop.getProperty("password"));
		loginpage.clickLogin();
		logger.info("********* Clicked on LoginPage Login Button *************");
		
		//Now you landed on MyAccPage after successful login
		//Finally create object of the landing page MyAccount Page
		MyAccountPage myAccPage = new MyAccountPage(driver);
		boolean myAccDisplayStatus = myAccPage.isMyAccountPageDisplays();
		Assert.assertEquals(myAccDisplayStatus, true, "Login Failed");
		
		}catch(Exception e) {
			Assert.fail();
		}finally {
			logger.info("********* Login Test Completed *************");
		}		
		
		
		//What is the difference between Final and Finally
		//finally is an optional keyword in try-catch block. when try block fails, the catch block gets executed, 
		//finally always gets executed whether pass fail
		//Final is a keyword in java when you declare it before any variable, that becomes unchangeable.(the variable name and value)
		
		
		
		
		
		
		
	}
	
	
	
	
	
	

}
