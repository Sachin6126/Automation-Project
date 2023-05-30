package alertFrameAndWindow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NestedFrames {

	public NestedFrames(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Nested Frames']")
	WebElement clickNestedFrames;

	@FindBy(css = "iframe[id='frame1']")
	WebElement parentFrame;

	@FindBy(css = "body")
	WebElement verifyParentFrame;

	@FindBy(css = "iframe[srcdoc='<p>Child Iframe</p>']")
	WebElement childFrame;

	@FindBy(css = "body p")
	WebElement verifyChildFrame;

	public WebElement clickNestedFrames() {
		return clickNestedFrames;
	}

	public WebElement parentFrame() {
		return parentFrame;
	}

	public WebElement verifyParentFrame() {
		return verifyParentFrame;
	}

	public WebElement childFrame() {
		return childFrame;
	}

	public WebElement verifyChildFrame() {
		return verifyChildFrame;
	}
}
