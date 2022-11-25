package admin.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstract.AbstractComponen;

public class LoginPageObject extends AbstractComponen {
	
	WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(css="button[class*='btn-primary']")
	WebElement loginButton;
	
	public void Login() {
		email.sendKeys("admin@example.com");
		password.sendKeys("admin123");
		loginButton.click();
	}
}
