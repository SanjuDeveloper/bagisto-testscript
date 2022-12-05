package shop.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstract.AbstractComponen;

public class CustomerLoginPageObject extends AbstractComponen {
	WebDriver driver;
	public  CustomerLoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this.driver);
	}
	
	@FindBy (css ="#account span[class=\"rango-arrow-down\"]")
	WebElement accountlogin;
	
	@FindBy (xpath="//a[contains(@href,'customer/login')]")
	
	WebElement signupButton;
	
	@FindBy (xpath = "//input[@name=\"email\"]")
	WebElement loginEmail;
	
	@FindBy (xpath = "//input[@id=\"password\"]")
	WebElement loginPass;
	
	@FindBy (xpath= "//input[@type=\"submit\"]")
	WebElement loginButton;
	
	@FindBy(xpath="//a[@aria-label=\"Logo\"]")
	WebElement homeLogo;
	
	public void customerLogin() throws InterruptedException {
		accountlogin.click();
		signupButton.click();
	    loginEmail.sendKeys("admin@example.com", Keys.TAB);
	    loginPass.sendKeys("Admin123");
	    //waitForWebElementToClickable(loginButton);
	    Thread.sleep(2000);
	    loginButton.click();
	}
}
