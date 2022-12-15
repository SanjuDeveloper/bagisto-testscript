package shop.Tests;

import org.testng.annotations.Test;
import BaseTest.BaseTest;
import shop.pageobjects.HomePageAddToCartPageObject;

public class HomePageAddToCartTest extends BaseTest{
	@Test(dependsOnGroups= {"LaunchShopTest.openBrowser"})
	public void AddTOCartDisableCheck() {
		HomePageAddToCartPageObject addCart =new HomePageAddToCartPageObject(BaseTest.driver);
		addCart.checkAddButton();
	}
}
