package widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProgressBar {

	public ProgressBar(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Progress Bar']")
	WebElement clickProgressBar;

	@FindBy(css = "div[role='progressbar']")
	WebElement progressBar;

	@FindBy(css = "button[id='startStopButton']")
	WebElement startButton;
	
	public WebElement clickProgressBar() {
		return clickProgressBar;
	}

	public WebElement progressBar() {
		return progressBar;
	}
	
	public WebElement startButton() {
		return startButton;
	}
}
