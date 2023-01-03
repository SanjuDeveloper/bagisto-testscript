package shop.Tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import helpers.ProductActionHelper;
import common.BaseTest;

public class AddToWishListTest {
	@Test(dependsOnGroups = {"LaunchShopTest.openBrowser","CustomerLoginTest.customerLogin"})
	public void addToWishlist() throws InterruptedException, IOException {
		ProductActionHelper helper = new ProductActionHelper(driver);
		helper.homeLogo.click();
		String success_message = helper.addProductTo("Wishlist",1);	
		System.out.println(success_message);
		Assert.assertEquals(success_message, "Success! Item Successfully Added To Wishlist.");
	}
}
