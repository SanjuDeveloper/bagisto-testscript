package shop.Tests;
import java.io.IOException;

import org.testng.annotations.Test;

import shop.TestComponents.*;
import shop.pageobjects.HomePage;
import shop.pageobjects.ProductListing;


public class AddToCartVerify extends baseTest {
	
	@Test
	public void  initail() throws IOException {
		HomePage obj = launcShop();	
		obj.ProductAddToCart();
	}
	
	
}
