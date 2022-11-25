package Abstract;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	
	public static void scrollDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,440)");
	}
	
	public static void scrollUp(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("window.scrollBy(0,-900)");
	}
}
