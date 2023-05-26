package automation;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtReport {
	public ExtentReports report;

	public ExtentReports getReports() {
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Automation Project Report");
		reporter.config().setReportName("Sachin");
		report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Tester Name", "Sachin");

		return report;
	}
}
