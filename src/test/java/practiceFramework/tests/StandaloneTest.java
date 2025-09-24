package practiceFramework.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;



public class StandaloneTest {      
	
  public static void main(String []args) {
	  
	  
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	// launch the website
	driver.get("https://www.saucedemo.com/");

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().window().maximize();
	// username
	WebElement name = driver.findElement(By.id("user-name"));
	name.sendKeys("gunjan");
	// password
	WebElement password = driver.findElement(By.id("password"));
	password.sendKeys("gunj11");
	// login
	driver.findElement(By.id("login-button")).click();
	// geterrormsg
	String errormsg = driver.findElement(By.cssSelector("div[class*='error-message'] h3")).getText();
	
	// print that msg
	System.out.println(errormsg);
	// click on cross to remove error msg
	driver.findElement(By.cssSelector("svg[data-icon='times']")).click();
	// clear username
	name.clear();

	
	// enter valid usernae
	name.sendKeys("standard_user");

	// remove password and enter valid password
	password.clear();
	password.sendKeys("secret_sauce");
	driver.findElement(By.id("login-button")).click();
	
	
    driver.findElement(By.cssSelector("select[class='product_sort_container']")).click();
	
	WebElement sele=driver.findElement(By.cssSelector("select[class='product_sort_container']"));
	Select sc=new Select (sele);
	
	sc.selectByValue("za");
	

	

	// add to cart page
	// add items in add to cart
	String productName = "Onesie";

	// get all products in the list
	List<WebElement> productsList = driver.findElements(By.cssSelector("div[class='inventory_item']"));
	
	   WebElement prod=productsList.stream().filter(product->product.findElement(By.cssSelector("div[class='inventory_item_name']"))
			.getText().contains(productName)).findFirst().orElse(null);
	// click on the add to cart icon
	    prod.findElement(By.cssSelector(".btn_primary")).click();
	    
	    driver.findElement(By.cssSelector("div[id='shopping_cart_container'] a")).click();

	List<WebElement> cartproductsList = driver.findElements(By.cssSelector("div[class='inventory_item_name']"));
	
	// click one product in add to cart
	boolean match=cartproductsList.stream().anyMatch(cartproduct->cartproduct.getText().contains(productName));
          Assert.assertTrue(match);

	
	driver.findElement(By.id("checkout")).click();


	// information
	driver.findElement(By.cssSelector("input[id='first-name']")).sendKeys("vani");
	driver.findElement(By.cssSelector("input[id='last-name']")).sendKeys("rawal");
	driver.findElement(By.cssSelector("input[id='postal-code']")).sendKeys("123456");
	driver.findElement(By.id("continue")).click();

	WebElement summerydetail = driver.findElement(By.cssSelector("div[class='summary_info'] div:nth-child(2)"));

	System.out.println(summerydetail.getText());

	driver.findElement(By.cssSelector("button[id='finish']")).click();

	WebElement confirmMassage = driver.findElement(By.cssSelector("div[id='checkout_complete_container'] h2"));
	System.out.println(confirmMassage.getText());
	
	driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small']")).click();
	
	driver.close();

}
}



