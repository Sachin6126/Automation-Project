package automation;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import elements.Buttons;
import elements.CheckBox;
import elements.DynamicProperty;
import elements.Links;
import elements.RadioButton;
import elements.TextBox;
import elements.UploadandDownload;
import elements.WebTables;

public class ElementsTest extends Base {
	WebDriver driver;

	@BeforeTest
	public void openBrowser() throws IOException {
		deleteReport();
		driver = initBrowser();
		driver.get(url + "elements");
	}

	@Test
	public void verifyTextBox() {
		String name = "sachin";
		String email = "a@a.com";
		String curAddress = "A-1/B abc Road Delhi";
		String perAddress = "A-1/B abc Road Delhi";
		String data[] = { "sachin", "a@a.com", "A-1/B abc Road Delhi", "A-1/B abc Road Delhi" };
		TextBox textBox = new TextBox(driver);
		textBox.textBoxMenu().click();
		textBox.fullName().sendKeys(name);
		textBox.email().sendKeys(email);
		textBox.currentAddress().sendKeys(curAddress);
		textBox.permanentAddress().sendKeys(perAddress);
		Actions click = new Actions(driver);
		click.scrollByAmount(0, 200).build().perform();
		textBox.submit().click();

		for (int i = 0; i < textBox.verifyOutput().size(); i++) {
			String temp[] = textBox.verifyOutput().get(i).getText().split(":");
			String value = temp[1].trim();

			Assert.assertEquals(value, data[i]);
		}
	}

	@Test
	public void verifyCheckBox() {
		CheckBox check = new CheckBox(driver);
		check.checkBox().click();
		Actions click = new Actions(driver);
		click.scrollByAmount(0, 200).build().perform();
		check.arrow().click();
		check.plusButton().click();

		for (int i = 0; i < check.checkBoxes().size(); i++) {
			check.checkBoxes().get(i).click();
		}
		check.minusButton().click();

		check.checkBoxes().get(0).click();

		for (int i = 0; i < check.result().size(); i++) {
			System.out.println(check.result().get(i).getText());
		}
	}

	@Test
	public void verifyRadioButton() throws InterruptedException {
		RadioButton radio = new RadioButton(driver);
		radio.radioButton().click();
		Thread.sleep(500);
		Actions click = new Actions(driver);
		click.moveToElement(radio.yesButton()).click().build().perform();

		Assert.assertEquals(radio.result().getText(), "Yes");
		click.moveToElement(radio.impressiverButton()).click().build().perform();
		Assert.assertEquals(radio.result().getText(), "Impressive");
		Assert.assertFalse(radio.noButton().isEnabled());
	}

	@Test
	public void verifyWebTables() {
		WebTables table = new WebTables(driver);
		table.clickTable().click();
		;

		for (int i = 0; i < table.getFirstRow().size(); i++) {
			String name = table.getFirstRow().get(i).getText();
			if (name.equalsIgnoreCase("Alden")) {
				table.editData().get(i).click();
				break;
			}
		}
		table.addLastName().clear();
		table.addLastName().sendKeys("Sharma");
		table.submit().click();
		;

		table.addData().click();
		table.addFirstName().sendKeys("Sachin");
		table.addLastName().sendKeys("Sharma");
		table.addEmail().sendKeys("a@a.com");
		table.addAge().sendKeys("23");
		table.addsalary().sendKeys("10000");
		table.addDepartment().sendKeys("IT");
		table.submit().click();

		for (int i = 0; i < table.getFirstRow().size(); i++) {
			String name = table.getFirstRow().get(i).getText();
			if (name.equalsIgnoreCase("Sachin")) {
				Assert.assertTrue(true);
				break;
			}
		}
		table.searchBox().sendKeys("sachin");
		table.deleteButton().get(0).click();
	}

	@Test
	public void verifyButtons() {
		Buttons button = new Buttons(driver);
		button.clickButtons().click();
		Actions click = new Actions(driver);
		click.moveToElement(button.doubleClick()).doubleClick().build().perform();
		click.moveToElement(button.rightClick()).contextClick().build().perform();
		button.clickMe().click();
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("You have done a right click");
		expected.add("You have done a double click");
		expected.add("You have done a dynamic click");

		for (int i = 0; i < button.verify().size(); i++) {
			String actual = button.verify().get(i).getText();
			if (expected.contains(actual)) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}
	}

	@Test
	public void verifyLinks() throws InterruptedException {

		Links links = new Links(driver);
		links.clickLinks().click();
		links.homeLink().click();
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(parent);
		int j = 0;
		for (int i = 2; i < links.allLinks().size(); i++) {
			links.allLinks().get(i).click();
			Thread.sleep(500);
			String actualCode = links.linkResponse().get(0).getText();
			String expectedCode = links.codes().get(j);

			Assert.assertEquals(actualCode, expectedCode);
			j++;
		}

	}

	@Test
	public void verifyUploadnDownload() throws InterruptedException {
		UploadandDownload ud = new UploadandDownload(driver);
		Actions click = new Actions(driver);
		click.scrollByAmount(0, 200).build().perform();
		ud.clickUpnD().click();
		ud.downloadButton().click();

		File file = new File(downloadPath + "\\sampleFile.jpeg");
		Thread.sleep(5000);

		if (file.exists()) {
			Assert.assertTrue(true);
			System.out.println("Downloaded file found");
		} else {
			System.out.println("Downloaded file not found");
			Assert.assertTrue(false);
		}

		Thread.sleep(500);
		file.delete();

		if (file.exists()) {
			System.out.println("Downloaded file not deleted");
			Assert.assertTrue(false);
		} else {
			System.out.println("Downloaded file deleted");
			Assert.assertTrue(true);
		}

		ud.uploadButton().sendKeys(downloadPath + "\\sampleUploadFile.txt");
		Thread.sleep(2000);
		if (ud.VerifyUpload().getText().contains("sampleUploadFile.txt")) {
			Assert.assertTrue(true);
			System.out.println("file uploaded successfully");
		} else {
			System.out.println("upload failed");
			Assert.assertTrue(false);
		}
	}

	@Test
	public void verifyDynamicProperty() {
		DynamicProperty property = new DynamicProperty(driver);
		Actions click = new Actions(driver);
		click.scrollByAmount(0, 200).build().perform();
		property.clickDynamicProperty().click();
		String text = property.headerText().getText();
		Assert.assertEquals(text, "This text has random Id");
		Assert.assertFalse(property.enableButtonAfter().isEnabled());

		String a = property.colorButton().getCssValue("color");
		Assert.assertEquals(a, "rgba(255, 255, 255, 1)");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(property.enableButtonAfter()));
		property.enableButtonAfter().click();

		a = property.colorButton().getCssValue("color");
		Assert.assertEquals(a, "rgba(220, 53, 69, 1)");
		Assert.assertTrue(property.visibleButtonAfter().isDisplayed());

	}

	@AfterTest
	public void closeBrowser() {

		driver.close();
	}
}
