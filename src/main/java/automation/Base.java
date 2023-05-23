package automation;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Base {
	WebDriver driver;
	String url;

	public WebDriver initBrowser() throws IOException {
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\automation\\data.properties";
		FileInputStream file = new FileInputStream(path);
		Properties properties = new Properties();
		properties.load(file);
		String browser = properties.getProperty("browser");
		url = properties.getProperty("url");

		if (browser.contains("chrome")) {
			ChromeOptions setting = new ChromeOptions();
			if (browser.contains("headless")) {
				setting.addArguments("headless"); // to run chrome in background without showing on screen
			}
			driver = new ChromeDriver(setting);
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
}
