package automation;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtReport {
	public ExtentReports report;

	public ExtentReports getReports(){
		String reportPath = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);

		ExtentSparkReporterConfig config = reporter.config();
		config.setTheme(Theme.DARK);
		config.setDocumentTitle("Automation Project Report");
		config.setReportName("DEMOQA Test Report");

		report = new ExtentReports();
		report.attachReporter(reporter);

		return report;
	}
}
