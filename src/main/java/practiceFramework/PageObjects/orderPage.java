package practiceFramework.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import practiceFramework.Abstractcomponents.AbstractComponent;

public class orderPage extends AbstractComponent{

	WebDriver driver;

	public orderPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	

	 By waitForElement= By.xpath("//div[contains(text(),'Swag Labs')]");
	 
	 @FindBy(css="div[class='inventory_item_name']")
	 List<WebElement> cartproductsList;
	
	 @FindBy(id="checkout")
	 WebElement CheckoutButton;
	 
	public void waitfor() {
		WaitForElementToAppear(waitForElement);
	}
	
	
	
	public boolean varifycartProducts(String productName) {
		boolean match=cartproductsList.stream().anyMatch(cartproduct->cartproduct.getText().contains(productName));
       return match;

	}
	
	
	public checkoutInfoPage clickOnCheckout() {
		CheckoutButton.click();
		checkoutInfoPage infoPage=new checkoutInfoPage(driver);
		return infoPage;
	}
	
}
