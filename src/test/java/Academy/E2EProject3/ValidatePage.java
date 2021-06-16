package Academy.E2EProject3;

import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.Base;
import pageObjects.LandingPage;



public class ValidatePage extends Base{
	private static Logger log=LogManager.getLogger(ValidatePage.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException {
		driver= initializeDriver();
		driver.get(prop.getProperty("url"));
		
	}

	@Test(priority=2)
	public void centerTextCheck() throws IOException {
		
		//Creating an object of LandingPage class to access its page objects
		LandingPage l=new LandingPage(driver);
		Assert.assertEquals(l.getCenterText().getText(), "FEATURED COURSES9");
		log.info("Center text matches");
	}
	
	@Test(priority=1)
	public void rightNavBarValidation() throws IOException {
		
		//Creating an object of LandingPage class to access its page objects
		LandingPage l2=new LandingPage(driver);
		Assert.assertTrue(l2.getRightNavBar().isDisplayed());
		log.info("Navigation bar is displayed successfully");
	}
	
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
	
	
}
