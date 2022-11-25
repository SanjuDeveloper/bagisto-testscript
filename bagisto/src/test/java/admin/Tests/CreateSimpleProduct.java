package admin.Tests;

import java.io.IOException;

import org.testng.annotations.Test;
import admin.TestComponents.BaseTest;
import admin.pageObjects.*;

public class CreateSimpleProduct extends BaseTest {
	
	// If we want to run any function first which is another class then we will use grouping concept.
	//@Test(dependsOnGroups={"Login.adminLogin"})
	 @Test
	public void createProduct() throws InterruptedException, IOException {
		LoginPageObject LoginPageObject = launcDashboard();
		LoginPageObject.Login(); // TODO use dependsOn method
		CreateProductPageObject createProductObject = new CreateProductPageObject(driver);
		createProductObject.createSimpleProduct();
	}
}
