package shop.pageobjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Abstract.AbstractComponen;

public class ProductAddToCartPageObject extends AbstractComponen {
	ArrayList<String> addedToCart = new ArrayList<String>();
	WebDriver driver;
	//String[] productToBeAdded = { "Mobile", "Shirt" ,"Laptop"};
	public ProductAddToCartPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(@class,'product-card-new')]")
	List<WebElement> productcart;

	// By is use for Explicite wait
	By productgridpresent = By.xpath("//div[contains(@class,'product-card-new')]");

	@FindBy(xpath = "(//button[contains(@class,'btn-add-to-cart')])")
	List<WebElement> addToCartButton;

	@FindBy(xpath = "(//div[@class=\"card-body\"]//div[contains(@class,'product-name')])")
	List<WebElement> productName;

	@FindBy(id = "mini-cart")
	WebElement miniCartButton;
	
	By flashMessage = By.xpath("//a[@class='close']");

	public String[] AddToCart(String[] productToBeAdded) throws InterruptedException {
		int j=0;
		waitForElementToAppear(productgridpresent);
		for (int i = 0; i <= productcart.size(); i++) {
			String productNameList = productName.get(i).getText().trim();
			List<String> itemsNeededList = Arrays.asList(productToBeAdded);	
			if (itemsNeededList.contains(productNameList)) {
				j++;
				addToCartButton.get(i).click();
				//To-Do
				/* waitForWebElementToDisappear(flashMessage); */
				Thread.sleep(10000);
				if(j==itemsNeededList.size()) {
					break;
				}
			}
			addedToCart.add(productNameList);
		}
		miniCartButton.click();
		return productToBeAdded;
	}
}
