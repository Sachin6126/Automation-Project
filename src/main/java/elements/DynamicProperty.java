package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicProperty {

	public DynamicProperty(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Dynamic Properties']")
	WebElement clickDynamicProperty;

	@FindBy(css = "p[id='7uRP8']")
	WebElement headerText;

	@FindBy(css = "button[id='enableAfter']")
	WebElement enableButtonAfter;

	@FindBy(css = "button[id='colorChange']")
	WebElement colorButton;

	@FindBy(css = "button[id='visibleAfter']")
	WebElement visibleButtonAfter;

	public WebElement clickDynamicProperty() {
		return clickDynamicProperty;
	}

	public WebElement headerText() {
		return headerText;
	}

	public WebElement enableButtonAfter() {
		return enableButtonAfter;
	}

	public WebElement colorButton() {
		return colorButton;
	}
	
	public WebElement visibleButtonAfter() {
		return visibleButtonAfter;
	}
}
