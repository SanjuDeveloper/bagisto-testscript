package shop.Tests;

import BaseTest.BaseTest;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import helpers.SearchProductHelper;

public class SearchProductTest extends BaseTest {
	/* Test to check search box functionality */
	@Test(dependsOnGroups = { "LaunchShopTest.openBrowser" })
	public void searchItem() throws IOException, ParseException {
       SearchProductHelper search = new SearchProductHelper(BaseTest.driver);
       getGlobalProperty();
       String productToSearch =  prop.getProperty("Product_To_Search");
	   search.searchTerm(productToSearch);
	   System.out.println(search.totalSearchResult.getText());  
	}
}
