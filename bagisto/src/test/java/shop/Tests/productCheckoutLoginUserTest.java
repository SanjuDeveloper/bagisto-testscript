package shop.Tests;

import org.testng.annotations.Test;
import BaseTest.BaseTest;
import helpers.ProductActionHelper;
import shop.TestComponents.Retry;
import shop.pageobjects.verifyShoppingCartProduct;

public class productCheckoutLoginUserTest extends BaseTest {
	@Test(dependsOnGroups= {"LaunchShopTest.openBrowser","CustomerLoginTest.customerLogin"},retryAnalyzer=Retry.class)
	public void productCheckout() throws InterruptedException {
		 ProductActionHelper ProductActiohelper = new ProductActionHelper(BaseTest.driver);
		 verifyShoppingCartProduct verifyShoppingCartproduct = new verifyShoppingCartProduct(BaseTest.driver);
		 ProductActiohelper.goToHomePage();
		 ProductActiohelper.checkAddButton();
		 verifyShoppingCartproduct.verifyShoppingCart();
		 verifyShoppingCartproduct.completeCheckoutProcess();
	}
}
