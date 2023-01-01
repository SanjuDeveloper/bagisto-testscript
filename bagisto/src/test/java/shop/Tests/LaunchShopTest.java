package shop.Tests;

import java.io.IOException;
import common.BaseTest;
import org.testng.annotations.Test;

public class LaunchShopTest extends BaseTest {

	@Test(groups= {"LaunchShopTest.openBrowser"})
	public void openBrowser() throws IOException, InterruptedException {
		launcShop();
		
	}
}
