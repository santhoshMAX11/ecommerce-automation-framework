package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	
	public static ExtentReports getReportObject()
	{
		String path= System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter report =new ExtentSparkReporter(path);
		
		ExtentReports extent =new ExtentReports();
		extent.attachReporter(report);
		return extent;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
