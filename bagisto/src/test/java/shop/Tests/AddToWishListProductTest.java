package shop.Tests;

import java.io.IOException;
import org.testng.annotations.Test;
import helpers.AddProductToHelper;
import shop.TestComponents.baseTest;

public class AddToWishListProductTest {
	@Test(dependsOnGroups = {"LaunchShopTest.openBrowser"})
	public void VerifyWishlistCount() throws InterruptedException, IOException {
		AddProductToHelper aa = new AddProductToHelper(baseTest.driver);
		aa.addProductTo("Wishlist");
	}
}
