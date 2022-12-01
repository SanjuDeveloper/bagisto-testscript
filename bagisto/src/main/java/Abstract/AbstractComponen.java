package Abstract;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class AbstractComponen {
	WebDriver driver;	
	public AbstractComponen(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public  void waitForElementToAppear(By findBy) {
		WebDriverWait waite = new WebDriverWait(driver,Duration.ofSeconds(5)); 
		waite.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForWebElementToAppear(WebElement findBy) {
		WebDriverWait waite = new WebDriverWait(driver,Duration.ofSeconds(5)); 
		waite.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void waitForWebElementToDisappear(WebElement findBy) {
		WebDriverWait waite = new WebDriverWait(driver,Duration.ofSeconds(5)); 
		waite.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	
	public static void scrollDown(WebDriver driver,int to) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+to+")");
	}
	
	public static void scrollUp(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("window.scrollBy(0,-900)");
	}
	
	public String getScreenshot(String testClassNmae, WebDriver driver) throws IOException {
		TakesScreenshot ss = (TakesScreenshot) driver; //TakesScreenshot IS INTERFACE.
		File source = ss.getScreenshotAs(OutputType.FILE); //getScreenshotAs Is method of TakesScreenshot interface.
		File File = new File(System.getProperty("user.dir") + "//Reports//" + testClassNmae + ".png");
		FileUtils.copyFile(source, File); //copyFile is static method of FileUtils class
		return System.getProperty("user.dir") + "//Reports//" + testClassNmae + ".png";
	}
}
