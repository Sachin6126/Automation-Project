package widgets;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DatePicker {

	public DatePicker(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Date Picker']")
	WebElement clickDatePicker;

	@FindBy(css = "input[id='datePickerMonthYearInput']")
	WebElement openCalendar;

	@FindBy(css = "div[class='react-datepicker__week'] div[role='option']")
	List<WebElement> selectDate;

	@FindBy(css = "select[class='react-datepicker__month-select']")
	WebElement selectMonth;

	@FindBy(css = "select[class='react-datepicker__year-select']")
	WebElement selectYear;

	@FindBy(css = "input[id='dateAndTimePickerInput']")
	WebElement openDateTime;

	@FindBy(css = "span[class='react-datepicker__month-read-view--selected-month']")
	WebElement openMonth;

	@FindBy(css = "div[class='react-datepicker__month-option']")
	List<WebElement> chooseMonth;

	@FindBy(css = "span[class='react-datepicker__year-read-view--selected-year']")
	WebElement openYear;

	@FindBy(css = "div[class='react-datepicker__year-option']")
	List<WebElement> chooseYear;

	@FindBy(css = "li[class='react-datepicker__time-list-item ']")
	List<WebElement> chooseTime;

	public WebElement clickDatePicker() {
		return clickDatePicker;
	}

	public WebElement openCalendar() {
		return openCalendar;
	}

	public List<WebElement> selectDate() {
		return selectDate;
	}

	public WebElement selectMonth() {
		return selectMonth;
	}

	public WebElement selectYear() {
		return selectYear;
	}
	
	public WebElement openMonth() {
		return openMonth;
	}
	
	public List<WebElement> chooseMonth() {
		return chooseMonth;
	}
	
	public WebElement openYear() {
		return openYear;
	}
	
	public List<WebElement> chooseYear() {
		return chooseYear;
	}
	
	public List<WebElement> chooseTime() {
		return chooseTime;
	}
	
	public WebElement openDateTime() {
		return openDateTime;
	}
}
