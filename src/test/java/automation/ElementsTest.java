package automation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import elements.Buttons;
import elements.CheckBox;
import elements.Links;
import elements.RadioButton;
import elements.TextBox;
import elements.WebTables;

public class ElementsTest extends Base {
	@BeforeTest
	public void openBrowser() throws IOException {
		driver = initBrowser();
		driver.get(url);
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
	public void verifyRadioButton() {
		RadioButton radio = new RadioButton(driver);
		radio.radioButton().click();
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
		int j=0;
		for(int i=2;i<links.allLinks().size();i++) {
			links.allLinks().get(i).click();
			Thread.sleep(500);
			String actualCode=links.linkResponse().get(0).getText();
			String expectedCode=links.codes().get(j);
			
			Assert.assertEquals(actualCode, expectedCode);
			j++;
		}
		

	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
