package allpackages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//hi Manoj
public class Kite_Login_Page {
	@FindBy(id="userid") private WebElement user_id;
	@FindBy(id="password") private WebElement pwd;
	@FindBy(xpath="//button[@type='submit']") private WebElement login_button;
	
	public Kite_Login_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void sendUserId(String uid)
	{
		user_id.sendKeys(uid);
	}
	
	public void sendPassword(String password)
	{
		pwd.sendKeys(password);
	}
	public void click_on_ligin_button() {
		login_button.click();
	}

}
