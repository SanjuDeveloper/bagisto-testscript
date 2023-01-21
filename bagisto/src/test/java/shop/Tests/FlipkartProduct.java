package shop.Tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import common.BaseTest;

public class FlipkartProduct extends BaseTest {
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
	
		System.out.println(allProducts.size());
		for (int i = 0; i < allProducts.size(); i++) {
			int price = remove$(productPrice.get(i).getText());
			ss.add(price);
		}
		int smallestPrice = getSmallest(ss);
		System.out.println(smallestPrice);
		for (int i = 0; i < allProducts.size(); i++) {
			if(smallestPrice == remove$(productPrice.get(i).getText())){
				System.out.println(productName.get(i).getText());
				System.out.println(remove$(productPrice.get(i).getText()));
			}
		}
	}

	public int remove$(String price) {
		int actualPrice = (int) Float.parseFloat(price.replaceAll("[^a-zA-Z0-9.]", ""));
		return actualPrice;
	}

	public static int getSmallest(ArrayList ss) {
		int min = (int) ss.get(0);
		System.out.println("size"+ss.size());
		for (int i = 0; i < ss.size(); i++) {
			if ((int) ss.get(i) < min) {
				min = (int) ss.get(i);
			}
		}
		return min;
	}
}
