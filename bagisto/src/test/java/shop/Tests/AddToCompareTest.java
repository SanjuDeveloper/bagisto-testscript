package shop.Tests;

import java.io.IOException;
import org.testng.annotations.Test;
import helpers.ProductActionHelper;
import shop.TestComponents.baseTest;

public class AddToCompareTest extends baseTest {
	@Test(dependsOnGroups = {"LaunchShopTest.openBrowser"})
	public void addToCompare() throws InterruptedException, IOException {
		ProductActionHelper aa = new ProductActionHelper(baseTest.driver);
		aa.addProductTo("Compare",3);
	}
}
