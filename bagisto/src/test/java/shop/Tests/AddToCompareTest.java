package shop.Tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import BaseTest.BaseTest;
import helpers.ProductActionHelper;

public class AddToCompareTest extends BaseTest {
	@Test(dependsOnGroups = {"LaunchShopTest.openBrowser"})
	public void addToCompare() throws InterruptedException, IOException {
		ProductActionHelper helper = new ProductActionHelper(BaseTest.driver);
		String success_message = helper.addProductTo("Compare",1);	
		System.out.println(success_message);
		Assert.assertEquals(success_message, "Success! Item successfully added to compare list.");
	}
}
