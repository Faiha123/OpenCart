package testBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger; //Create object of Logger interface
	public Properties prop;

	// setup()
	// ValidateRegistration()
	// teardown()

	@BeforeClass(groups= {"sanity", "master","regression","ddt"})
	@Parameters({"OS","browser"})
	public void setup(String os, String br) throws IOException {
		
		//Load Properties File. using FileReader, not InputStream
		FileReader file = new FileReader("./src/test/resources/config.properties");
		prop = new Properties();
		prop.load(file);
		
		
		logger= LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase()) {
		
		case "chrome": driver = new ChromeDriver();break;
		case "firefox": driver = new FirefoxDriver();break;
		case "edge": driver = new EdgeDriver();break;
		default: System.out.println("Invalid Browser");return;
		
		}

		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		logger.info("******** Launching Application ***********");
		driver.get(prop.getProperty("appURL"));

	}

	@AfterClass(groups= {"sanity", "master","regression","ddt"})
	public void tearDown() {
		driver.quit();
	}

	public String randomString() {

		return RandomStringUtils.randomAlphabetic(5); // it generates strings each time

	}

	public String randomNumber() {
		return RandomStringUtils.randomNumeric(10);
	}

	public String randomAlphaNumeric() {
		String str = RandomStringUtils.randomAlphabetic(3); //abc_123
		String num = RandomStringUtils.randomNumeric(3);
		return (str + "_" + num);
	}
	
	public String captureScreenshot(String name) {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		TakesScreenshot takeScreenshot = (TakesScreenshot)driver;
		File src = takeScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath =  System.getProperty("user.dir")+"/screenshots/"+name+"_"+timeStamp+ ".png";		
		File targetFile = new File(targetFilePath);
		src.renameTo(targetFile);
		return targetFilePath;
	}
	
	
	

}
