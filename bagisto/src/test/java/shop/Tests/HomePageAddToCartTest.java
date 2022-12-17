package shop.Tests;

import org.testng.annotations.Test;
import BaseTest.BaseTest;
import helpers.ProductActionHelper;

public class HomePageAddToCartTest extends BaseTest{
	@Test(dependsOnGroups= {"LaunchShopTest.openBrowser"})
	public void AddTOCartDisableCheck() throws InterruptedException {
		ProductActionHelper action = new ProductActionHelper(BaseTest.driver);
		/*Click First producct on page*/
		action.product.click();
		/*Change parameter according to need, Cart, Compare and Wishlist*/
		action.addProductTo("Cart", 1);
	}
}
