package elements;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Links {
	ArrayList<String> code=new ArrayList<String>();
	
	
	public Links(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Links']")
	WebElement clickLinks;

	@FindBy(css = "a[id='simpleLink']")
	WebElement homeLink;

	@FindBy(css = "a[id='created']")
	WebElement createdLink;

	@FindBy(css = "a[id='no-content']")
	WebElement noContentLink;

	@FindBy(css = "a[id='moved']")
	WebElement movedLink;

	@FindBy(css = "a[id='bad-request']")
	WebElement badRequestLink;
	
	@FindBy(css = "a[id='unauthorized']")
	WebElement unauthorizedLink;
	
	@FindBy(css = "a[id='forbidden']")
	WebElement forbiddenLink;
	
	@FindBy(css = "a[id='invalid-url']")
	WebElement notFoundLink;
	
	@FindBy(css = "p[id='linkResponse'] b")
	List<WebElement> linkResponse;
	
	@FindBy(css = "p a[id]")
	List<WebElement> allLinks;

	public WebElement clickLinks() {
		return clickLinks;
	}

	public WebElement homeLink() {
		return homeLink;
	}

	public WebElement createdLink() {
		return createdLink;
	}

	public WebElement noContentLink() {
		return noContentLink;
	}

	public WebElement movedLink() {
		return movedLink;
	}
	
	public WebElement badRequestLink() {
		return badRequestLink;
	}
	
	public WebElement unauthorizedLink() {
		return unauthorizedLink;
	}
	
	public WebElement forbiddenLink() {
		return forbiddenLink;
	}
	
	public WebElement notFoundLink() {
		return notFoundLink;
	}

	public List<WebElement> linkResponse() {
		return linkResponse;
	}
	
	public List<WebElement> allLinks() {
		return allLinks;
	}
	public ArrayList<String> codes() {
		code.add("201");
		code.add("204");
		code.add("301");
		code.add("400");
		code.add("401");
		code.add("403");
		code.add("404");
		
		return code;
	}
}
