package shop.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Abstract.AbstractComponen;

public class CompareListCountVerifyPageObject extends AbstractComponen  {
 WebDriver driver;
	public CompareListCountVerifyPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this.driver);	
	}
	
	@FindBy (xpath= "//a[contains(@class,\"compare-btn\")]//div[@class=\"badge-container\"]//span")
	WebElement compareCount;
	
	public int compareProductCount() {
		return Integer.parseInt(compareCount.getText());
	}
}
