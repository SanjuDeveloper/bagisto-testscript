package shop.Tests;

import org.testng.annotations.Test;
import shop.TestComponents.baseTest;
import shop.pageobjects.CustomerLoginPageObject;

public class CustomerLoginTest extends baseTest {
    @Test(dependsOnGroups = {"LaunchShopTest.openBrowser"})
	public void customerLogin() throws InterruptedException {
	CustomerLoginPageObject login = new CustomerLoginPageObject(baseTest.driver);
	login.customerLogin();
  }
//To-Do Implement with DataProvider for username and password
}
