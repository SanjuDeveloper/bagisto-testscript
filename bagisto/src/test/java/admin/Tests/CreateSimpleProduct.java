package admin.Tests;

import java.io.IOException;
import org.testng.annotations.Test;
import BaseTest.BaseTest;
import admin.pageObjects.*;

public class CreateSimpleProduct extends BaseTest {
	
	/*
	 * If we want to run any function first which is another class then we will use grouping concept.
	 * driver  should be static in base class
	 */
	@Test(dependsOnGroups={"Login.adminLogin"})	
	public void createProduct() throws InterruptedException, IOException {
		CreateProductPageObject createProductObject = new CreateProductPageObject(driver);		
		getGlobalProperty();
		String ProductSKU = prop.getProperty("PRODUCT_SKU");
		createProductObject.createSimpleProduct(ProductSKU);
		String description = prop.getProperty("PRODUCT_DESCRIPTION");
		String shortDescription = prop.getProperty("PRODUCT_SHORTDESCRIPTION");
		createProductObject.createdOrEditProduct(shortDescription , description);
	}
}
