package Abstract;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AbstractComponen extends AbstractLocator{
	WebDriver driver;	
	public AbstractComponen(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public  void waitForElementToAppear(By findBy) {
		WebDriverWait waite = new WebDriverWait(driver,Duration.ofSeconds(10)); 
		waite.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
	}
	
	public void waitForWebElementToAppear(WebElement findBy) {
		WebDriverWait waite = new WebDriverWait(driver,Duration.ofSeconds(10)); 
		waite.until(ExpectedConditions.visibilityOf(findBy));
		
	}
	
	public void waitForWebElementVisible(WebElement findBy) {
		WebDriverWait waite = new WebDriverWait(driver,Duration.ofSeconds(10)); 
		waite.until(ExpectedConditions.visibilityOfAllElements(findBy));
	}
	
	public void waitForWebElementToDisappear(WebElement findBy) {
		WebDriverWait waite = new WebDriverWait(driver,Duration.ofSeconds(5)); 
		waite.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public  void waitForWebElementToDisappear(By findBy) {
		WebDriverWait waite = new WebDriverWait(driver,Duration.ofSeconds(5)); 
		waite.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public  void waitForWebElementToClickable(WebElement findBy) {
		WebDriverWait waite = new WebDriverWait(driver,Duration.ofSeconds(5)); 
		waite.until(ExpectedConditions.elementToBeClickable(findBy));
	}
	
	public  void waitForWebElementToClickable(By findBy) {
		WebDriverWait waite = new WebDriverWait(driver,Duration.ofSeconds(5)); 
		waite.until(ExpectedConditions.elementToBeClickable(findBy));
	}
	
	public static void scrollDown(WebDriver driver,int to) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+to+")");
	}
	
	public static void scrollUp(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("window.scrollBy(0,-900)");
	}
	
	public void mouseHover(WebElement findBy) {
		Actions actionClass = new Actions(driver);
		actionClass.moveToElement(findBy).build().perform();
	}
	
	public void doubleClick(WebElement findBy) {
		Actions actionClass = new Actions(driver);
		actionClass.doubleClick(findBy).build().perform();
	}
	
	public Select selectDropdown(WebElement selectdropDown) {
		Select selectDrop = new Select(selectdropDown);
		return selectDrop;
	}
	
	public Float remove$(String price) {
	   Float actualPrice = Float.parseFloat(price.replaceAll("[^a-zA-Z0-9.]", ""));
	   return actualPrice;	
	}
	
	public String getScreenshot(String testClassNmae, WebDriver driver) throws IOException {
		TakesScreenshot ss = (TakesScreenshot) driver; //TakesScreenshot IS INTERFACE.
		File source = ss.getScreenshotAs(OutputType.FILE); //getScreenshotAs Is method of TakesScreenshot interface.
		File File = new File(System.getProperty("user.dir") + "//Reports//" + testClassNmae + ".png");
		FileUtils.copyFile(source, File); //copyFile is static method of FileUtils class
		return System.getProperty("user.dir") + "//Reports//" + testClassNmae + ".png";
	}
	
	public String getDate(String rquestType,String formatType) {
		Calendar calendar = Calendar.getInstance();  // get a calendar instance, which defaults to "now"	   	
		Date requestFormat = calendar.getTime();		 	
		return  new SimpleDateFormat(formatType).format(requestFormat);
	}
	
	public void handleCalendarDate(String date,String currentMonth) throws InterruptedException {
		 Select monthSelect = selectDropdown(selectMonth);
		 WebElement month = monthSelect.getFirstSelectedOption();
	     String selectedoption = month.getText();
	     boolean  selectedMonthIsCurrentMonth = selectedoption.equalsIgnoreCase(currentMonth);
	     if (! selectedMonthIsCurrentMonth) {
	    	 while (selectedoption != currentMonth) {
				 Thread.sleep(1000);
				 nextMonth.click(); // click on next arrow
			}
	     }
	     
	     handleLastDatesOfMonth(date); // check if next date is greater then last date of months.	     
	     //WebElement currentDate = dynamicDateLocator(date);
	     List<WebElement> currentMonthsDates = driver.findElements(By.xpath("//div[contains(@class,'open')]/div[2]/div[2]/div[2]//span[contains(@aria-label,"+currentMonth+")]"));
	     for (int i = 0; i < currentMonthsDates.size(); i++) {
			 String text = currentMonthsDates.get(i).getText(); // get text of dateBox
			if (text.equalsIgnoreCase(date)) {								
				currentMonthsDates.get(i).click(); // click on dateBox
				break;
			}
		}
	}
	
	/*
	 * Click on next button if next date if greater then 30 or 31
	 */
	public void handleLastDatesOfMonth(String date) {		
		if (Integer.parseInt(date) >= 27) {
			nextMonth.click();
		}	
	}
	// Go to View and Edit cart page
	public void goToCartPage() {
		 miniCart.click();
		 shoppingCart.click();
		}
		
		// Click Header logo to navigate to home page
	public void goToHomePage() {
		homeLogo.click();
		}
	
	public WebElement dynamicDateLocator(String day) {
		WebElement dayXpath = slectDayParent.findElement(By.xpath("//span[text()=\""+day+"\"]"));
	   return dayXpath;
	}
}