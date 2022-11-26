package shop.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Abstract.AbstractComponen;

public class HomePage extends AbstractComponen {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[text()='Add To Cart'])[1]")
	WebElement addToCart;
	
	@FindBy(xpath="//div[contains(@class,'product-card-new')]")
	List<WebElement> productgrid;
	
	@FindBy(xpath="//div[@class='mini-cart-content']")
	WebElement miniCart;
	
	@FindBy(xpath="//div[@class='mini-cart-container'] //div[contains(@class,'product-name')]")
	WebElement miniCartPoduct;
	
	public  void ProductAddToCart() {
	 int totalProduct =  productgrid.size();
	 System.out.println(totalProduct);
	}
}