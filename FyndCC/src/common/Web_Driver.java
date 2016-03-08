package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Web_Driver extends ReportLogger {
	public static ChromeDriver thisdriver;
	public static WebDriverWait driverwait;
	public static AllControls control = new AllControls();
	
	public static void initiate_WebDriver()
	{
		try
		{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rahul Patil\\Downloads\\chromedriver_win32\\chromedriver.exe");
	thisdriver = new ChromeDriver();
	thisdriver.manage().window().maximize();
	WriteLog("********************************************************************************************");
	logger.info("Webdriver initiated - Google Chrome");
	thisdriver.get("http://obscuro-staging.gofynd.com/login");
	logger.info("URL Fetched - http://obscuro-staging.gofynd.com/login");
	WriteLog("********************************************************************************************");
	driverwait = new WebDriverWait(thisdriver, 45);
	Thread.sleep(2000);
		}
		catch(Exception e)
		{
			
		}
		
	}
	
	public static boolean dynamicwaitVisible(String Locator, long timeout )
	{
		try{
		driverwait = new WebDriverWait(thisdriver, timeout);
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Locator)));
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
			
		
		
	}
}
