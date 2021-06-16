package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
	public WebDriver driver;
	By email=By.cssSelector("#user_email");
	
	By sendInstructions=By.cssSelector("input[type='submit']");
	
	public ForgotPasswordPage(WebDriver driver) {
		
		this.driver=driver;
	}
 	public WebElement getEmail() {
 		return driver.findElement(email);
 	}
 	public WebElement sendInstruct() {
 		return driver.findElement(sendInstructions);
 	}
 	
}
