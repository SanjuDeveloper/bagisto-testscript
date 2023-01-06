package helpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import Abstract.AbstractComponen;

public class ProductActionHelper extends AbstractComponen {
	int day;
WebDriver driver;
	public ProductActionHelper(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
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
	List<WebElement> quantity;
	
	@FindBy(css="select[id=\"attribute_23\"]")
	WebElement configColor;
	
	By configColour = By.cssSelector("select[id=\"attribute_23\"]");
	
	@FindBy(css="select[id=\"attribute_24\"]")
	WebElement configSize;
	
	By configsize = By.cssSelector("select[id=\"attribute_24\"]");
	
	@FindBy (css="input[id*=\"bundle_options\"]")
	List<WebElement> bundleoption;
	
	By datepicker = By.cssSelector("input[name=\"booking[date]\"]");
	
	@FindBy (css="input[name=\"booking[date]\"]")
	WebElement datePicker;
	
	By bundleOption = By.cssSelector("input[id*=\"bundle_options\"]");
	
	@FindBy (css="input[name=\"links[]\"]")
	WebElement downloadlink;
	
	By downloadLink = By.cssSelector("input[name=\"links[]\"]");
	
	@FindBy(css="a[class=\"close\"]")
	WebElement closeButton;
	
	@FindBy(css="div[id=\"mini-cart\"]")
	WebElement miniCart;
	
	@FindBy(xpath="//a[text()='View Shopping Cart']")
	WebElement shoppingCart;
	
	@FindBy(xpath="(//div[@class=\"grouped-product-list\"]//li)")
	List<WebElement> groupProduct;
	
	
	@FindBy(css="input[class*=\"cur-year\"]")
	WebElement selectYear;
	
	@FindBy(xpath="//span[text()='10']")
	WebElement selectDay;
	
   @FindBy(css="select[name=\"booking[slot]\"]")
   WebElement selectSlot;
	
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
	
	/* Function is use to set quantity of 
	the product to add to cart from product view page*/
	public void setQuantity(String addQuantity) {
		for(int i=0;i<quantity.size();i++) {
		quantity.get(i).sendKeys(Keys.BACK_SPACE);
		quantity.get(i).sendKeys(addQuantity);
		}
	}
	
	/*Add all types of product to cart and print 
	  successful add to cart message*/
	public void checkAddButton() throws InterruptedException {
		String successMessage;
		for(int i=0;i<productimage.size();i++) {		
				  if( addToCartButton.get(i).isEnabled()) { 
					  productimage.get(i).click();
					  }		  	  
				       break;
		    } 
			boolean color = driver.findElements(configColour).size()>0;
			boolean size = driver.findElements(configsize).size()>0;
			boolean bundlecheck =  driver.findElements(bundleOption).size()>0;
		    boolean downloadlink1 =	driver.findElements(downloadLink).size()>0;
		    boolean datepick = driver.findElements(datepicker).size()>0;
		    
		    if(downloadlink1) {
		    	downloadlink.click();
		    }
			if(bundlecheck) {
				for(int i=0;i<bundleoption.size();i++) {
					if(bundleoption.get(i).isSelected()){
					}
					else {
						bundleoption.get(i).click();
					}
				}
			}
			setQuantity("1");
			if(color) {
			Select varinat1= selectDropdown(configColor);
			varinat1.selectByVisibleText("Red");
			}
			if (size) {
			Select varinat2 = selectDropdown(configSize);
			varinat2.selectByVisibleText("S");
			}
			if(datepick) {
				datePicker.click();
				handleCalendarDate(getDate("Today_Date","d"),getDate("Today_Date","MMMM"));
			}
			Thread.sleep(1000);
			 successMessage = addProductTo("Cart",1);
			 System.out.println(successMessage);
			closeButton.click();
	}
	
}