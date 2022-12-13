package shop.TestComponents;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import BaseTest.BaseTest;
import resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener  {
	ExtentTest test;
	ExtentReports extent  = ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal(); // Each Test have separat id, this is use to overcome concurrency issue is test case execution
	//ITestListener is a interface povided by testng
	@Override
	public void onTestStart(ITestResult result) {
		//Entry point for test
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test); //Unique thread id
	}
	
	public void onTestSuccesst(ITestResult result) {
		//To-DO on Test Succcess
	}
	
	public void onTestFailure(ITestResult result) {
	    extentTest.get().fail(result.getThrowable());
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String path = null;
		try {
			path = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(path, result.getMethod().getMethodName());
	}
	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}
}
