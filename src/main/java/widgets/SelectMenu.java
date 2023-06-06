package widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectMenu {

	public SelectMenu(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Select Menu']")
	WebElement clickSelectMenu;

	@FindBy(css = "input[id='react-select-2-input']")
	WebElement selectGroup;

	@FindBy(css = "input[id='react-select-3-input']")
	WebElement selectTitle;

	@FindBy(css = "input[id='react-select-4-input']")
	WebElement selectMultiple;

	@FindBy(css = "select[id='oldSelectMenu']")
	WebElement oldSelectMenu;

	@FindBy(css = "select[id='cars']")
	WebElement selectCars;

	public WebElement clickSelectMenu() {
		return clickSelectMenu;
	}

	public WebElement selectGroup() {
		return selectGroup;
	}

	public WebElement selectTitle() {
		return selectTitle;
	}
	
	public WebElement selectMultiple() {
		return selectMultiple;
	}
	
	public WebElement oldSelectMenu() {
		return oldSelectMenu;
	}
	
	public WebElement selectCars() {
		return selectCars;
	}
	
}
