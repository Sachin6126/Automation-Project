package interactions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Selectable {

	public Selectable(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Selectable']")
	WebElement clickSelectable;

	@FindBy(id = "demo-tab-list")
	WebElement tabList;

	@FindBy(id = "demo-tab-grid")
	WebElement gridTab;
	
	@FindBy(css = "li[class*='mt-2 list-group-item']")
	List<WebElement> listSelect;
	
	@FindBy(css ="div[class='list-group list-group-horizontal-sm'] li[class*='list-group-item']")
	List<WebElement> gridSelect;

	public WebElement clickSelectable() {
		return clickSelectable;
	}

	public List<WebElement> listSelect() {
		return listSelect;
	}
	
	public List<WebElement> gridSelect() {
		return gridSelect;
	}
	
	public WebElement tabList() {
		return tabList;
	}

	public WebElement gridTab() {
		return gridTab;
	}
}
