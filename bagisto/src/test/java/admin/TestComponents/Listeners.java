package admin.TestComponents;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener {
	
	
	ExtentTest test; // variable declare
	ExtentReports extent = ExtentReporterNG.getReportObject();  // static function call from ExtentReporterNG() class
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); //Thread safe
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = ((ExtentReports) extent).createTest(result.getMethod().getMethodName()); 
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
			}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);

				String FilePath=null;
				extentTest.get().fail(result.getThrowable());
				// get driver obj from restlt parameter, because the result have all data of test class even WebDriver also.
				
				try {
				
					driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());			
					//getTestClass -> testNG.XML m jo testClass ka name h vo.
					//getRealClass-> JO testNG.xml test class ki Actual class.java h uska name
					// getField -> class ka jo filed chhiye usko passs krenge. 
					// getInstance-> is se hme WeDriver class ka object mil jayega.
					// Yha p hm class ko access kr re h kyu ki WebDriver driver class label pr set hota h na ki function label pr.s		
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					FilePath = getScreenshot(result.getMethod().getMethodName(), driver); // take screenshot by getScreenshot() method of base class
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				extentTest.get().addScreenCaptureFromPath(FilePath, result.getMethod().getMethodName()); //store screenshot to given path		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
