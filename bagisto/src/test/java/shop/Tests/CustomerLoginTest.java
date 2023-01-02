package shop.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import common.BaseTest;
import org.testng.annotations.Test;
import shop.pageobjects.CustomerLoginPageObject;

public class CustomerLoginTest extends BaseTest {
	
    @Test(groups= {"CustomerLoginTest.customerLogin"},dependsOnGroups = {"LaunchShopTest.openBrowser"}, dataProvider= "getUserandPass")
	public void customerLogin(HashMap<String,String> input) throws InterruptedException {
	CustomerLoginPageObject login = new CustomerLoginPageObject(BaseTest.driver);
	login.customerLogin(input.get("email"), input.get("password"));
  }
    
    @DataProvider
    public Object[][] getUserandPass() throws IOException{
    List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\shop\\Testdata\\TestData.json");
    return new Object[][] {{data.get(0)}};
    }
}
