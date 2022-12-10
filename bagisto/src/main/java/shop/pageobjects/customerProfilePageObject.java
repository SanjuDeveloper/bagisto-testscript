package shop.pageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class customerProfilePageObject {
WebDriver driver;
	public customerProfilePageObject() {
		this.driver = driver;
	}
	
	/* To-Do Need to add Test case for Customer Profile .*/
	@FindBy(xpath ="//tbody//tr")
	List<WebElement> totalRow;
	
	@FindBy(xpath= "(//tbody//tr//td[1])")
	List<WebElement> tableAttribute;
	
	@FindBy(xpath = "(//tbody//tr//td[2])")
	List<WebElement> tableValue;
	
	public void customerProfile() {
	 for(int i=0;i<=totalRow.size();i++) {
	    	System.out.println(tableAttribute.get(i).getText()+"--->"+tableValue.get(i).getText());
	    }
	}
}
