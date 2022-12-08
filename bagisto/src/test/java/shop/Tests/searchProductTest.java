package shop.Tests;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import helpers.SearchProductHelper;
import shop.TestComponents.baseTest;

public class searchProductTest extends baseTest {
	/* Test to check search box functionality */

	@SuppressWarnings("unchecked")
	@Test(dependsOnGroups = { "LaunchShopTest.openBrowser" })
	public void searchItem() throws IOException, ParseException {
		// JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader(
				System.getProperty("user.dir") + "\\src\\test\\java\\shop\\Testdata\\ProductName.json");
		// Read JSON file
		Object obj = jsonParser.parse(reader);
		JSONArray productName = (JSONArray) obj;
		ArrayList<String> list = new ArrayList<String>();      
		if (productName != null) { 
		  int len = productName.size();
		  for (int i=0;i<len;i++){ 
		  list.add(productName.get(i).toString());
		  } 
		}	
       String product = list.get(0);
       SearchProductHelper search = new SearchProductHelper(baseTest.driver);
	   search.searchTerm(product);
	   System.out.println(search.totalSearchResult.getText());  
	}
}
