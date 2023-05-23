package automation;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import elements.CheckBox;
import elements.RadioButton;
import elements.TextBox;
import elements.WebTables;

public class ElementsTest extends Base {
	WebDriver driver;

	@BeforeTest
	public void openBrowser() throws IOException {
		driver = initBrowser();
		driver.get(url);
	}

	@Test
	public void verifyTextBox() throws IOException {
		String name = "sachin";
		String email = "a@a.com";
		String curAddress = "A-1/B abc Road Delhi";
		String perAddress = "A-1/B abc Road Delhi";
		String data[] = { "sachin", "a@a.com", "A-1/B abc Road Delhi", "A-1/B abc Road Delhi" };

		driver.findElement(By.xpath("//h5[text()='Elements']")).click();
		TextBox textBox = new TextBox(driver);
		textBox.textBoxMenu().click();
		textBox.fullName().sendKeys(name);
		textBox.email().sendKeys(email);
		textBox.currentAddress().sendKeys(curAddress);
		textBox.permanentAddress().sendKeys(perAddress);
		textBox.submit().click();

		for (int i = 0; i < textBox.verifyOutput().size(); i++) {
			String temp[] = textBox.verifyOutput().get(i).getText().split(":");
			String value = temp[1].trim();

			Assert.assertEquals(value, data[i]);
		}
	}

	@Test(dependsOnMethods = { "verifyTextBox" })
	public void verifyCheckBox() throws IOException {

		CheckBox check = new CheckBox(driver);
		check.checkBox().click();
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

	@Test(dependsOnMethods = { "verifyCheckBox" })
	public void verifyRadioButton() throws InterruptedException {
		RadioButton radio = new RadioButton(driver);
		radio.radioButton().click();
		Actions click = new Actions(driver);
		click.moveToElement(radio.yesButton()).click().build().perform();

		Assert.assertEquals(radio.result().getText(), "Yes");
		click.moveToElement(radio.impressiverButton()).click().build().perform();
		Assert.assertEquals(radio.result().getText(), "Impressive");
		Assert.assertFalse(radio.noButton().isEnabled());
	}

	@Test(dependsOnMethods = { "verifyRadioButton" })
	public void verifyWebTables() throws InterruptedException {
		WebTables table = new WebTables(driver);
		table.clickTable();
		
		for (int i = 0; i < table.getFirstRow().size(); i++) {
			String name = table.getFirstRow().get(i).getText();
			if (name.equalsIgnoreCase("Alden")) {
				table.editData().get(i).click();
				break;
			}
		}
		table.addLastName().clear();
		table.addLastName().sendKeys("Sharma");
		table.submit().click();;
		
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
		table.searchBox().sendKeys("Kier");
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
