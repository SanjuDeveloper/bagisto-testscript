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
	//ITestListener is a interface povided by testng
	@Override
	public void onTestStart(ITestResult result) {
		//Entry point for test
		test = extent.createTest(result.getMethod().getMethodName());
	}
	
	public void onTestSuccesst(ITestResult result) {
		//To-DO on Test Succcess
	}
	
	public void onTestFailure(ITestResult result) {
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
		test.addScreenCaptureFromPath(path, result.getMethod().getMethodName());
	}
	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}
}
