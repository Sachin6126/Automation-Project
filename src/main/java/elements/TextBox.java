package elements;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBox {
	WebDriver driver;

	public TextBox(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Text Box']")
	WebElement textBoxMenu;

	@FindBy(css = "input[id='userName']")
	WebElement fullName;

	@FindBy(css = "input[id='userEmail']")
	WebElement email;

	@FindBy(css = "textarea[id='currentAddress']")
	WebElement currentAddress;

	@FindBy(css = "textarea[id='permanentAddress']")
	WebElement permanentAddress;

	@FindBy(css = "button[id='submit']")
	WebElement submit;

	@FindBy(css = "div[id='output'] div p")
	List<WebElement> output;

	public WebElement textBoxMenu() {
		return textBoxMenu;
	}

	public WebElement fullName() {
		return fullName;
	}

	public WebElement email() {
		return email;
	}

	public WebElement currentAddress() {
		return currentAddress;
	}

	public WebElement permanentAddress() {
		return permanentAddress;
	}

	public WebElement submit() {
		return submit;
	}

	public List<WebElement> verifyOutput() {
		return output;
	}
}
