package shop.Tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import shop.TestComponents.baseTest;
import shop.pageobjects.MiniCartProductListPageObject;
import shop.pageobjects.ProductAddToCartPageObject;

public class MinicartVerifyTest extends baseTest {
	String[] productToBeAdded = { "Mobile", "Shirt" ,"Laptop"};
	@Test
	public void initail() throws IOException, InterruptedException {
		launcShop();
		ProductAddToCartPageObject add = new ProductAddToCartPageObject(driver);
		String[] cartProduct= add.AddToCart(productToBeAdded);
		List<String> cartProductList = Arrays.asList(cartProduct);  
		MiniCartProductListPageObject minicart = new MiniCartProductListPageObject(driver);
		ArrayList<String> minicartProduct =minicart.getAddedProduct();
		System.out.println();
		boolean boolval = cartProductList.equals(minicartProduct);
		System.out.println(boolval);
		Assert.assertTrue(boolval);
	}		  
  }