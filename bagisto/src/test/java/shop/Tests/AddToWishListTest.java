package shop.Tests;

import java.io.IOException;
import org.testng.annotations.Test;
import helpers.ProductAction;
import shop.TestComponents.baseTest;

public class AddToWishListTest {
	@Test(dependsOnGroups = {"LaunchShopTest.openBrowser"})
	public void VerifyWishlistCount() throws InterruptedException, IOException {
		ProductAction aa = new ProductAction(baseTest.driver);
		aa.addProductTo("Wishlist");
	}
}
