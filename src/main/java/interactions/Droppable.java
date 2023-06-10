package interactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Droppable {

	public Droppable(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Droppable']")
	WebElement clickDroppable;

	@FindBy(id = "droppableExample-tab-simple")
	WebElement simpleTab;

	@FindBy(css = "div[id='draggable']")
	WebElement dragMe;

	@FindBy(css = "div[id='droppable']")
	WebElement dropHere;
	
	@FindBy(css = "div[id='droppable'] p")
	WebElement verifyDrophere;

	@FindBy(id = "droppableExample-tab-accept")
	WebElement acceptTab;

	@FindBy(xpath = "//div[text()='Acceptable']")
	WebElement acceptableDrag;

	@FindBy(id = "notAcceptable")
	WebElement notAcceptableDrag;
	
	@FindBy(css = "div[id='acceptDropContainer'] div[id='droppable']")
	WebElement acceptDropHere;
	
	@FindBy(css = "div[id='acceptDropContainer'] div[id='droppable'] p")
	WebElement verifyAcceptDrophere;

	@FindBy(id = "droppableExample-tab-preventPropogation")
	WebElement preventPropagationTab;

	@FindBy(id = "dragBox")
	WebElement dragBox;

	@FindBy(id = "notGreedyInnerDropBox")
	WebElement innerDroppable;

	@FindBy(id = "notGreedyDropBox")
	WebElement outerDroppable;

	@FindBy(id = "greedyDropBoxInner")
	WebElement greedyInnerDroppable;

	@FindBy(id = "greedyDropBox")
	WebElement greedyOuterDroppable;

	@FindBy(id = "droppableExample-tab-revertable")
	WebElement revertDraggableTab;

	@FindBy(id = "revertable")
	WebElement revertable;

	@FindBy(id = "notRevertable")
	WebElement notRevertable;

	@FindBy(id = "droppable")
	WebElement revertableDroppable;
	
	@FindBy(css = "div[id='revertableDropContainer'] div[id='droppable']")
	WebElement verifyRevertDrop;

	public WebElement clickDroppable() {
		return clickDroppable;
	}

	public WebElement simpleTab() {
		return simpleTab;
	}

	public WebElement dragMe() {
		return dragMe;
	}

	public WebElement dropHere() {
		return dropHere;
	}

	public WebElement acceptTab() {
		return acceptTab;
	}

	public WebElement acceptableDrag() {
		return acceptableDrag;
	}

	public WebElement notAcceptableDrag() {
		return notAcceptableDrag;
	}

	public WebElement preventPropagationTab() {
		return preventPropagationTab;
	}

	public WebElement dragBox() {
		return dragBox;
	}

	public WebElement innerDroppable() {
		return innerDroppable;
	}

	public WebElement outerDroppable() {
		return outerDroppable;
	}

	public WebElement greedyInnerDroppable() {
		return greedyInnerDroppable;
	}

	public WebElement greedyOuterDroppable() {
		return greedyOuterDroppable;
	}

	public WebElement revertDraggableTab() {
		return revertDraggableTab;
	}

	public WebElement revertable() {
		return revertable;
	}

	public WebElement notRevertable() {
		return notRevertable;
	}

	public WebElement revertableDroppable() {
		return revertableDroppable;
	}
	
	public WebElement verifyDrophere() {
		return verifyDrophere;
	}
	
	public WebElement acceptDropHere() {
		return acceptDropHere;
	}
	
	public WebElement verifyAcceptDrophere() {
		return verifyAcceptDrophere;
	}

	public WebElement verifyRevertDrop() {
		return verifyRevertDrop;
	}
}
