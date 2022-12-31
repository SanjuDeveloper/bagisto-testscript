package shop.Tests;

import java.io.IOException;
import org.testng.annotations.Test;
import BaseTest.BaseTest;
import helpers.ProductActionHelper;

public class AddToCompareTest extends BaseTest {
	@Test(dependsOnGroups = {"LaunchShopTest.openBrowser"})
	public void addToCompare() throws InterruptedException, IOException {
		ProductActionHelper aa = new ProductActionHelper(driver);
		aa.addProductTo("Compare",3);
	}
}
