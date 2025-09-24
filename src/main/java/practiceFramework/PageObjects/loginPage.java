package practiceFramework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import practiceFramework.Abstractcomponents.AbstractComponent;

public class loginPage extends AbstractComponent {
	
	WebDriver driver;

	public loginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

       //	WebElement name = driver.findElement(By.id("user-name"));
     	//WebElement password = driver.findElement(By.id("password"));
		//password.sendKeys("gunj11");
		// login
		//driver.findElement(By.id("login-button")).click();
	
	@FindBy(id="user-name")
	WebElement nameEle;
	
	@FindBy(id="password")
	WebElement passwordEle;
	
	@FindBy(id="login-button")
	WebElement submit;
	
	public void loginApp(String name, String password) {
		
		nameEle.sendKeys(name);
		passwordEle.sendKeys(password);
	}
	
	public cartPage goTocartPage() {
		submit.click();
		cartPage cart=new cartPage(driver);
		return cart;
	}
	 
	public void goToLoginPage() {
		driver.get("https://www.saucedemo.com/");
	}
	
	
	
}
