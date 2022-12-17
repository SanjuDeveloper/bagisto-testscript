package shop.Tests;

import org.testng.annotations.Test;
import BaseTest.BaseTest;
import helpers.ProductActionHelper;
import shop.pageobjects.verifyShoppingCartProduct;

public class productCheckoutTest extends BaseTest {
	@Test(dependsOnGroups= {"LaunchShopTest.openBrowser"})
	public void productCheckout() throws InterruptedException {
		 ProductActionHelper action = new ProductActionHelper(BaseTest.driver);
		 verifyShoppingCartProduct cart = new verifyShoppingCartProduct(BaseTest.driver);
		 action.checkAddButton();
		 cart.verifyShoppingCart();
	}
}
