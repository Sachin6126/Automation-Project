package automation;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import widgets.Accordian;
import widgets.AutoComplete;
import widgets.DatePicker;

public class WidgetsTest extends Base {
	WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initBrowser();
		driver.get(url + "widgets");
	}

	@Test
	public void verifyAccrodian() {
		Accordian accordian = new Accordian(driver);
		accordian.clickAccordian().click();

		for (int i = 0; i < accordian.header().size(); i++) {
			accordian.header().get(i).click();
		}
	}

	@Test
	public void verifyAutoComplete() throws InterruptedException {
		AutoComplete auto = new AutoComplete(driver);
		auto.clickAutoComplete().click();

		for (int i = 0; i < 3; i++) {
			auto.multiColor().sendKeys("r");
			auto.multiColor().sendKeys(Keys.ENTER);
		}

		ArrayList<String> actualColor = new ArrayList<String>();
		for (int i = 0; i < auto.verifyMultiColor().size(); i++) {
			actualColor.add(auto.verifyMultiColor().get(i).getText());
		}
		Assert.assertEquals(actualColor, auto.getColor());

		auto.singleColor().sendKeys("r");
		auto.singleColor().sendKeys(Keys.ENTER);

		String text = auto.verifySingleColor().getText();
		Assert.assertEquals(text, "Red");
	}

	@Test
	public void verifyDatePicker() {
		Actions scroll = new Actions(driver);
		scroll.scrollByAmount(0, 200).build().perform();
		DatePicker date = new DatePicker(driver);
		date.clickDatePicker().click();

		date.openCalendar().click();
		Select month = new Select(date.selectMonth());
		month.selectByIndex(1);

		Select year = new Select(date.selectYear());
		year.selectByValue("2025");

		for (int i = 0; i < date.selectDate().size(); i++) {
			String temp = date.selectDate().get(i).getText();
			if (temp.equalsIgnoreCase("20")) {
				date.selectDate().get(i).click();
				break;
			}
		}

		date.openDateTime().click();
		date.openMonth().click();

		for (int i = 0; i < date.chooseMonth().size(); i++) {
			String months = date.chooseMonth().get(i).getText();
			if (months.equalsIgnoreCase("february")) {
				date.chooseMonth().get(i).click();
				break;
			}
		}

		date.openYear().click();
		date.chooseYear().get(4).click();

		for (int i = 0; i < date.selectDate().size(); i++) {
			String temp = date.selectDate().get(i).getText();
			if (temp.equalsIgnoreCase("20")) {
				date.selectDate().get(i).click();
				break;
			}
		}

		for (int i = 0; i < date.chooseTime().size(); i++) {
			String time = date.chooseTime().get(i).getText();
			if (time.equalsIgnoreCase("15:30")) {
				date.chooseTime().get(i).click();
				break;
			}
		}
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
