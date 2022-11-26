package shop.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Abstract.AbstractComponen;

public class MiniCart extends AbstractComponen {
	WebDriver driver;
	public MiniCart(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//div[@class='mini-cart-content']")
	WebElement miniCart;
	
	@FindBy(xpath="//div[@class='mini-cart-container'] //div[contains(@class,'product-name')]")
	WebElement miniCartPoduct;
	

}