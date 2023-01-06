package shop.pageobjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
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
	@FindBy(xpath="//span[text()=\"Sub Total\"]/following-sibling::span")
	WebElement subtotal;
	
	@FindBy (xpath="//span[text()=\"Amount discounted\"]/following-sibling::span")
	WebElement discount;

	@FindBy (xpath="//span[text()=\"Grand Total\"]/following-sibling::span")
	WebElement grandTotal;
	
	@FindBy (css="input[name=\"billing[address_id]\"]")
	WebElement shipAddressRadio;
	
	@FindBy (css="input[id=\"free_free\"]")
	WebElement shippingMethodRadio;
	
	By shippingMethod = By.cssSelector("input[id=\"free_free\"]");
	
	@FindBy (css="input[id=\"cashondelivery\"]")
	WebElement paymentMethod;
	
	@FindBy (css="button[id=\"checkout-place-order-button\"]")
	WebElement placeOrder;
	
	@FindBy (css="div[class*=\"order-success-content\"] a")
	WebElement orderSuccess;
	
	By order = By.cssSelector("div[class*=\"order-success-content\"] a");
	
	@FindBy (css="div[class*=\"order-success-content\"]")
	WebElement orderComplete;
	
	@FindBy (css="div[class*=\"order-success-content\"] h1")
	WebElement thankyouOrder;
	
	@FindBy (css="div[class*=\"item-attribute\"]")
	List<WebElement> bundleQuantity;
	
	By cartSubTotal = By.xpath("//span[text()=\"Sub Total\"]");
	
    By productPrice = By.cssSelector("div[class=\"product-price\"]");
    
	By productName = By.cssSelector("div[class*=\"item-title\"]");
	
	By spanTag = By.tagName("span");
	
	/* Vew Cart page, product quantity
	 *  Price , subtotal , discount, GrandTotal */
    public void verifyShoppingCart() throws InterruptedException {
    	ProductActionHelper action = new ProductActionHelper(driver);
    	action.goToCartPage();
	   float expectedCartSubTotal= 0 ;
	   int quantity=0;
	   for (int i=0;i<totalProductOnCart.size();i++) {
		  float price= remove$(totalProductOnCart.get(i).findElement(productPrice).getText());
		  float actualProductSubTotal = remove$(subTotal.get(i).getText());
		  if(productQuantity.size()==0) {
			  quantity =  (int) (actualProductSubTotal/price);
		  }
		  else {
		      quantity = Integer.parseInt(productQuantity.get(i).getAttribute("model"));
		  }
		  float expectedProductSubTotal=0;  
		  System.out.println("Product In cart: "+totalProductOnCart.get(i).findElement(productName).getText());
		  System.out.println("Product Price: "+price);
		  System.out.println("Product Quantity: "+quantity);
		  expectedProductSubTotal = price*quantity;
		  Assert.assertEquals(actualProductSubTotal, expectedProductSubTotal);
		  expectedCartSubTotal = expectedCartSubTotal+expectedProductSubTotal; 
	   }
	   System.out.println("Expected Cart SubTotal: "+expectedCartSubTotal);
	   // Relative locator for cart summary sub total. Only accept By locator in Relative locator
	  // float actualCartSubTotal = remove$(driver.findElement(with(spanTag).toLeftOf(cartSubTotal)).getText());
	   float actualCartSubTotal = remove$(subtotal.getText());
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
    
    /* Click Place Order Button after that select shipping address
     * shipping method, Payment Method and print order id and thankyou message*/
    public void completeCheckoutProcess() throws InterruptedException {
    	  checkoutButton.click();
    	  shipAddressRadio.click();
    	  boolean isShippable = driver.findElements(shippingMethod).size()>0;
    	  if(isShippable) {
    	  shippingMethodRadio.click();
    	  }
    	  paymentMethod.click();
    	  placeOrder.click();
     	  boolean b=  driver.findElements(order).size()>0;
          if(b) {
        	  System.out.println(thankyouOrder.getText());
        	  System.out.println("Your order id is # "+orderSuccess.getText());
          }
          else {
        	 System.out.println(driver.getTitle());
          }
    }
}

