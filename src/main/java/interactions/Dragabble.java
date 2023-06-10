package interactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dragabble {

	public Dragabble(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Dragabble']")
	WebElement clickDragabble;

	@FindBy(id = "draggableExample-tab-simple")
	WebElement simpleTab;

	@FindBy(css = "div[id='dragBox']")
	WebElement dragMe;

	@FindBy(id = "draggableExample-tab-axisRestriction")
	WebElement axisRestrictTab;

	@FindBy(css = "div[class='axis-restriction-container mt-4'] div[id='restrictedX']")
	WebElement restrictedX;

	@FindBy(id = "restrictedY")
	WebElement restrictedY;

	@FindBy(css = "a[id='draggableExample-tab-containerRestriction']")
	WebElement containerRestrictedTab;

	@FindBy(css = "div[id='containmentWrapper'] div[class='draggable ui-widget-content ui-draggable ui-draggable-handle']")
	WebElement withinBox;

	@FindBy(css = "div[class='draggable ui-widget-content m-3'] span[class='ui-widget-header ui-draggable ui-draggable-handle']")
	WebElement textWithinBox;
	
//	@FindBy( = "//span[text()='I'm contained within my parent']")
//	WebElement textWithinBox;

	@FindBy(id = "draggableExample-tab-cursorStyle")
	WebElement cursorStyleTab;

	@FindBy(id = "cursorCenter")
	WebElement StickCenter;

	@FindBy(id = "cursorTopLeft")
	WebElement stickTopLeft;

	@FindBy(id = "cursorBottom")
	WebElement stickBottom;

	public WebElement clickDragable() {
		return clickDragabble;
	}

	public WebElement simpleTab() {
		return simpleTab;
	}

	public WebElement dragMe() {
		return dragMe;
	}

	public WebElement axisRestrictTab() {
		return axisRestrictTab;
	}

	public WebElement restrictedX() {
		return restrictedX;
	}

	public WebElement restrictedY() {
		return restrictedY;
	}

	public WebElement containerRestrictedTab() {
		return containerRestrictedTab;
	}

	public WebElement withinBox() {
		return withinBox;
	}

	public WebElement textWithinBox() {
		return textWithinBox;
	}

	public WebElement cursorStyleTab() {
		return cursorStyleTab;
	}

	public WebElement StickCenter() {
		return StickCenter;
	}

	public WebElement stickTopLeft() {
		return stickTopLeft;
	}

	public WebElement stickBottom() {
		return stickBottom;
	}
}
