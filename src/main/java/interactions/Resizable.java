package interactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Resizable {

	public Resizable(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Resizable']")
	WebElement clickResizable;

	@FindBy(css = "div[id='resizableBoxWithRestriction'] span[class='react-resizable-handle react-resizable-handle-se']")
	WebElement limitedResizabe;
	
	@FindBy(css = "div[id='resizable'] span[class='react-resizable-handle react-resizable-handle-se']")
	WebElement freeResizabe;

	public WebElement clickResizable() {
		return clickResizable;
	}

	public WebElement limitedResizabe() {
		return limitedResizabe;
	}
	
	public WebElement freeResizabe() {
		return freeResizabe;
	}
}
