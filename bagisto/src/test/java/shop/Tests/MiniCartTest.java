package shop.Tests;

import org.testng.Assert;
import BaseTest.BaseTest;
import org.testng.annotations.Test;
import helpers.ProductActionHelper;

public class MiniCartTest extends BaseTest {
	/*Function to verify count of actionOn = "Compare" we can change action according to need*/
	@Test(dependsOnGroups ={ "LaunchShopTest.openBrowser"})
	public void countVerify() throws InterruptedException {
		/*change actionOn value to "Cart" , "Comapre" , "Wishlist" to perform action on particular*/
		String actionOn = "Cart";
		int productNeedToAdd = 3;
		ProductActionHelper action = new ProductActionHelper(BaseTest.driver);
		action.addProductTo(actionOn,productNeedToAdd);
		/*Get Count of comapre, cart, wishlist which showing on comapre, wishlist, cart icon */
		int getcount = action.productCountOf(actionOn);
		System.out.println("Added Product to " + actionOn +": "+ productNeedToAdd);
		System.out.println("Count Showing of  " + actionOn +" icon : "+getcount);
		Assert.assertEquals(productNeedToAdd, getcount);
	}
}
