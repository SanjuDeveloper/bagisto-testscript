package shop.Tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import shop.TestComponents.baseTest;
import shop.pageobjects.CartCountVerifyPageObject;
import shop.pageobjects.ProductAddToCartPageObject;

public class CartCountVerifyTest extends baseTest {
	String[] productToBeAdded = {"Shirt", "Laptop","Mobile"};
	@Test
	public void verifyProductCount() throws InterruptedException, IOException {
		launcShop();
		ProductAddToCartPageObject add = new ProductAddToCartPageObject(driver);
		String[] cartProduct= add.AddToCart(productToBeAdded );
		CartCountVerifyPageObject miniCart = new CartCountVerifyPageObject(driver);
		Assert.assertEquals(cartProduct.length,miniCart.productCount());
	}
}
