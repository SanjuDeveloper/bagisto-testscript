package shop.Tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import shop.TestComponents.baseTest;
import shop.pageobjects.MiniCartAddedProductCountPageObject;
import shop.pageobjects.ProductAddToCartPageObject;

public class MiniCartAddedProductCountTest extends baseTest {
	String[] productToBeAdded = {"Mobile", "Shirt", "Laptop", };
	@Test
	public void verifyProductCount() throws InterruptedException, IOException {
		launcShop();
		ProductAddToCartPageObject add = new ProductAddToCartPageObject(driver);
		String[] cartProduct= add.AddToCart(productToBeAdded );
		MiniCartAddedProductCountPageObject miniCart = new MiniCartAddedProductCountPageObject(driver);
		Assert.assertEquals(cartProduct.length,miniCart.productCount());
	}
}
