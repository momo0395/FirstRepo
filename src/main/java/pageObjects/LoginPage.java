package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;
	By email=By.cssSelector("#user_email");
	By password=By.cssSelector("#user_password");
	By submit=By.cssSelector("input[type='submit']");
	By forgotPass=By.linkText("Forgot Password?");
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
	}
 	public WebElement getEmail() {
 		return driver.findElement(email);
 	}
 	public WebElement getPassword() {
 		return driver.findElement(password);
 	}
 	public WebElement getSubmitButton() {
 		return driver.findElement(submit);
 	}
 	public ForgotPasswordPage getForgotPassword() {
 		driver.findElement(forgotPass).click();
 		return new ForgotPasswordPage(driver);
 		
 		
 		
 	}
}
