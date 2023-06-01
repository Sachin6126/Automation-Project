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

//	@FindBy(css = "div[id='framesWrapper'] div[id='frame1Wrapper'] iframe[id='frame1']")
//	WebElement bigFrame;

	@FindBy(id = "frame1")
	WebElement bigFrame;

	@FindBy(id = "frame2")
	WebElement smallFrame;

	@FindBy(css="body h1[id='sampleHeading']")
	WebElement verifyFrame1;

	@FindBy(css = "body h1[id='sampleHeading']")
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

	public WebElement bigFrame() {
		return bigFrame;
	}

	public WebElement smallFrame() {
		return smallFrame;
	}
}
