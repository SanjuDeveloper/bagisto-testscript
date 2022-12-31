package shop.Tests;

import org.testng.annotations.DataProvider;
import BaseTest.BaseTest;
import org.testng.annotations.Test;
import shop.pageobjects.CustomerLoginPageObject;

public class CustomerLoginTest extends BaseTest {
	
    @Test(groups= {"CustomerLoginTest.customerLogin"},dependsOnGroups = {"LaunchShopTest.openBrowser"}, dataProvider= "usernameAndPass")
	public void customerLogin(String username, String password) throws InterruptedException {
	CustomerLoginPageObject login = new CustomerLoginPageObject(driver);
	login.customerLogin(username, password);
  }
    @DataProvider (name = "usernameAndPass")
    public Object[][] getUserandPass(){
	 return new Object[][] {{"admin@example.com","Admin123"}};
    }
}
