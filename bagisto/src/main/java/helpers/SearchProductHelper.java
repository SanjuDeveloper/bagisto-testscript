package helpers;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Abstract.AbstractComponen;

public class SearchProductHelper extends AbstractComponen {
	
	/* Helper class use to search product in store */
	WebDriver driver;
	public SearchProductHelper(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this.driver);
	}

	/* search box locator */
	@FindBy(xpath = "//input[@type=\"search\"]")
	WebElement searchBox;

	@FindBy(xpath = "//section[contains(@class,'search-container')]/h5")
	public WebElement totalSearchResult;

	@FindBy(id = "search-field")
	WebElement searchInFilter;

	public void searchTerm(String productName) {
		searchBox.sendKeys(productName, Keys.ENTER);
	}

	public void searchInFilter(String filterData) {
		searchInFilter.sendKeys(filterData, Keys.ENTER);	
	}
}
