package helpers;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Abstract.AbstractComponen;

public class ProductAction extends AbstractComponen {
WebDriver driver;
	public ProductAction(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[contains(@class,'product-card-new')]")
	List<WebElement> productcart;

	By productgridpresent = By.xpath("//div[contains(@class,'product-card-new')]");

	@FindBy(xpath = "(//button[contains(@class,'btn-add-to-cart')])")
	List<WebElement> addToCartButton;

	@FindBy(xpath = "(//div[@class=\"card-body\"]//div[contains(@class,'product-name')])")
	List<WebElement> productName;
	
	@FindBy (xpath = "//a[contains(@class,'compare-icon')]")
	List<WebElement> compareArrow;
	
	@FindBy (xpath = "//a[@title=\"Add product to wishlist\"]//i")
	List<WebElement> wishListButton;

	@FindBy(id = "mini-cart")
	WebElement miniCartButton;
	
	
	
	public void addProductTo(String actiontoPerform) throws InterruptedException {
		for (int i=0; i<3; i++) {
			switch(actiontoPerform) {
			case "Cart":
				waitForElementToAppear(productgridpresent);
				addToCartButton.get(i).click();
				Thread.sleep(5000);
				break;
			case "Wishlist":
				mouseHover(productName.get(i)); 
				wishListButton.get(i).click();
				break;
			case "Compare":
				mouseHover(productName.get(i)); 
				 compareArrow.get(i).click();
				break;
			default:
				// To-DO Need to update in future
				waitForElementToAppear(productgridpresent);
				addToCartButton.get(i).click();
				Thread.sleep(5000);
			}
		}
	}
	
	public void productCountOf(String actionPerform) {
		
		
		
	}
}
