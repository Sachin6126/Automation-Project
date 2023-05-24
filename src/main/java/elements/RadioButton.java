package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButton {

	public RadioButton(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Radio Button']")
	WebElement radioButton;

	@FindBy(xpath="//input[@id='yesRadio']")
	WebElement yesButton;

	@FindBy(css = "input[id='impressiveRadio']")
	WebElement impressiveButton;

	@FindBy(css = "input[id='noRadio']")
	WebElement noButton;

	@FindBy(css = "span[class='text-success']")
	WebElement result;
	
	public WebElement radioButton() {
		return radioButton;
	}

	public WebElement yesButton() {
		return yesButton;
	}

	public WebElement impressiverButton() {
		return impressiveButton;
	}

	public WebElement noButton() {
		return noButton;
	}

	public WebElement result() {
		return result;
	}
}
