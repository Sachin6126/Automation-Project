package automation;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import alertFrameAndWindow.Alerts;
import alertFrameAndWindow.BrowserWindows;

public class AlertFrameAndWindowTest extends Base {

	WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initBrowser();
		driver.get(url + "alertsWindows");
	}

	@Test
	public void browserWindow() {
		BrowserWindows browser = new BrowserWindows(driver);
		browser.clickBrowserWindows().click();
		browser.newTab().click();

		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parent = it.next();
		String id = it.next();

		driver.switchTo().window(id);
		String text = driver.findElement(By.id("sampleHeading")).getText();
		Assert.assertEquals(text, "This is a sample page");

		driver.close();
		driver.switchTo().window(parent);
	}

	@Test
	public void verifyAlerts() throws InterruptedException {
		Alerts alert = new Alerts(driver);
		alert.clickAlerts().click();
		alert.instantAlert().click();
		driver.switchTo().alert().accept();

		alert.delayedAlert().click();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();

		alert.confirmationAlert().click();
		driver.switchTo().alert().accept();
		String text = alert.verifyConfirmationAlert().getText();
		Assert.assertEquals(text, "You selected Ok");

		alert.confirmationAlert().click();
		driver.switchTo().alert().dismiss();
		text = alert.verifyConfirmationAlert().getText();
		Assert.assertEquals(text, "You selected Cancel");
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
