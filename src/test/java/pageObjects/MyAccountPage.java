package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//After login, you land on this page

public class MyAccountPage extends BasePage{
	
	//Constructor
	//Locators
	//Action Methods

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	//My Account text xpath
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement msgHeading;
	
	//Logout button xpath
	@FindBy(xpath="//a[@class='list-group-item' and text()='Logout']")
	WebElement link_logout;
	
	//check if My Account text displays
	public boolean isMyAccountPageDisplays() {
		try {
		return msgHeading.isDisplayed();
		}catch(Exception e) {
			return (false);
		}
	}
	
	
	//click on Logout
	public void clickOnLogout() {
		link_logout.click();
	}

}
