package widgets;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Menu {

	public Menu(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Menu']")
	WebElement clickMenu;

	@FindBy(xpath = "//a[text()='Main Item 1']")
	WebElement mainItem1;
	
	@FindBy(xpath = "//a[text()='Main Item 2']")
	WebElement mainItem2;
	
	@FindBy(xpath = "//a[text()='Main Item 3']")
	WebElement mainItem3;
	
	@FindBy(xpath = "//a[text()='Sub Item']")
	List<WebElement> subItems;
	
	@FindBy(xpath = "//a[text()='SUB SUB LIST »']")
	WebElement subSubList;
	
	@FindBy(xpath = "//a[text()='Sub Sub Item 1']")
	WebElement subSubItem1;
	
	@FindBy(xpath = "//a[text()='Sub Sub Item 2']")
	WebElement subSubItem2;
	
	public WebElement clickMenu() {
		return clickMenu;
	}

	public WebElement mainItem1() {
		return mainItem1;
	}
	
	public WebElement mainItem2() {
		return mainItem2;
	}
	
	public WebElement mainItem3() {
		return mainItem3;
	}
	
	public List<WebElement> subItems() {
		return subItems;
	}
	
	public WebElement subSubList() {
		return subSubList;
	}
	
	public WebElement subSubItem1() {
		return subSubItem1;
	}
	
	public WebElement subSubItem2() {
		return subSubItem2;
	}
}
