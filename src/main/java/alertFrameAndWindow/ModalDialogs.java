package alertFrameAndWindow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModalDialogs {

	public ModalDialogs(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Modal Dialogs']")
	WebElement clickModalDialogs;

	@FindBy(css = "button[id='showSmallModal']")
	WebElement showSmallModal;

	@FindBy(css = "button[id='showLargeModal']")
	WebElement showLargeModal;

	@FindBy(css = "div[id='example-modal-sizes-title-sm']")
	WebElement verifySmallModal;

	@FindBy(css = "button[id='closeSmallModal']")
	WebElement closeSmallModal;

	@FindBy(css = "div[id='example-modal-sizes-title-lg']")
	WebElement verifyLargeModal;

	@FindBy(css = "button[id='closeLargeModal']")
	WebElement closeLargeModal;

	public WebElement clickModalDialogs() {
		return clickModalDialogs;
	}

	public WebElement showSmallModal() {
		return showSmallModal;
	}

	public WebElement showLargeModal() {
		return showLargeModal;
	}

	public WebElement verifySmallModal() {
		return verifySmallModal;
	}

	public WebElement closeSmallModal() {
		return closeSmallModal;
	}

	public WebElement verifyLargeModal() {
		return verifyLargeModal;
	}

	public WebElement closeLargeModal() {
		return closeLargeModal;
	}
}
