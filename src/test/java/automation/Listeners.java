package automation;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners implements ITestListener {
	ExtentTest test;
	ExtReport rp = new ExtReport();

	/*
	 * To avoid mis-report in parallel mode we need to use Thread local, as in
	 * parallel mode ExtentTest "test" object may be overwritten by another method
	 * and may generate report for another test. So thread local will generate
	 * report for intended test only.
	 */
	// ThreadLocal<ExtentTest> extTest=new ThreadLocal<ExtentTest>();
	ExtentReports report = rp.getReports();

	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
		// extTest.set(test); //use this in parallel mode

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Success");

		// extTest.get().log(Status.PASS, "success");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());

		String name = result.getMethod().getMethodName();
		WebDriver driver = null;
		Base screen = new Base();

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {

		}
		try {
			test.addScreenCaptureFromPath(screen.getScreen(name, driver), name);
		} catch (Exception e) {

		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

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
