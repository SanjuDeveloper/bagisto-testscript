package shop.Tests;

import java.io.IOException;
import org.testng.annotations.Test;
import helpers.ProductAction;
import shop.TestComponents.baseTest;

public class AddToCompareTest extends baseTest {
	@Test(dependsOnGroups = {"LaunchShopTest.openBrowser"})
	public void VerifyCompareCount() throws InterruptedException, IOException {
		ProductAction aa = new ProductAction(baseTest.driver);
		aa.addProductTo("Compare");
	}
}
