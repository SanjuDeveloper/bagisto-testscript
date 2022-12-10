package shop.Tests;

import java.io.IOException;
import org.testng.annotations.Test;
import BaseTest.BaseTest;
import helpers.ProductActionHelper;

public class AddToCartTest extends BaseTest  {
	
	/*TestNg wali file mai LaunchShopTest wali class ko define krna rhega tb verifyProductCount() wala function call hoga maven cmd ke through */
	@Test(dependsOnGroups = {"LaunchShopTest.openBrowser"})
	public void addToCart() throws InterruptedException, IOException {
		ProductActionHelper aa = new ProductActionHelper(BaseTest.driver);
		aa.addProductTo("Cart",3);
	}
}