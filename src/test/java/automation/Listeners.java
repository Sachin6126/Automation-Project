package automation;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Listeners extends Base implements ITestListener {
	ExtentTest test;
	ExtReport rp = new ExtReport();

	ExtentReports report = rp.getReports();

	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName()).assignAuthor("Sachin").assignDevice("Chrome");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass("Success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		
		String name = result.getMethod().getMethodName();
		WebDriver driver = null;

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {

		}
		try {
			test.addScreenCaptureFromPath(getScreen(name, driver), name);
		} catch (Exception e) {

		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.skip("Test Skipped");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {

		report.flush();
	}

}
