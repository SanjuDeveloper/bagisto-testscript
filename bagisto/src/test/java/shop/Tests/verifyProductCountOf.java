package shop.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import helpers.ProductAction;
import shop.TestComponents.baseTest;

public class verifyProductCountOf extends baseTest {
	@Test(dependsOnGroups ={ "LaunchShopTest.openBrowser"})
	/*Function to verify count of actionOn = "Compare" we can change action according to need*/
	public void countVerify() throws InterruptedException {
		/*change actionOn value to "Cart" , "Comapre" , "Wishlist" to perform action on particular*/
		String actionOn = "Cart";
		ProductAction action = new ProductAction(baseTest.driver);
		String[] addedProductCount = action.addProductTo(actionOn);
		/*Get cart, compare, wishlist added Product count at the time of add*/
		int addedProdutCount  = Integer.parseInt(addedProductCount[0]);
		String actionperformed = addedProductCount[1];
		/*Get Count of comapre, cart, wishlist which showing on comapre, wishlist, cart icon */
		int getcount = action.productCountOf(actionOn);
		System.out.println("Added Product to " + actionperformed +": "+ addedProdutCount);
		System.out.println("Count Showing of  " + actionperformed +" icon : "+getcount);
		Assert.assertEquals(addedProdutCount, getcount);
	}
}
