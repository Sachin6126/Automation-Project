package elements;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Buttons {
	
	public Buttons(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='Buttons']")
	WebElement clickButtons;

	@FindBy(css = "button[id='doubleClickBtn']")
	WebElement doubleClick;

	@FindBy(css = "button[id='rightClickBtn']")
	WebElement rightClick;

	@FindBy(xpath = "//button[text()='Click Me']")
	WebElement clickMe;
	
	@FindBy(css = "div p[id]")
	List<WebElement> verify;

	public WebElement clickButtons() {
		return clickButtons;
	}

	public WebElement doubleClick() {
		return doubleClick;
	}

	public WebElement rightClick() {
		return rightClick;
	}

	public WebElement clickMe() {
		return clickMe;
	}
	
	public List<WebElement> verify() {
		return verify;
	}
}
