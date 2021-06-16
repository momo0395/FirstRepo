package Resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {
		// TODO Auto-generated method stub
		
		
		prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\su\\eclipse-workspace\\E2EProject2\\src\\main\\java\\Resources\\config.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			//Driver initiation for chrome
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\su\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			ChromeOptions handlingSSL=new ChromeOptions();
			handlingSSL.setAcceptInsecureCerts(true);
			driver=new ChromeDriver(handlingSSL);
		}
		
		else if(browserName.equals("firefox")) {
			//Driver initiation for firefox
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\su\\.m2\\repository\\org\\seleniumhq\\selenium\\selenium-firefox-driver\\3.141.59\\selenium-firefox-driver-3.141.59");
			driver=new FirefoxDriver();
		}
		
		else if(browserName.equals("IE")) {
			//Driver initiation for internet explorer
			System.setProperty("webdriver.ie.driver", "C:\\Users\\su\\.m2\\repository\\org\\seleniumhq\\selenium\\selenium-ie-driver\\3.141.59\\selenium-ie-driver-3.141.59");
			driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	
	public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File f=ts.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(f, new File(destination));
		return destination;
	}

}
