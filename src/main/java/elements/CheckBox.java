package elements;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBox {

	WebDriver driver;

	public CheckBox(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='Check Box']")
	WebElement checkBox;

	@FindBy(css = "span[class='rct-text'] button")
	WebElement arrow;

	@FindBy(css = "span[class='rct-checkbox']")
	List<WebElement> checkBoxes;

	@FindBy(css = "button[title='Expand all']")
	WebElement plusButton;

	@FindBy(css = "button[title='Collapse all']")
	WebElement minusButton;

	@FindBy(css = "div[id='result'] span")
	List<WebElement> result;

	public WebElement checkBox() {
		return checkBox;
	}

	public WebElement arrow() {
		return arrow;
	}

	public List<WebElement> checkBoxes() {
		return checkBoxes;
	}

	public WebElement plusButton() {
		return plusButton;
	}

	public WebElement minusButton() {
		return minusButton;
	}
	
	public List<WebElement> result() {
		return result;
	}
}
