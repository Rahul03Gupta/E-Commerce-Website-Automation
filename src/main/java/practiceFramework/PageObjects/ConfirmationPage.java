package practiceFramework.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import practiceFramework.Abstractcomponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {
	
	
	
	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div[id='checkout_complete_container'] h2")
	WebElement cofirmmsg;
	
	@FindBy(xpath="//button[@class='btn btn_primary btn_small']")
	WebElement homePage;
	
	public String getconfirmmsg() {
		 String msg=cofirmmsg.getText();
		 return msg;
	}
	
	public void gotoHomePage() {
		homePage.click();
	}

}
