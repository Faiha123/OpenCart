package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BasePage{
	
	
	
	public RegistrationPage(WebDriver driver) {
		
		super(driver);
	}
	
	@FindBy(xpath="//input[@name='firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@name='lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@name='telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@name='confirm']")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement checkBoxPrivacyPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	
	
	public void setFirstName(String fName) {
		txtFirstName.sendKeys(fName);
	}
	
	public void setLastName(String lName) {
		txtLastName.sendKeys(lName);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String tel) {
		txtTelephone.sendKeys(tel);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String cpwd) {
		txtConfirmPassword.sendKeys(cpwd);
	}
	
	public void chckPrivacyPolicy() {
		checkBoxPrivacyPolicy.click();
	}
	
	public void clickContinue() {
		//option1
		btnContinue.click();
		
		//option2
		//btnContinue.submit();
		
//		//option3		
//		Actions act = new Actions(driver);
//		act.moveToElement(btnContinue).click().perform();

	//option4
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//	js.executeScript("arguments[0].click();", btnContinue);
		
		//option5
//		btnContinue.sendKeys(Keys.RETURN);  //Interview Q: can you click with the help of sendKeys?
	
		
		//option6
//		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
//	
	
	
	
	}
	
	@FindBy(xpath="//h1[contains(text(),'Your Account Has Been Created!')]")
	WebElement msgConfirmation;
	
	public String getConfirmationMsg() {
		try {
		 return msgConfirmation.getText();
		}catch(Exception e) {
			return e.getMessage();
		}
	}
	
	
	
}
