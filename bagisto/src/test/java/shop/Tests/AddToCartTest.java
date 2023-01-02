package shop.Tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import common.BaseTest;
import helpers.ProductActionHelper;
import shop.TestComponents.Retry;

public class AddToCartTest extends BaseTest  {
	/*TestNg wali file mai LaunchShopTest wali class ko define krna rhega tb verifyProductCount() wala function call hoga maven cmd ke through */
	@Test(dependsOnGroups = {"LaunchShopTest.openBrowser"},retryAnalyzer=Retry.class)
	public void addToCart() throws InterruptedException, IOException {
		ProductActionHelper helper = new ProductActionHelper(BaseTest.driver);
		String  success_message = helper.addProductTo("Cart",1);
		System.out.println(success_message);
		Assert.assertEquals(success_message, "Success! Item is successfully added to cart..");	
	}
}