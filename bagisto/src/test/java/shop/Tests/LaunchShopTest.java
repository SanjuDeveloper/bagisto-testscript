package shop.Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import shop.TestComponents.baseTest;

public class LaunchShopTest extends baseTest {

	@Test(groups= {"LaunchShopTest.openBrowser"})
	public void openBrowser() throws IOException, InterruptedException {
		launcShop();
		
	}
}
