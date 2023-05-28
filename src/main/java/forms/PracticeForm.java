package forms;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PracticeForm {
	
	public PracticeForm(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Practice Form']")
	WebElement clickPracticeForm;

	@FindBy(css = "input[id='firstName']")
	WebElement firstName;

	@FindBy(css = "input[id='lastName']")
	WebElement lastName;

	@FindBy(css = "input[id='userEmail']")
	WebElement email;

	@FindBy(css = "div[class='custom-control custom-radio custom-control-inline'] label[class='custom-control-label']")
	List<WebElement> gender;

	@FindBy(css = "input[id='userNumber']")
	WebElement phoneNumber;

	@FindBy(css = "input[id='dateOfBirthInput']")
	WebElement openCalendar;
	
	@FindBy(css = "select[class='react-datepicker__month-select']")
	WebElement selectMonth;
	
	@FindBy(css = "select[class='react-datepicker__year-select']")
	WebElement selectYear;
	
	@FindBy(css = "div[class='react-datepicker__week'] div[role='option']")
	List<WebElement> selectDate;
	
	@FindBy(css = "input[id='subjectsInput']")
	WebElement subject;
	
	@FindBy(css = "div[class='custom-control custom-checkbox custom-control-inline'] label[class='custom-control-label']")
	List<WebElement> checkboxes;
	
	@FindBy(css = "input[id='uploadPicture']")
	WebElement uploadPicture;
	
	@FindBy(css = "textarea[id='currentAddress']")
	WebElement currentAddress;	
	
	@FindBy(css = "input[id='react-select-3-input']")
	WebElement state;
	
	@FindBy(css = "input[id='react-select-4-input']")
	WebElement city;

	public WebElement clickPracticeForm() {
		return clickPracticeForm;
	}

	public WebElement firstName() {
		return firstName;
	}

	public WebElement lastName() {
		return lastName;
	}

	public WebElement email() {
		return email;
	}

	public List<WebElement> gender() {
		return gender;
	}

	public WebElement phoneNumber() {
		return phoneNumber;
	}

	public WebElement openCalendar() {
		return openCalendar;
	}
	
	public WebElement selectMonth() {
		return selectMonth;
	}
	
	public WebElement selectYear() {
		return selectYear;
	}
	
	public List<WebElement> selectDate() {
		return selectDate;
	}
	
	public WebElement subject() {
		return subject;
	}
	
	public List<WebElement> checkboxes() {
		return checkboxes;
	}
	
	public WebElement uploadPicture() {
		return uploadPicture;
	}
	
	public WebElement state() {
		return state;
	}
	
	public WebElement currentAddress() {
		return currentAddress;
	}
	
	public WebElement city() {
		return city;
	}
}
