package shop.Tests;

import java.io.IOException;
import org.testng.annotations.Test;
import helpers.AddProductToHelper;
import shop.TestComponents.baseTest;

public class AddToCartProductTest extends baseTest {
	@Test(dependsOnGroups = {"LaunchShopTest.openBrowser"})
	public void verifyProductCount() throws InterruptedException, IOException {
		AddProductToHelper aa = new AddProductToHelper(baseTest.driver);
		aa.addProductTo("Cart");
	}
}