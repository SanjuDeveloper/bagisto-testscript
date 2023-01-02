package shop.Tests;

import java.io.IOException;
import common.BaseTest;
import shop.TestComponents.Retry;

import org.testng.annotations.Test;

public class LaunchShopTest extends BaseTest {

	@Test(groups= {"LaunchShopTest.openBrowser"},retryAnalyzer=Retry.class)
	public void openBrowser() throws IOException, InterruptedException {
		launcShop();
		
	}
}
