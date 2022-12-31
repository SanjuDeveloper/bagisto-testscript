package shop.Tests;

import java.io.IOException;
import org.testng.annotations.Test;
import helpers.ProductActionHelper;
import BaseTest.BaseTest;
public class AddToWishListTest extends BaseTest {
	@Test(dependsOnGroups = {"LaunchShopTest.openBrowser","CustomerLoginTest.customerLogin"})
	public void addToWishlist() throws InterruptedException, IOException {
		ProductActionHelper wishList = new ProductActionHelper(driver);
		wishList.homeLogo.click();
		wishList.addProductTo("Wishlist",3);
	}
}
