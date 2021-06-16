package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	By login=By.xpath("//a[@href='https://rahulshettyacademy.com/sign_in/']");
	By centerText=By.xpath("//h2[contains(text(),'Featured Courses')]");
	By rightNavBar=By.cssSelector(".nav.navbar-nav.navbar-right");

	public LandingPage(WebDriver driver) {
		
		this.driver=driver;
	}
 	public LoginPage getLogin() {
 		driver.findElement(login).click();
 		return new LoginPage(driver);
 		
 	}
 	
 	public WebElement getCenterText() {
 		return driver.findElement(centerText);
 	}
 	
 	public WebElement getRightNavBar() {
 		return driver.findElement(rightNavBar);
 	}
}