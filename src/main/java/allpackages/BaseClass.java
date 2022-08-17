package allpackages;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;


import net.bytebuddy.utility.RandomString;

public class BaseClass {
	protected static WebDriver driver;
	
	// heloow manoj 
	public static void openBrowser(String browser) throws IOException
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "C:\\Software\\velocity\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(Utility_maven.readDataFromPropertyFile("URL"));
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Software\\velocity\\chromedriver_win32\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.get(Utility_maven.readDataFromPropertyFile("URL"));
		}
	}
	public void takingScreenShot(String test_case_name) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Date d=new Date();
		String date=d.toString().replace(":", "_");
		String random=RandomString.make(3);
		File destination=new File("C:\\Users\\Admin\\eclipse-workspace\\Velocity_corporate_training\\selenium_9th_april\\validate_user\\target./Scrrenshots/"+test_case_name+random+date+".png");
		//FileHandler.copy(src, destination);
		FileUtils.copyFile(src, destination);
	}
	

}
