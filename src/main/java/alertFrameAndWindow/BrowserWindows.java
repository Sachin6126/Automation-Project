package alertFrameAndWindow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowserWindows {

	public BrowserWindows(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='Browser Windows']")
	WebElement clickBrowserWindows;

	@FindBy(css = "button[id='tabButton']")
	WebElement newTab;
	
	@FindBy(css = "button[id='windowButton']")
	WebElement newWindow;
	
	@FindBy(css = "button[id='messageWindowButton']")
	WebElement messageWindow;
	
	public WebElement clickBrowserWindows() {
		return clickBrowserWindows;
	}
	
	public WebElement newTab() {
		return newTab;
	}
	
	public WebElement newWindow() {
		return newWindow;
	}
	
	public WebElement messageWindow() {
		return messageWindow;
	}
}
