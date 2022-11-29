package shop.TestComponents;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Abstract.AbstractComponen;

public class ProductAddToCart extends AbstractComponen {
	ArrayList<String> addedToCart = new ArrayList<String>();
	WebDriver driver;

	String[] productToBeAdded = {  "Shirt" ,"Laptop"};

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

	@Test
	public String[] AddToCart() throws InterruptedException {
		int j=0;
		waitForElementToAppear(productgridpresent);
		for (int i = 0; i <= productgrid.size(); i++) {
			String productNameList = productName.get(i).getText().trim();
			List<String> itemsNeededList = Arrays.asList(productToBeAdded);
			
			if (itemsNeededList.contains(productNameList)) {
				j++;
				addToCartButton.get(i).click();
				Thread.sleep(10000);
				if(j==itemsNeededList.size())
				{
				break;
				}
			}
			addedToCart.add(productNameList);
		}
		miniCartButton.click();
		return productToBeAdded;
	}
	// Data Provider for Product to be added to cart.
	/*
	 * @DataProvider (name = "ProductToBeAddedToCart") public Object[][]
	 * productList() { return new Object[][] {{"Laptop"},{"Shirt"}}; }
	 */
}
