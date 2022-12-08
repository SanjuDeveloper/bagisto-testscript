package shop.Tests;

import java.io.IOException;
import org.testng.annotations.Test;
import helpers.ProductActionHelper;
import shop.TestComponents.baseTest;

public class AddToWishListTest {
	@Test(dependsOnGroups = {"LaunchShopTest.openBrowser"})
	public void addToWishlist() throws InterruptedException, IOException {
		ProductActionHelper aa = new ProductActionHelper(baseTest.driver);
		aa.addProductTo("Wishlist",3);
	}
}
