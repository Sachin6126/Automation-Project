package automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtReport {
	public ExtentReports report;

	public ExtentReports getReports() {
		String path = System.getProperty("user.dir");
		Properties p = new Properties();
		FileInputStream file = null;

		try {
			file = new FileInputStream(path + "\\src\\main\\java\\automation\\data.properties");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		try {
			p.load(file);
		} catch (IOException e) {

			e.printStackTrace();
		}

		String reportPath = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);

		ExtentSparkReporterConfig config = reporter.config();
		config.setTheme(Theme.DARK);
		config.setDocumentTitle("Automation Project Report");
		config.setReportName("DEMOQA Test Report");

		report = new ExtentReports();
		report.setSystemInfo("OS", System.getProperty("os.name"));
//		report.setSystemInfo("Browser", cap.getBrowserName());
//		report.setSystemInfo("Browser version", cap.getBrowserVersion());
		report.setSystemInfo("URL", p.getProperty("url"));
		report.setSystemInfo("Java Version", System.getProperty("java.version"));

		report.attachReporter(reporter);

		return report;
	}
}
