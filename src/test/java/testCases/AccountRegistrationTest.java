package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class AccountRegistrationTest extends BaseClass{
	
	//setup()
	//ValidateRegistration()
	//teardown()
	
	@Test(groups= {"sanity", "master"})
	public void validateAccountRegistration() {
		logger.info("********** Starting Account Registration Test *************");
		logger.debug("####### This is a debug log message ######");
		
		try {
		//create object of HomePage here first. Since you need to click on MyAccount and Register
		HomePage homepage = new HomePage(driver);
		logger.info("********* Clicking on MyAccount ***********");
		homepage.clickOnMyAccount();
		homepage.clickOnRegister();
		logger.info("********* Clicked on Register Link ***********");
		
		//Then create object of RegistrationPage and start calling the methods from there to test
		RegistrationPage regPage = new RegistrationPage(driver);
		logger.info("********* Providing Customer information ***********");
		regPage.setFirstName(randomString().toUpperCase());
		regPage.setLastName(randomString().toUpperCase());
		regPage.setEmail(randomString()+"@mail.com");
		regPage.setTelephone(randomNumber());
		String password = randomAlphaNumeric();
		regPage.setPassword(password);
		regPage.setConfirmPassword(password);
		regPage.chckPrivacyPolicy();
		regPage.clickContinue();
		
		logger.info("********* Validating expected message ***********");
		String confmsg = regPage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		logger.info("********* Account Registration Test Passed ***********");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			logger.info("********* Finished Account Registration Testing ***********");
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
