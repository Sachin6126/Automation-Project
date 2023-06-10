package interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sortable {

	WebDriver driver;

	public Sortable(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Sortable']")
	WebElement clickSortable;

	@FindBy(id = "demo-tab-list")
	WebElement tabList;

	@FindBy(id = "demo-tab-grid")
	WebElement gridTab;

	String gridSort = "//div[@class='create-grid'] //div[text()='";

	String listSort = "//div[@class='vertical-list-container mt-4'] //div[text()='";

	public WebElement gridSort(String a) {

		return driver.findElement(By.xpath(gridSort + a + "']"));
	}

	public WebElement listSort(String a) {

		return driver.findElement(By.xpath(listSort + a + "']"));
	}
	
	public WebElement clickSortable() {
		return clickSortable;
	}

	public WebElement tabList() {
		return tabList;
	}

	public WebElement gridTab() {
		return gridTab;
	}
}
