package shop.Tests;

import java.io.IOException;
import org.testng.annotations.Test;
import helpers.ProductActionHelper;
import shop.TestComponents.baseTest;

public class AddToCartTest extends baseTest  {
	
	/*TestNg wali file mai LaunchShopTest wali class ko define krna rhega tb verifyProductCount() wala function call hoga maven cmd ke through */
	@Test(dependsOnGroups = {"LaunchShopTest.openBrowser"})
	public void addToCart() throws InterruptedException, IOException {
		ProductActionHelper aa = new ProductActionHelper(baseTest.driver);
		aa.addProductTo("Cart",3);
	}
}