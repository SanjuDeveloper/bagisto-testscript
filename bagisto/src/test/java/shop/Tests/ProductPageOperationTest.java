package shop.Tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import helpers.ProductAction;
import shop.TestComponents.baseTest;

public class ProductPageOperationTest extends baseTest{
	/*Perform add to cart, wishlist , compare perform from product page*/
	@Test(dependsOnGroups = {"LaunchShopTest.openBrowser"})
	public void productPageAction() throws InterruptedException {
		ProductAction action = new ProductAction(baseTest.driver);
		/*Click First producct on page*/
		action.product.click();
		/*Change parameter according to need, Cart, Compare and Wishlist*/
		action.addProductTo("Cart", 1);
	}
}
