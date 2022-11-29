package shop.Tests;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import shop.TestComponents.baseTest;
import shop.TestComponents.MiniCartProductList;
import shop.TestComponents.ProductAddToCart;

public class VerifyAddToCart extends baseTest {

	@Test
	public void initail() throws IOException, InterruptedException {
		launcShop();
		ProductAddToCart add = new ProductAddToCart(driver);
		ArrayList<String> cartProduct =add.AddToCart();
		MiniCartProductList minicart = new MiniCartProductList(driver);
		ArrayList<String> minicartProduct =minicart.getAddedProduct();
		boolean boolval = cartProduct.equals(minicartProduct);
		System.out.println(boolval);
		Assert.assertTrue(boolval);
	}
}