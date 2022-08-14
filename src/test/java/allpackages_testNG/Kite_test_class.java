package allpackages_testNG;

import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import allpackages.BaseClass;
import allpackages.Kite_Home_Page;
import allpackages.Kite_Login_Page;
import allpackages.Kite_Pin_Page;
import allpackages.Utility_maven;

public class Kite_test_class extends BaseClass {
	Kite_Login_Page login;
	Kite_Pin_Page pin;
	Kite_Home_Page home;
  @Test
  public void mymethod() throws IOException {
	  String expected_User_id=Utility_maven.readDataFromPropertyFile("UID");
	  Assert.assertEquals(expected_User_id, home.get_uid_displayed(),"xpected & actual userid are not matching TC is fail");
	  Reporter.log("expected & actual id validated successfully",true);
	  takingScreenShot("kitevalidation");
  }
  
  @BeforeClass
  public void launchBrower() throws IOException
  {
	  openBrowser("chrome");
	  Utility_maven.implicitWait(driver, 1000);
	  Reporter.log("launching url",true);
	  login=new Kite_Login_Page(driver);
	  pin=new Kite_Pin_Page(driver);
	  home=new Kite_Home_Page(driver);
  }
  
  @BeforeMethod
  public void login_to_kite() throws IOException
  {
	  login.sendUserId(Utility_maven.readDataFromPropertyFile("UID"));
	  
	  login.sendPassword(Utility_maven.readDataFromPropertyFile("PWD"));
	  login.click_on_ligin_button();
	  Reporter.log("successfully logged in to kite login page");
	  Utility_maven.implicitWait(driver, 1000);
	  pin.send_pin(Utility_maven.readDataFromPropertyFile("PIN"));
	  pin.click_on_continue_button();
	  Reporter.log("welcome to home page",true);
	  Utility_maven.implicitWait(driver, 1000);
  }
  @AfterMethod
  public void logout() throws InterruptedException, IOException
  {
	  home.logout_button_method();
	  takingScreenShot("kitelogout");
	  Utility_maven.implicitWait(driver, 1000);
	 
  }
  @AfterClass
  public void closebrowser()
  {
	  driver.close();
  }
}
