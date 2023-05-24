package elements;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTables {

	public WebTables(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Web Tables']")
	WebElement clickWebTables;

	@FindBy(css = "button[id='addNewRecordButton']")
	WebElement addData;

	@FindBy(css = "input[id='searchBox']")
	WebElement searchBox;

	@FindBy(css = "span[title='Edit']")
	List<WebElement> editData;

	@FindBy(css = "span[title='Delete']")
	List<WebElement> deleteButton;

	@FindBy(css = "input[id='firstName']")
	WebElement addFirstName;

	@FindBy(css = "input[id='lastName']")
	WebElement addLastName;

	@FindBy(css = "input[id='userEmail']")
	WebElement addEmail;
	
	@FindBy(css = "input[id='age']")
	WebElement addAge;

	@FindBy(css = "input[id='salary']")
	WebElement addsalary;

	@FindBy(css = "input[id='department']")
	WebElement addDepartment;

	@FindBy(css = "button[id='submit']")
	WebElement submit;
	
	@FindBy(xpath = "//div[@class='rt-table'] //div[@role='row']/div[1]")
	List<WebElement> firstRow;

	public WebElement clickTable() {
		return clickWebTables;
	}

	public WebElement addData() {
		return addData;
	}

	public WebElement searchBox() {
		return searchBox;
	}

	public List<WebElement> editData() {
		return editData;
	}

	public List<WebElement> deleteButton() {
		return deleteButton;
	}

	public WebElement addFirstName() {
		return addFirstName;
	}

	public WebElement addLastName() {
		return addLastName;
	}

	public WebElement addEmail() {
		return addEmail;
	}

	public WebElement addsalary() {
		return addsalary;
	}

	public WebElement addDepartment() {
		return addDepartment;
	}

	public WebElement submit() {
		return submit;
	}
	
	public WebElement addAge() {
		return addAge;
	}
	
	public List<WebElement> getFirstRow() {
		return firstRow;
	}
}
