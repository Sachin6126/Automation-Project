package automation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Base {
	public WebDriver driver;
	String url;
	String path;
	String downloadPath;

	public WebDriver initBrowser() throws IOException {

		path = System.getProperty("user.dir");
		FileInputStream file = new FileInputStream(path + "\\src\\main\\java\\automation\\data.properties");
		Properties properties = new Properties();
		properties.load(file);
		String browser = properties.getProperty("browser");
		url = properties.getProperty("url");

		if (browser.contains("chrome")) {
			ChromeOptions settings = new ChromeOptions();
			// To define download file location
			downloadPath = System.getProperty("user.dir") + "\\src\\main\\java\\automation";
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", downloadPath);
			settings.setExperimentalOption("prefs", chromePrefs);

			if (browser.contains("headless")) {
				settings.addArguments("headless"); // To run chrome in background without showing on screen
			}
			driver = new ChromeDriver(settings);
		}

		else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		else if (browser.equalsIgnoreCase("ie")) {
			driver = new InternetExplorerDriver();

		}

		else if (browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();

		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;

	}

	public String getScreen(String testname, WebDriver driver) throws IOException {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String outputFile = System.getProperty("user.dir") + "\\reports\\" + testname + ".png";
		FileUtils.copyFile(file, new File(outputFile));

		return outputFile; // We are returning file path to attach this in report otherwise ignore return
	}

	public void deleteReport() throws IOException {
		File delete = new File(System.getProperty("user.dir") + "\\reports\\");
		FileUtils.cleanDirectory(delete);
	}
}
