package shop.TestComponents;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Abstract.AbstractComponen;

public class ProductAddToCart extends AbstractComponen {
	ArrayList<String> addedToCart = new ArrayList<String>();
	WebDriver driver;

	public ProductAddToCart(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(@class,'product-card-new')]")
	List<WebElement> productgrid;
	
	// By is use for Explicite wait
	By productgridpresent = By.xpath("//div[contains(@class,'product-card-new')]");

	@FindBy(xpath = "(//button[contains(@class,'btn-add-to-cart')])")
	List<WebElement> addToCartButton;

	@FindBy(xpath = "(//div[@class=\"card-body\"]//div[contains(@class,'product-name')])")
	List<WebElement> productName;

	@FindBy(id = "mini-cart")
	WebElement miniCartButton;

	public void AddToCart() throws InterruptedException {
          waitForElementToAppear(productgridpresent);
		int totalProduct = productgrid.size();
		System.out.println(totalProduct);
		for (int i = 0; i <= totalProduct; i++) {
			if (i == 1 || i == 2) {
				addToCartButton.get(i).click();
				Thread.sleep(10000);
				addedToCart.add(productName.get(i).getText());
			}
		}
		System.out.println("List of Added Product in cart");
		for (String addedProductToCart : addedToCart) {

			System.out.println(addedProductToCart);
		}
		miniCartButton.click();
		//Thread.sleep(10000);
	}

	public ArrayList<String> listofaddedProduct() {
		return addedToCart;
	}
}
