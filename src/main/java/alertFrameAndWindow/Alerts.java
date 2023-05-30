package alertFrameAndWindow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Alerts {

	public Alerts(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='Alerts']")
	WebElement clickAlerts;

	@FindBy(css = "button[id='alertButton']")
	WebElement instantAlert;
	
	@FindBy(css = "button[id='timerAlertButton']")
	WebElement delayedAlert;
	
	@FindBy(css = "button[id='confirmButton']")
	WebElement confirmationAlert;
	
	@FindBy(css = "span[id='confirmResult']")
	WebElement verifyConfirmationAlert;
	
	@FindBy(css = "button[id='promtButton']")
	WebElement promptAlert;
	
	@FindBy(css = "span[id='promptResult']")
	WebElement verifyPromptAlert;
	
	public WebElement clickAlerts() {
		return clickAlerts;
	}
	
	public WebElement instantAlert() {
		return instantAlert;
	}
	
	public WebElement delayedAlert() {
		return delayedAlert;
	}
	
	public WebElement confirmationAlert() {
		return confirmationAlert;
	}
	
	public WebElement verifyConfirmationAlert() {
		return verifyConfirmationAlert;
	}
	
	public WebElement promptAlert() {
		return promptAlert;
	}
	
	public WebElement verifyPromptAlert() {
		return verifyPromptAlert;
	}
}
