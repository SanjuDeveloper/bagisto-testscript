package shop.pageobjects;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Abstract.AbstractComponen;

public class ProductAddToCompareListPageObject extends AbstractComponen {
	WebDriver driver;
	public ProductAddToCompareListPageObject(WebDriver driver) {
	    super(driver);   
	    this.driver = driver;
	    PageFactory.initElements(driver, this.driver);
	}
 
	@FindBy(xpath = "//div[contains(@class,'product-card-new')]")
	List<WebElement> productcart;

	// By is use for Explicite wait
	By productgridpresent = By.xpath("//div[contains(@class,'product-card-new')]");
 
	@FindBy(xpath = "(//div[@class=\"card-body\"]//div[contains(@class,'product-name')])")
	List<WebElement> productName;
	
	@FindBy (xpath = "//a[contains(@class,'compare-icon')]")
	List<WebElement> compareArrow;
 
	public String[] addToCompareList(String[] compareListAdd) throws InterruptedException {
	waitForElementToAppear(productgridpresent);
	int j = 0;
		for (int i = 0; i <= productcart.size(); i++) {
			String productNameList = productName.get(i).getText().trim();
			List<String> itemAddToCompare = Arrays.asList(compareListAdd);
			if (itemAddToCompare.contains(productNameList)) {
			 j++;
			 mouseHover(productName.get(i)); 
			 compareArrow.get(i).click();
			 Thread.sleep(3000);
			 if (j == itemAddToCompare.size() ) {
				 break;
		 	}
		 }
	  }
	 return compareListAdd;
	}
}
