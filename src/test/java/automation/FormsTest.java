package automation;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import forms.PracticeForm;

public class FormsTest extends Base {
	WebDriver driver;
	@BeforeMethod
	public void initialize() throws IOException {
		driver = initBrowser();
		driver.get(url + "forms");
	}

	@Test(dataProvider = "getData")
	public void verifyForms(String fName, String lName, String email, String gen, String phone, String months,
			String years, String dates, String subject, String hobby, String address, String state, String city)
			throws InterruptedException, IOException {

		PracticeForm form = new PracticeForm(driver);
		form.clickPracticeForm().click();
		Actions click = new Actions(driver);

		form.firstName().sendKeys(fName);
		form.lastName().sendKeys(lName);
		form.email().sendKeys(email);

		for (int i = 0; i < form.gender().size(); i++) {
			String name = form.gender().get(i).getText();

			if (name.equalsIgnoreCase(gen)) {
				click.moveToElement(form.gender().get(i)).click().build().perform();
			}
		}

		form.phoneNumber().sendKeys(phone);
		form.openCalendar().click();
		Select month = new Select(form.selectMonth());
		month.selectByVisibleText(months);
		Select year = new Select(form.selectYear());
		year.selectByVisibleText(years);

		for (int i = 0; i < form.selectDate().size(); i++) {
			String date = form.selectDate().get(i).getText();
			if (date.equalsIgnoreCase(dates)) {
				form.selectDate().get(i).click();
				break;
			}
		}

		form.subject().sendKeys(subject);
		form.subject().sendKeys(Keys.ENTER);

		for (int i = 0; i < form.checkboxes().size(); i++) {
			String name = form.checkboxes().get(i).getText();
			if (name.equalsIgnoreCase(hobby)) {
				click.moveToElement(form.checkboxes().get(i)).click().build().perform();
				break;
			}
		}

		form.uploadPicture().sendKeys(downloadPath + "\\sampleUploadFile.txt");
		form.currentAddress().sendKeys(address);
		form.state().sendKeys(state, Keys.ENTER);
		form.city().sendKeys(city, Keys.ENTER);
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData() {
		Object data[][] = new Object[3][13];
		data[0][0] = ""; // first name
		data[0][1] = ""; // last name
		data[0][2] = ""; // email
		data[0][3] = "male"; // gender
		data[0][4] = ""; // phone
		data[0][5] = "February"; // month
		data[0][6] = "2024"; // year
		data[0][7] = "1"; // date
		data[0][8] = "m"; // subject
		data[0][9] = "sports"; // hobby
		data[0][10] = ""; // address
		data[0][11] = "n"; // state
		data[0][12] = "d"; // city

		data[1][0] = "abc"; // first name
		data[1][1] = "cde"; // last name
		data[1][2] = "abc"; // email
		data[1][3] = "female"; // gender
		data[1][4] = "adjhjhf"; // phone
		data[1][5] = "February"; // month
		data[1][6] = "1998"; // year
		data[1][7] = "7"; // date
		data[1][8] = "e"; // subject
		data[1][9] = "reading"; // hobby
		data[1][10] = "A-1 rohini delhi"; // address
		data[1][11] = "n"; // state
		data[1][12] = "d"; // city

		data[2][0] = "sjb"; // first name
		data[2][1] = "kdk"; // last name
		data[2][2] = "a@a.com"; // email
		data[2][3] = "other"; // gender
		data[2][4] = "0000000000"; // phone
		data[2][5] = "February"; // month
		data[2][6] = "2000"; // year
		data[2][7] = "2"; // date
		data[2][8] = "p"; // subject
		data[2][9] = "music"; // hobby
		data[2][10] = "A-1 rohini delhi"; // address
		data[2][11] = "u"; // state
		data[2][12] = "a"; // city

		return data;

	}
}
