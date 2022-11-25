package admin.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Abstract.AbstractComponen;

public class CreateProductPageObject extends AbstractComponen {
	WebDriver driver;

	public CreateProductPageObject(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[@class='icon catalog-icon']")
	WebElement catalogIcon;
	
	@FindBy(linkText ="Add Product")
	WebElement addProduct;
	
	@FindBy(id="type")
	WebElement selectProductType;
	
	
	@FindBy(id="attribute_family_id")
	WebElement attributeFamily;
	
	@FindBy(id="sku")
	WebElement productSKU;
	
	@FindBy(css="button[class='btn btn-lg btn-primary']")
	WebElement saveProduct;
	
	By addButton = By.linkText("Add Product");
	By selectType = By.id("type");
	
	public void createSimpleProduct() throws InterruptedException {
		 Thread.sleep(5000); // wait for element load
		 catalogIcon.click();
		 waitForElementToAppear(addButton); //explicitly wait
		 addProduct.click();
		 waitForElementToAppear(selectType);
		 selectProductType.click();
		 Select productType = new Select(selectProductType);
		 productType.selectByVisibleText("Simple"); // Select Product Type
		 attributeFamily.click();
		 Select Family = new Select(attributeFamily);
		 Family.selectByVisibleText("Default"); // Select Attribute Family
		 productSKU.sendKeys("mens-tshirt");
		 saveProduct.click();
	}

}

