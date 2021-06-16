package Academy.E2EProject3;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.Base;
import pageObjects.ForgotPasswordPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class HomePage extends Base{
	private static Logger log=LogManager.getLogger(HomePage.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException {
		driver= initializeDriver();
	}
	
	
	@Test(dataProvider="getData")
	public void loginMultiple(String emailid, String password, String text) throws IOException {
		
		driver.get(prop.getProperty("url"));
		log.info("Opened the URL");
		
		//Creating an object of LandingPage class to access its page objects
				LandingPage l=new LandingPage(driver);
				
				LoginPage lp=l.getLogin();
				lp.getEmail().sendKeys(emailid);
				lp.getPassword().sendKeys(password);
				log.info(text);
				lp.getSubmitButton().click();
			log.info("clicked login");
			ForgotPasswordPage fpg=lp.getForgotPassword();
			fpg.getEmail().sendKeys("momo");
			fpg.sendInstruct().click();
		
		
		
	}
	
	
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData() {
		//number of rows are equal to the types of data
		//number of columns are equal to the number of inputs in each type 
		Object[][] data=new Object[2][3];
		data[0][0]="restricteduser@qc.com";
		data[0][1]="restricted21";
		data[0][2]="restricted-user";
		
		data[1][0]="non-restricteduser@qc.com";
		data[1][1]="non-restricted21";
		data[1][2]="non-restricted-user";
		
		return data;
	}
	
}
