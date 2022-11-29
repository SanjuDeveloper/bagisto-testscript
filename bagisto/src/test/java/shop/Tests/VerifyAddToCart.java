package shop.Tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		String[] cartProduct= add.AddToCart();
		List<String> cartProductList = Arrays.asList(cartProduct);  
		MiniCartProductList minicart = new MiniCartProductList(driver);
		ArrayList<String> minicartProduct =minicart.getAddedProduct();
		System.out.println();
		boolean boolval = cartProductList.equals(minicartProduct);
		System.out.println(boolval);
		Assert.assertTrue(boolval);
	}
}