package shop.Tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import BaseTest.BaseTest;

public class wish extends BaseTest{
	//(dependsOnGroups= {"LaunchShopTest.openBrowser","CustomerLoginTest.customerLogin"})
 @Test
 public static void wishList() throws IOException {
	 driver.get("http://localhost/bagisto/public/");
	 BaseTest.driver.findElement(By.xpath("//a[@aria-label=\"Logo\"]")).click();
	 JavascriptExecutor js = (JavascriptExecutor) BaseTest.driver;
	 js.executeScript("window.scrollBy(0,900)");
	 WebDriverWait wait = new WebDriverWait(BaseTest.driver,Duration.ofSeconds(5));
	   Actions actionClass = new Actions(BaseTest.driver);
   wait.until(ExpectedConditions.visibilityOf(BaseTest.driver.findElement(By.xpath("//div[@class=\"product-price\"]"))));
	   actionClass.moveToElement(BaseTest.driver.findElement(By.xpath("//div[@class=\"product-price\"]"))).build().perform();
		BaseTest.driver.findElement(By.xpath("//a[@title=\"Add product to wishlist\"]")).click();
 }
}
