package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class LoginDDT extends BaseClass{
	
	@Test(dataProvider= "LoginData", dataProviderClass= DataProviders.class, groups="ddt")
	public void validate_loginDDT(String email, String password, String dataType) {
		
		logger.info("********* Starting Login Data Driven Testing*************");
		logger.debug("capturing application debug logs......");
		
		try {
		//Create Object of HomePage, since all locators and actions methods there to land on login page
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		homepage.clickOnLogin();
		
		
		//You should land on LoginPage now from HomePage
		//Now create object of LoginPage and start calling the methods from there to test
		LoginPage loginpage = new LoginPage(driver);		
		loginpage.setEml(email);
		loginpage.setPasswd(password);
		loginpage.clickLogin();
		
		
		//Now you landed on MyAccPage after successful login
		//Finally create object of the landing page MyAccount Page
		MyAccountPage myAccPage = new MyAccountPage(driver);
		boolean targetPage = myAccPage.isMyAccountPageDisplays();
		
		if(dataType.equalsIgnoreCase("Valid")) {
			if(targetPage==true) {
				myAccPage.clickOnLogout();
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
		}	
		
		
		if(dataType.equalsIgnoreCase("Invalid")) {
			if(targetPage==true) {//no invalid data should pass login
				myAccPage.clickOnLogout();
				Assert.fail();
			}else {
				Assert.assertTrue(true);
			}
		}
		}catch(Exception e) {
			Assert.fail("An exception occured: "+e.getMessage());
		}finally {
			logger.info("********* Finished Login Data Driven Testing*************");
		}
		
		
	
	
	
	}
	
	
	
	
	
	

}
