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
	
	@FindBy(xpath="//div[@class=\"mini-cart-content\"]/div/span")
	WebElement minicartcount;
	
	@FindBy(xpath="//a[contains(@class,'compare-btn')]/div/span")
	WebElement compareCount;
	
	@FindBy(xpath="//a[contains(@class,'wishlist-btn')]/div/span")
	WebElement wishlistCount;
	
	public void addProductTo(String actiontoPerform,int count) throws InterruptedException {
		for (int i=0; i<count; i++) {
			switch(actiontoPerform) {
			case "Cart":
				waitForElementToAppear(productgridpresent);
				addToCartButton.get(i).click();
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
			}
			Thread.sleep(5000);
		}
	}
	
	public int productCountOf(String type) {
		String productCountOf = null;
		switch (type) {
		case "Cart":
			productCountOf = minicartcount.getText();
			break;
		case "Wishlist":
			productCountOf = wishlistCount.getText();
			break;
		case "Compare":
			productCountOf = compareCount.getText();
			break;
		default:
			System.out.println("Action on "+type+" not found");
		}
		   return Integer.parseInt(productCountOf);
	}
}
