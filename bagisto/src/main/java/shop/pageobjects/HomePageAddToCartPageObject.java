package shop.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstract.AbstractComponen;

public class HomePageAddToCartPageObject extends AbstractComponen {
	WebDriver driver;
	public HomePageAddToCartPageObject(WebDriver driver) {
		super(driver);
		this.driver  = driver;
		PageFactory.initElements(this.driver, driver);
	}
	
	@FindBy(css = "button[class*=\"btn-add-to-cart\"]")
	List<WebElement> addToCartButton;
	
	@FindBy(css = "a[class=\"product-image-container\"]")
	List<WebElement> productimage;
	
	public void checkAddButton() {
		for(int i=0;i<productimage.size();i++) {
			 System.out.println(addToCartButton.get(i).isEnabled());		
				  if( addToCartButton.get(i).isEnabled()) { 
					  productimage.get(i).click();
					  }
		}	
	}
}
