package admin.pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
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
	
	@FindBy(xpath="//p[text()='Product created successfully.']")
	WebElement successMessage;
	
	@FindBy(css="input[id='name']")
	WebElement productName;
		
	@FindBy(css="label[for='new']")
	WebElement NEW;
	
	@FindBy(xpath="//label[@for='featured']")
	WebElement featured;
	
	@FindBy(css="label[for='visible_individually']")
	WebElement visibleIndividually;
	
	@FindBy(xpath="//label[@for='guest_checkout']")
	WebElement guestCheckout;
	
	@FindBy(xpath="//label[@for='status']")
	WebElement status;
	
	@FindBy(xpath="//div[@class='page-content']/div[2]/div[1]")
	WebElement descriptionSection;
	
	@FindBy(xpath="//div[@class='page-content']/div[4]/div[1]")
	WebElement priceSection;
	
	@FindBy(xpath="//div[@class='page-content']/div[5]/div[1]")
	WebElement shippngSection;
	
	@FindBy(xpath="//div[@class='page-content']/div[6]/div[1]")
	WebElement inventorySection;
	
	@FindBy(xpath="//div[@class='page-content']/div[7]/div[1]")
	WebElement imageSection;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[4]/div/div[2]/div[2]/form/div[2]/div[7]/div[2]/div/div/div/label")
	WebElement AddImage;
	
	@FindBy(css="label[class='image-item']")
	WebElement selectImage;
	
	By addButton = By.linkText("Add Product");
	By selectType = By.id("type");
	By productNameInputBox = By.cssSelector("input[id='name']");

	public void createSimpleProduct() throws InterruptedException {
		// Thread.sleep(5000); // wait for element load
		 waitForWebElementToAppear(catalogIcon);
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
		 if(successMessage.isDisplayed()) {
			 //Take Screenshot
		 }
	}
	
	public void createdOrEditProduct() throws InterruptedException, IOException {
	
		waitForElementToAppear(productNameInputBox); //explicitly wait
		productName.sendKeys("t-shirt");		
		scrollDown(driver,460);	
		
		System.out.println(NEW.isDisplayed());
		waitForWebElementToAppear(NEW);
		NEW.click();
		
		System.out.println(NEW.isDisplayed());
		waitForWebElementToAppear(featured);
		featured.click();
		
		System.out.println(visibleIndividually.isDisplayed());
		waitForWebElementToAppear(visibleIndividually);
		visibleIndividually.click();
		
		System.out.println(guestCheckout.isDisplayed());
		waitForWebElementToAppear(guestCheckout);
		guestCheckout.click();
		
		scrollDown(driver,360);
		
		System.out.println(status.isDisplayed());
		waitForWebElementToAppear(status);
		status.click();
		
		scrollDown(driver,800);
		
		System.out.println(imageSection.isDisplayed());
		waitForWebElementToAppear(imageSection);
		imageSection.click();
		
		System.out.println(AddImage.isDisplayed());
		waitForWebElementToAppear(AddImage);
		AddImage.click();
		
		Thread.sleep(1000);
		System.out.println(selectImage.isDisplayed());
		selectImage.click();
		Thread.sleep(1000);
		Runtime.getRuntime().exec("D:\\bagisto-testscript\\Fileupload.exe");
	}

}


