package widgets;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Accordian {

	public Accordian(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='Accordian']")
	WebElement clickAccordian;
	
	@FindBy(css="div[class='card-header']")
	List<WebElement> header;
	
	public WebElement clickAccordian() {
		return clickAccordian;
	}
	
	public List<WebElement> header() {
		return header;
	}
}
