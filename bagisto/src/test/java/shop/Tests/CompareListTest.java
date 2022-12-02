package shop.Tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import shop.TestComponents.baseTest;
import shop.pageobjects.CompareListCountVerifyPageObject;
import shop.pageobjects.ProductAddToCompareListPageObject;

public class CompareListTest extends baseTest {
	String[] compareListAdd = {"Mobile", "Shirt"};
	@Test
	public void CompareProductverify() throws IOException, InterruptedException {
		launcShop();
		ProductAddToCompareListPageObject compare = new ProductAddToCompareListPageObject(driver);
		String[] compareProduct = compare.addToCompareList(compareListAdd);
		CompareListCountVerifyPageObject compareCount = new CompareListCountVerifyPageObject(driver);
	    Assert.assertEquals(compareProduct.length, compareCount.compareProductCount());
	}
}
