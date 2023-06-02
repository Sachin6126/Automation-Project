package widgets;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutoComplete {
	public AutoComplete(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Auto Complete']")
	WebElement clickAutoComplete;

	@FindBy(css = "input[id='autoCompleteMultipleInput']")
	WebElement multiColor;

	@FindBy(css = "input[id='autoCompleteSingleInput']")
	WebElement singleColor;

	@FindBy(css = "div[class='css-12jo7m5 auto-complete__multi-value__label']")
	List<WebElement> verifyMultiColor;
	
	@FindBy(css = "div[class='auto-complete__single-value css-1uccc91-singleValue']")
	WebElement verifySingleColor;

	public WebElement clickAutoComplete() {
		return clickAutoComplete;
	}

	public WebElement multiColor() {
		return multiColor;
	}

	public WebElement singleColor() {
		return singleColor;
	}
	
	public List<WebElement> verifyMultiColor() {
		return verifyMultiColor;
	}
	
	public WebElement verifySingleColor() {
		return verifySingleColor;
	}
	
	public ArrayList<String> getColor() {
		ArrayList<String> color=new ArrayList<String>();
		color.add("Red");
		color.add("Green");
		color.add("Purple");
		
		return color;
	}
}
