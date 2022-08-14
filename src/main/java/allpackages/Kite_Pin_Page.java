package allpackages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Kite_Pin_Page {
	@FindBy(id="pin") private WebElement pin;
	@FindBy(xpath="//button[@type='submit']") private WebElement continue_button;
	
	public Kite_Pin_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void send_pin(String pin_no)
	{
		pin.sendKeys(pin_no);
	}
	public void click_on_continue_button()
	{
		continue_button.click();
	}

}
