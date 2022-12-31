package shop.Tests;

import org.testng.annotations.Test;
import helpers.ProductActionHelper;
import BaseTest.BaseTest;

public class ProductPageOperationTest extends BaseTest{
	/*Perform add to cart, wishlist , compare perform from product page*/
	@Test(dependsOnGroups = {"LaunchShopTest.openBrowser"})
	public void productPageAction() throws InterruptedException {
		ProductActionHelper action = new ProductActionHelper(driver);
		/*Click First producct on page*/
		action.product.click();
		/*Change parameter according to need, Cart, Compare and Wishlist*/
		action.addProductTo("Cart", 1);
	}
}
