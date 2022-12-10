package shop.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import shop.TestComponents.baseTest;
import shop.pageobjects.CustomerLoginPageObject;

public class CustomerLoginTest extends baseTest {
    @Test(dependsOnGroups = {"LaunchShopTest.openBrowser"}, dataProvider= "usernameAndPass")
	public void customerLogin(String username, String password) throws InterruptedException {
	CustomerLoginPageObject login = new CustomerLoginPageObject(baseTest.driver);
	login.customerLogin(username, password);
  }
    @DataProvider (name = "usernameAndPass")
    public Object[][] getUserandPass(){
	 return new Object[][] {{"admin@example.com","Admin123"}};
    }
}
