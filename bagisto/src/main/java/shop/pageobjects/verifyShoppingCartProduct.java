package shop.pageobjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import Abstract.AbstractComponen;

public class verifyShoppingCartProduct extends AbstractComponen {
WebDriver driver;
	public verifyShoppingCartProduct(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(css="div[id=\"mini-cart\"]")
	WebElement miniCart;
	
	@FindBy(xpath="//a[text()='View Shopping Cart']")
	WebElement shoppingCart;
	 
	@FindBy(css="div[class='cart-item-list'] div[class*='product-details-content']")
	List<WebElement> totalProductOnCart;
	
	@FindBy(css="input[id=\"quantity-changer\"]")
	List<WebElement> productQuantity;
	
	@FindBy(css="span[class*=\"card-current-price \"]")
	List<WebElement> subTotal;
	
	@FindBy(css="div[class*=\"order-summary\"]")
	WebElement cartSummary;
	
	By cartSubTotal = By.xpath("//span[text()=\"Sub Total\"]");
	
    By productPrice = By.cssSelector("div[class=\"product-price\"]");
    
	By productName = By.cssSelector("div[class*=\"item-title\"]");
	
	By spanTag = By.tagName("span");
	
    public void verifyShoppingCart() throws InterruptedException {
	   miniCart.click();
	   shoppingCart.click();
	   float expectedCartSubTotal= 0 ;
	   for (int i=0;i<totalProductOnCart.size();i++) {
		   float price= remove$(totalProductOnCart.get(i).findElement(productPrice).getText());
		   int quantity = Integer.parseInt(productQuantity.get(i).getAttribute("model"));
		   float expectedProductSubTotal=0;
		   float actualProductSubTotal = remove$(subTotal.get(i).getText());
		   System.out.println("Product In cart: "+totalProductOnCart.get(i).findElement(productName).getText());
		   System.out.println("Product Price: "+price);
		   System.out.println("Product Quantiry: "+quantity);
		   expectedProductSubTotal = price*quantity;
		   Assert.assertEquals(actualProductSubTotal, expectedProductSubTotal);
		   expectedCartSubTotal = expectedCartSubTotal+expectedProductSubTotal;
	   }
	   	   System.out.println("Expected Cart SubTotal: "+expectedCartSubTotal);
	       float actualCartSubTotal = remove$(driver.findElement(with(spanTag).toLeftOf(cartSubTotal)).getText());
	       // Relative locator for cart summary sub total. Only accept By locator in Relative locator
	       System.out.println("Whole Cart SubTotal: "+actualCartSubTotal);
	       Assert.assertEquals(actualCartSubTotal, expectedCartSubTotal);
   }
}

