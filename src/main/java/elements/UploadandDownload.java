package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadandDownload {
	
	public UploadandDownload(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Upload and Download']")
	WebElement clickUpnD;

	@FindBy(css = "a[id='downloadButton']")
	WebElement downloadButton;

	@FindBy(css = "input[id='uploadFile']")
	WebElement uploadButton;

	@FindBy(css = "p[id='uploadedFilePath']")
	WebElement VerifyUpload;

	public WebElement clickUpnD() {
		return clickUpnD;
	}

	public WebElement downloadButton() {
		return downloadButton;
	}

	public WebElement uploadButton() {
		return uploadButton;
	}

	public WebElement VerifyUpload() {
		return VerifyUpload;
	}

}
