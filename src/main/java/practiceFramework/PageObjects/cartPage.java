package practiceFramework.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import practiceFramework.Abstractcomponents.AbstractComponent;

public class cartPage extends AbstractComponent{
	WebDriver driver;

	public cartPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//List<WebElement> productsList = driver.findElements(By.cssSelector("div[class='inventory_item']"));
	
	@FindBy(css="div[class='inventory_item']")
	List<WebElement> productsList;

	
By addToCart =By.cssSelector(".btn_primary");
By waitForElement=By.cssSelector("div[class='inventory_item'] button");

//driver.findElement(By.cssSelector("div[id='shopping_cart_container'] a")).click();


	
	public List<WebElement> getproductlist() {
		return productsList;
	}
	
	
	public WebElement getProductName(String productName) {
		  WebElement prod=productsList.stream().filter(product->product.findElement(By.cssSelector("div[class='inventory_item_name']"))
					.getText().contains(productName)).findFirst().orElse(null);
		  
		  return prod;
	}
	
	
	public void addToCart(String productName) {
		WebElement prod=getProductName(productName);
		prod.findElement(addToCart).click();
	}
	public orderPage gotoOrderPage() {
		orderPage orderpage=new orderPage(driver);
		return orderpage;
	}
	  public void waitFor() {
		  
		  WaitForElementToAppear(waitForElement);
		  waitForElement.equals("remove");
	  }
	
	
	
	
	
	
}
