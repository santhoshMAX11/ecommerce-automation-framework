package TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import resources.ExtentReporterNG;

public class listeners extends baseTest implements ITestListener {
     
	
	

	ExtentTest testlog;// To store the test log object for the current test method
	ExtentReports extentreport = ExtentReporterNG.getReportObject();
	
	@Override
	public void onTestStart(ITestResult result) {
		
		testlog = extentreport.createTest(result.getMethod().getMethodName());
	    System.out.println(">>> onTestStart() called for " + result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		testlog.pass("Test passed successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		testlog.fail(result.getThrowable());
		try {
			WebDriver driver = ((baseTest) result.getInstance()).driver;
            String filepath = ((baseTest) result.getInstance()).getScreenshot(result.getMethod().getMethodName(),driver);
            testlog.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());

		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		 
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
		extentreport.flush();
	 //cleanup thread-loacal
	}

	@Override
	protected void finalize() throws Throwable {
	}

}
