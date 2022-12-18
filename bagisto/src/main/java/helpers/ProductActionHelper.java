package helpers;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Abstract.AbstractComponen;

public class ProductActionHelper extends AbstractComponen {
WebDriver driver;
	public ProductActionHelper(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[@aria-label=\"Logo\"])[1]")
	public  WebElement homeLogo;
	
	@FindBy(xpath = "(//div[contains(@class,'product-card-new')])[1]")
	public WebElement product;

	@FindBy(xpath="(//div[@class=\"product-price\"])")
    List<WebElement> productPrice;	
	
	@FindBy(xpath = "(//div[contains(@class,'add-to-cart-btn')])")
	List<WebElement> addToCartButton;
	
	@FindBy(css="a[title='Add product to compare list']")
	List<WebElement> compareIcon;
	
	@FindBy (xpath = "//a[@title=\"Add product to wishlist\"]")
	List<WebElement> wishListButton;

	@FindBy(id = "mini-cart")
	WebElement miniCartButton;
	
	@FindBy(xpath="//div[@class=\"mini-cart-content\"]/div/span")
	WebElement minicartcount;
	
	@FindBy(xpath="//a[contains(@class,'compare-btn')]/div/span")
	WebElement compareCount;
	
	@FindBy(xpath="//a[contains(@class,'wishlist-btn')]/div/span")
	WebElement wishlistCount;
	
	@FindBy(xpath="//div[contains(@class,\"alert-dismissible\")]")
	WebElement alertOfSuccess;
	
	@FindBy(css = "a[class=\"product-image-container\"]")
	List<WebElement> productimage;
	
	@FindBy (css=".price-label")
	WebElement productLabel;
	
	@FindBy(css="input[id=\"quantity-changer\"]")
	WebElement quantity;
	
	@FindBy(css="select[id=\"attribute_23\"]")
	WebElement configColor;
	
	@FindBy(css="select[id=\"attribute_24\"]")
	WebElement configSize;
	
	@FindBy(css="a[class=\"close\"]")
	WebElement closeButton;
	
	@FindBy(css="div[id=\"mini-cart\"]")
	WebElement miniCart;
	
	@FindBy(xpath="//a[text()='View Shopping Cart']")
	WebElement shoppingCart;
	
	public String addProductTo(String actiontoPerform,int count) throws InterruptedException {
		String alertSuccess = null;
		for (int i=0; i<count; i++) {
			switch(actiontoPerform) {
			case "Cart":			
				addToCartButton.get(i).click();	
				break;
			case "Wishlist":
				mouseHover(productPrice.get(i)); 
				Thread.sleep(2000);
				wishListButton.get(i).click();	
				break;
			case "Compare":
				mouseHover(productPrice.get(i)); 
				compareIcon.get(i).click();
				break;
			default:
				// To-DO Need to update in future
			 addToCartButton.get(i).click();
			}
			waitForWebElementToAppear(alertOfSuccess);
			alertSuccess = alertOfSuccess.getText().split("\n")[1];			
		}
		return alertSuccess;
	}
	
	/*This function return count of cart, compare and wishlist*/
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
	
	public void setQuantity(String addQuantity) {
		quantity.sendKeys(Keys.BACK_SPACE);
		quantity.sendKeys(addQuantity);
	}
	
	public void checkAddButton() throws InterruptedException {
		for(int i=0;i<productimage.size();i++) {		
				  if( addToCartButton.get(i).isEnabled()) { 
					  productimage.get(i).click();
					  }		  	  
				       break;
		} 
		switch(productLabel.getText()) {
		case "As low as":
			setQuantity("1");
			Select varinat1= selectDropdown(configColor);
			varinat1.selectByVisibleText("Red");
			Select varinat2 = selectDropdown(configSize);
			varinat2.selectByVisibleText("S");
			String successMessage = addProductTo("Cart",1);
			System.out.println(successMessage);
			closeButton.click();
			break;
		case "":
			break;
		default :
			goToHomePage();
			break;
		}
	}
	
	public void goToCartPage() {
		 miniCart.click();
		 shoppingCart.click();
	}
	
	public void goToHomePage() {
		homeLogo.click();
	}
}
