package shop.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
	
   public void verifyShoppingCart() throws InterruptedException {
	   miniCart.click();
	   shoppingCart.click();
   }
}
