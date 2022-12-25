package Abstract;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AbstractLocator {
	
	/*Can use all these locator in Abstract component*/
	  @FindBy(css="span[class=\"flatpickr-next-month\"]")
	  WebElement nextMonth;
	  
	  @FindBy(css="select[class=\"flatpickr-monthDropdown-months\"]")
	  WebElement selectMonth;  
	  
		
	  @FindBy(css="div[id=\"mini-cart\"]")
	  WebElement miniCart;
		
	  @FindBy(xpath="//a[text()='View Shopping Cart']")
	  WebElement shoppingCart;

	  @FindBy(xpath="(//a[@aria-label=\"Logo\"])[1]")
	  public  WebElement homeLogo;
	  
	 @FindBy(xpath="//div[@class=\"dayContainer\"]")
	 WebElement slectDayParent;  
	  
}
