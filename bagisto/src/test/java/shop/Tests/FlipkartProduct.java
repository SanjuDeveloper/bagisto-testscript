package shop.Tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class FlipkartProduct  {
	@Test
	public void flipKart() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		ArrayList<Integer> ss = new ArrayList();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.cssSelector("button[class=\"_2KpZ6l _2doB4z\"]")).click();
		driver.findElement(By.cssSelector("input[title*=\"Search\"]")).sendKeys("core i5", Keys.ENTER);
		Thread.sleep(3000);
		List<WebElement> allProducts = driver.findElements(By.cssSelector("div[class=\"_13oc-S\"]"));
		List<WebElement> productName = driver.findElements(By.cssSelector("div[class=\"_4rR01T\"]"));
		List<WebElement> productPrice = driver.findElements(By.cssSelector("div[class=\"_30jeq3 _1_WHN1\"]"));
		for (int i = 0; i < allProducts.size(); i++) {
			int price = Integer.parseInt(productPrice.get(i).getText().replaceAll("[^a-zA-Z0-9.]", ""));
			ss.add(price);
		}
		int smallestPrice = Collections.min(ss);
		for (int i = 0; i < allProducts.size(); i++) {
			if(smallestPrice == Integer.parseInt(productPrice.get(i).getText().replaceAll("[^a-zA-Z0-9.]", ""))){
				System.out.println(productName.get(i).getText());
				System.out.println(Integer.parseInt(productPrice.get(i).getText().replaceAll("[^a-zA-Z0-9.]", "")));
			}
		}
	}
}
