package widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Slider {

	public Slider(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Slider']")
	WebElement clickSlider;

	@FindBy(css = "input[class='range-slider range-slider--primary']")
	WebElement moveSlider;

	@FindBy(css = "input[id='sliderValue']")
	WebElement verifySlider;
	
	public WebElement clickSlider() {
		return clickSlider;
	}

	public WebElement moveSlider() {
		return moveSlider;
	}
	
	public WebElement verifySlider() {
		return verifySlider;
	}
}
