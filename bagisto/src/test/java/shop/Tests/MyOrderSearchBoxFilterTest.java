package shop.Tests;

import java.io.IOException;
import org.junit.Assert;
import org.testng.annotations.Test;
import BaseTest.BaseTest;
import helpers.SearchProductHelper;
import shop.pageobjects.MyOrderSearchBoxFilterPageObject;

public class MyOrderSearchBoxFilterTest extends BaseTest {

	/*Search Filter on My Order History Customer End*/
	@Test(dependsOnGroups = {"LaunchShopTest.openBrowser", "CustomerLoginTest.customerLogin"})
	public void MyOrderSearchBox() throws IOException {
		getGlobalProperty();
		String toSearch = prop.getProperty("searchInOrderFilter");
		SearchProductHelper searchterm = new SearchProductHelper(BaseTest.driver);
		MyOrderSearchBoxFilterPageObject search = new MyOrderSearchBoxFilterPageObject(BaseTest.driver);
		int[] filterResult = search.searchBoxFilter(toSearch, searchterm);	
		System.out.println("Search Term = "+toSearch);
		System.out.println("Before Search Result = "+filterResult[0]);
		System.out.println("After Search Result = "+filterResult[1]);
		Assert.assertEquals(filterResult[0], filterResult[1]);
	}
}
