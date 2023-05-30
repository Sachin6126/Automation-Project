package alertFrameAndWindow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Frames {

	public Frames(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='Frames']")
	WebElement clickFrames;

	@FindBy(css = "h1[id='sampleHeading']")
	WebElement verifyFrame1;
	
	@FindBy(css = "h1[id='sampleHeading']")
	WebElement verifyFrame2;
	
	public WebElement clickFrames() {
		return clickFrames;
	}
	
	public WebElement verifyFrame1() {
		return verifyFrame1;
	}
	
	public WebElement verifyFrame2() {
		return verifyFrame2;
	}
}
