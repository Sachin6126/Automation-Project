package automation;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import alertFrameAndWindow.Alerts;
import alertFrameAndWindow.BrowserWindows;
import alertFrameAndWindow.Frames;
import alertFrameAndWindow.ModalDialogs;
import alertFrameAndWindow.NestedFrames;

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
		
		alert.promptAlert().click();
		driver.switchTo().alert().dismiss();
		
		alert.promptAlert().click();
		driver.switchTo().alert().sendKeys("sachin");
		driver.switchTo().alert().accept();
		
		text=alert.verifyPromptAlert().getText();
		Assert.assertEquals(text, "You entered sachin");
	}
	
	@Test
	public void verifyFrames() {
		Frames frame=new Frames(driver);
		frame.clickFrames().click();
		
		driver.switchTo().frame(frame.bigFrame());
		String text=frame.verifyFrame1().getText();
		Assert.assertEquals(text, "This is a sample page");
		System.out.println("Verified frame1");
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(frame.smallFrame());
		Assert.assertEquals(text, "This is a sample page");
		System.out.println("Verified frame2");
		driver.switchTo().defaultContent();
	}

	@Test
	public void verifyNestedFrame() {
		Actions scroll =new Actions(driver);
		scroll.scrollByAmount(0, 200).build().perform();
		NestedFrames frame=new NestedFrames(driver);
		frame.clickNestedFrames().click();
		
		driver.switchTo().frame(frame.parentFrame());
		String text=frame.verifyParentFrame().getText();
		Assert.assertEquals(text, "Parent frame");
		System.out.println("Verified parent frame");
		
		driver.switchTo().frame(frame.childFrame());
		text=frame.verifyChildFrame().getText();
		Assert.assertEquals(text, "Child Iframe");
		System.out.println("Verified child frame");
	}
	
	@Test
	public void verifyModal() {
		Actions scroll =new Actions(driver);
		scroll.scrollByAmount(0, 200).build().perform();

		ModalDialogs modal =new ModalDialogs(driver);
		modal.clickModalDialogs().click();
		
		modal.showSmallModal().click();
		String text=modal.verifySmallModal().getText();
		Assert.assertEquals(text, "Small Modal");
		modal.closeSmallModal().click();
		
		modal.showLargeModal().click();
		text=modal.verifyLargeModal().getText();
		Assert.assertEquals(text, "Large Modal");
		modal.closeLargeModal().click();
	}
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
