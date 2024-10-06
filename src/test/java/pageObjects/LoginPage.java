package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	//Constructor
	//WebElements
	//Action Methods
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@name='email']")
	WebElement txtEml;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement txtPasswd;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;
	
	public void setEml(String eml) {
		txtEml.sendKeys(eml);
	}
	
	public void setPasswd(String passwd) {
		txtPasswd.sendKeys(passwd);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	
	
	
	

}
