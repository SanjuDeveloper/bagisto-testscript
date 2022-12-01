package shop.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstract.AbstractComponen;

public class MiniCartAddedProductCountPageObject extends AbstractComponen {
	WebDriver driver;
	public MiniCartAddedProductCountPageObject(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this.driver);
	}

	@FindBy(xpath= "//span[@class=\"badge\"]")
	WebElement minicartcount;
	
	public int productCount() {
		return Integer.parseInt(minicartcount.getText()); 
	}
}
