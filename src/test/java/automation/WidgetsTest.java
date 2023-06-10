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
import widgets.Menu;
import widgets.ProgressBar;
import widgets.SelectMenu;
import widgets.Slider;
import widgets.ToolTips;

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

	@Test
	public void verifySlider() throws InterruptedException {
		Actions mouse = new Actions(driver);
		mouse.scrollByAmount(0, 200).build().perform();
		Slider slider = new Slider(driver);
		slider.clickSlider().click();

		int value = 25;
		for (int i = 0; i < value; i++) {
			slider.moveSlider().sendKeys(Keys.ARROW_RIGHT);
		}

		int text = Integer.parseInt(slider.verifySlider().getAttribute("value"));

		Assert.assertEquals(text, (value + 25));
	}

	@Test
	public void verifyProgress() {
		Actions mouse = new Actions(driver);
		mouse.scrollByAmount(0, 200).build().perform();
		ProgressBar bar = new ProgressBar(driver);
		bar.clickProgressBar().click();

		bar.startButton().click();
		while (!bar.progressBar().getText().equalsIgnoreCase("50%")) {
		}
		Assert.assertEquals(bar.progressBar().getText(), "50%");
		bar.startButton().click();
	}

	@Test
	public void verifyTooltip() throws InterruptedException {
		Actions mouse = new Actions(driver);
		mouse.scrollByAmount(0, 350).build().perform();
		ToolTips tool = new ToolTips(driver);
		tool.clickToolTips().click();

		Thread.sleep(500);
		mouse.moveToElement(tool.hoverMe()).perform();
		String text = tool.verifyTooltip().getText();
		Assert.assertEquals(text, "You hovered over the Button");

		mouse.moveToElement(tool.hoverTextField()).perform();
		Thread.sleep(1000);
		text = tool.verifyTooltip().getText();
		Assert.assertEquals(text, "You hovered over the text field");
	}

	@Test
	public void verifyMenu() {
		Actions mouse = new Actions(driver);
		mouse.scrollByAmount(0, 400).build().perform();
		Menu menu = new Menu(driver);
		menu.clickMenu().click();

		mouse.moveToElement(menu.mainItem1()).perform();
		mouse.moveToElement(menu.mainItem3()).perform();
		mouse.moveToElement(menu.mainItem2()).perform();

		for (int i = 0; i < menu.subItems().size(); i++) {
			mouse.moveToElement(menu.subItems().get(i)).perform();
		}

		mouse.moveToElement(menu.subSubList()).perform();
		mouse.moveToElement(menu.subSubItem1()).perform();
		mouse.moveToElement(menu.subSubItem2()).perform();
	}

	@Test
	public void verifySelectMenu() throws InterruptedException {
		Actions mouse = new Actions(driver);
		mouse.scrollByAmount(0, 500).build().perform();
		SelectMenu menu = new SelectMenu(driver);
		menu.clickSelectMenu().click();
		driver.navigate().refresh();

		menu.selectGroup().sendKeys("roo");
		menu.selectGroup().sendKeys(Keys.ENTER);
		menu.selectTitle().sendKeys("d");
		menu.selectTitle().sendKeys(Keys.ENTER);

		Select color = new Select(menu.oldSelectMenu());
		color.selectByIndex(6);

		mouse.scrollByAmount(0, 200).build().perform();

		menu.selectMultiple().sendKeys("r");
		for (int i = 0; i < 4; i++) {
			menu.selectMultiple().sendKeys(Keys.ENTER);
		}

		Select cars = new Select(menu.selectCars());
		cars.selectByIndex(1);
		cars.selectByIndex(2);
		String expected[] = { "Saab", "Opel" };
		for (int i = 0; i < cars.getAllSelectedOptions().size(); i++) {
			String text = cars.getAllSelectedOptions().get(i).getText();
			Assert.assertEquals(text, expected[i]);
		}
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
