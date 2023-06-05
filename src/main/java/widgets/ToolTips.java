package widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToolTips {

	public ToolTips(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Tool Tips']")
	WebElement clickToolTips;

	@FindBy(css = "input[id='toolTipTextField']")
	WebElement hoverTextField;

	@FindBy(css = "button[id='toolTipButton']")
	WebElement hoverMe;

	@FindBy(css = "div[class='tooltip-inner']")
	WebElement verifyTooltip;

	public WebElement clickToolTips() {
		return clickToolTips;
	}

	public WebElement hoverTextField() {
		return hoverTextField;
	}

	public WebElement hoverMe() {
		return hoverMe;
	}

	public WebElement verifyTooltip() {
		return verifyTooltip;
	}
}
