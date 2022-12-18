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
import helpers.ProductActionHelper;

public class verifyShoppingCartProduct extends AbstractComponen {
    WebDriver driver;
	public verifyShoppingCartProduct(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, driver);
		// TODO Auto-generated constructor stub
	}
	 
	@FindBy(css="div[class='cart-item-list'] div[class*='product-details-content']")
	List<WebElement> totalProductOnCart;
	
	@FindBy(css="input[id=\"quantity-changer\"]")
	List<WebElement> productQuantity;
	
	@FindBy(css="span[class*=\"card-current-price \"]")
	List<WebElement> subTotal;
	
	@FindBy(css="div[class*=\"order-summary\"]")
	WebElement cartSummary;

	@FindBy (xpath="//a[text()=\"Proceed to checkout\"]")
	WebElement checkoutButton;
	
	// use following sibling locator to grab grandTotal and discountPrice
	@FindBy (xpath="//span[text()=\"Amount discounted\"]/following-sibling::span")
	WebElement discount;

	@FindBy (xpath="//span[text()=\"Grand Total\"]/following-sibling::span")
	WebElement grandTotal;
	
	@FindBy (css="div[class*=\"address-container\"] div[class=\"card\"]")
	List<WebElement> shipAddress;
	
	@FindBy (xpath="//input[@type=\"radio\" and @name=\"billing[address_id]\"]")
	List<WebElement> shipAddressRadio;
	
	@FindBy (css="div[class*=\"shipping-methods \"] input[name=\"shipping_method\"]")
	List<WebElement> shipMethod;
	
	@FindBy (xpath="//input[@type=\"radio\" and @name=\"shipping_method\"]")
	List<WebElement> shippingMethodRadio;
	
	@FindBy (css="div[class=\"payment-methods\"] input[name=\"payment[method]\"]")
	List<WebElement> paymentMethod;
	
	@FindBy (css="button[id=\"checkout-place-order-button\"]")
	WebElement placeOrder;
	
	@FindBy (xpath="(//div[contains(@class,'order-success-content')]//p)[1]")
	WebElement orderSuccess;
	
	@FindBy (css="div[class*=\"order-success-content\"]")
	WebElement orderComplete;
	
	By cartSubTotal = By.xpath("//span[text()=\"Sub Total\"]");
	
    By productPrice = By.cssSelector("div[class=\"product-price\"]");
    
	By productName = By.cssSelector("div[class*=\"item-title\"]");
	
	By spanTag = By.tagName("span");
	
    public void verifyShoppingCart() throws InterruptedException {
    	ProductActionHelper action = new ProductActionHelper(driver);
    	action.goToCartPage();
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
	   // Relative locator for cart summary sub total. Only accept By locator in Relative locator
	   float actualCartSubTotal = remove$(driver.findElement(with(spanTag).toLeftOf(cartSubTotal)).getText());
	   System.out.println("Whole Cart SubTotal: "+actualCartSubTotal);
	   Assert.assertEquals(actualCartSubTotal, expectedCartSubTotal);
	   float discountAmount = remove$(discount.getText());
	   System.out.println("Discount of Order: "+discountAmount);
	   float actualGrandTotal =  remove$(grandTotal.getText());
	   float expectedGrandTotal = expectedCartSubTotal - discountAmount;
	   System.out.println("Actual Grand Total : "+actualGrandTotal);
	   System.out.println("Expected Grand Total : "+expectedGrandTotal);
	   Assert.assertEquals(actualGrandTotal, expectedGrandTotal);
   }
    
    public void completeCheckoutProcess() throws InterruptedException {
    	  checkoutButton.click();
    	  for (int i = 0;i<shipAddress.size();i++) {
    		  shipAddressRadio.get(i).click();
    		  break;
    	  }
    	  waitForWebElementToAppear(shipMethod.get(0));
    	  for(int i = 0;i<shipMethod.size();i++) {
    		  shippingMethodRadio.get(i).click();
    		  break;
    	  }
    	  for (int i=0;i<paymentMethod.size();i++) {
    		  paymentMethod.get(1).click();
    		  break;
    	  }
    	  placeOrder.click();
    	  Thread.sleep(5000);
    	 // waitForWebElementVisible(orderComplete);
          System.out.println(orderSuccess.getText());
    }
}

