package practiceFramework.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import practiceFramework.Abstractcomponents.AbstractComponent;

public class checkoutOverviewPage extends AbstractComponent {
	
	
	WebDriver driver;

	public checkoutOverviewPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div[class='summary_info'] div:nth-child(2)")
	WebElement summerydetail;
	
	@FindBy(css="button[id='finish']")
	WebElement submit;
	
	
	public String getPayMentInfo() {
	String id=	summerydetail.getText();
		return id;
	}

	
	public ConfirmationPage gotoconfirmationPage() {
		submit.click();
		ConfirmationPage confirmorder= new ConfirmationPage(driver);
		return confirmorder;
	}
	
	

}
