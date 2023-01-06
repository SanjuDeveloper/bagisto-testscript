package shop.Tests;

import org.testng.annotations.Test;
import Abstract.AbstractComponen;
import common.BaseTest;
import helpers.ProductActionHelper;
import shop.pageobjects.verifyShoppingCartProduct;

public class CustomerCheckoutTest extends BaseTest {
	@Test(dependsOnGroups= {"LaunchShopTest.openBrowser","CustomerLoginTest.customerLogin"})//,retryAnalyzer=Retry.class
	public void productCheckout() throws InterruptedException {
		 ProductActionHelper ProductActiohelper = new ProductActionHelper(driver);
		 verifyShoppingCartProduct verifyShoppingCartproduct = new verifyShoppingCartProduct(driver);
		 AbstractComponen homePage = new AbstractComponen(driver);
		 homePage.goToHomePage();
		 ProductActiohelper.checkAddButton();
		 verifyShoppingCartproduct.verifyShoppingCart();
		 verifyShoppingCartproduct.completeCheckoutProcess();
	}
}
