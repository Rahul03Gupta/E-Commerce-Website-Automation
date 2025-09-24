package practiceFramework.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import practiceFramework.PageObjects.ConfirmationPage;
import practiceFramework.PageObjects.cartPage;
import practiceFramework.PageObjects.checkoutInfoPage;
import practiceFramework.PageObjects.checkoutOverviewPage;
import practiceFramework.PageObjects.loginPage;
import practiceFramework.PageObjects.orderPage;

public class submitorderTest {

	
	  public static void main(String []args) {
		  
		  
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		    String productName = "Onesie";
          
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().window().maximize();
			// username
			
			loginPage login= new loginPage(driver);
			login.goToLoginPage();
			login.loginApp("standard_user", "secret_sauce");
			cartPage cart=	login.goTocartPage();
			
			List<WebElement> products=cart.getproductlist();
			cart.addToCart(productName);
			cart.clickonaddToCart();
			orderPage orderpage=cart.gotoOrderPage();
		
			boolean match= orderpage.varifycartProducts(productName);
	      	Assert.assertTrue(match);
	      	checkoutInfoPage infoPage=orderpage.clickOnCheckout();
	    
	    	String text1=infoPage.getHeaderText();
	    	Assert.assertEquals(text1,"Checkout: Your Information");
	    	infoPage.information("vani", "rawal", "11111");
	    	checkoutOverviewPage overview=infoPage.goToCheckoutPage();
	    	
	    	 String text=overview.getHeaderText();
	    	 Assert.assertEquals(text,"Checkout: Overview");
	    	String id= overview.getPayMentInfo();
              System.out.println(id);
              ConfirmationPage confirmorder=overview.gotoconfirmationPage();
			
			 String text2=confirmorder.getHeaderText();
	    	 Assert.assertEquals(text2,"Checkout: Complete!");
	    	//String msg= confirmorder.getconfirmmsg();
			System.out.println(confirmorder.getconfirmmsg());
			confirmorder.gotoHomePage();
			driver.close();

		}
}
