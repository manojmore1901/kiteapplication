package allpackages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Kite_Home_Page {
	@FindBy(xpath="//span[@class='user-id']") private WebElement displayed_uid;
	@FindBy(xpath="//a[@target='_self']") private WebElement logout_button;
	
	public Kite_Home_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String get_uid_displayed()
	{
		String actual_user_id = displayed_uid.getText();
		return actual_user_id;
	}
	public void logout_button_method() throws InterruptedException
	{
		displayed_uid.click();
		Thread.sleep(2000);
		logout_button.click();
	}

}
