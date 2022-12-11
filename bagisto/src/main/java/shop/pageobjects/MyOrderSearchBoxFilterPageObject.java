package shop.pageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Abstract.AbstractComponen;
import helpers.SearchProductHelper;

public class MyOrderSearchBoxFilterPageObject extends AbstractComponen {
WebDriver driver;
	public MyOrderSearchBoxFilterPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, driver);
	}
	
	@FindBy(xpath="//li[@title=\"Orders\"]")
	WebElement orderTab;
	
	@FindBy(xpath="//td[@data-value='Total']")
	List<WebElement> searchResult;
	
	public int[] searchBoxFilter(String toSearch, SearchProductHelper searchterm) {
		int filterExpectedResult = 0;
		int filterActualResult = 0;
		orderTab.click();
		for(int i=0; i<searchResult.size();i++) {
			if(searchResult.get(i).getText().contains(toSearch)) {
				filterExpectedResult++;		
			}	
		}
		searchterm.searchInFilter(toSearch);
		for(int i=0; i<searchResult.size();i++) {
			if(searchResult.get(i).getText().contains(toSearch)) {
				filterActualResult++;		
			}	
		}
		 int[] filterResult = {filterExpectedResult,filterActualResult};
		 return filterResult;
	} 
}
