package shop.pageobjects;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Abstract.AbstractComponen;

public class MiniCartProductListPageObject extends AbstractComponen {
	ArrayList<String> productMiniCart = new ArrayList<String>();
	WebDriver driver;
	public MiniCartProductListPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='mini-cart-content']")
	WebElement miniCart;

	@FindBy(xpath = "//div[@class='mini-cart-container'] //div[contains(@class,'product-name')]")
	List<WebElement> miniCartPoduct;

	public ArrayList<String> getAddedProduct() {
		for (int i = 0; i < miniCartPoduct.size(); i++) {
			productMiniCart.add(miniCartPoduct.get(i).getText());
		}
		return productMiniCart;
	}
}
