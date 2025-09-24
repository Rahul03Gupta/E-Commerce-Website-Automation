package practiceFramework.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import practiceFramework.Abstractcomponents.AbstractComponent;

public class checkoutInfoPage extends AbstractComponent{
	
	WebDriver driver;

	public checkoutInfoPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	


@FindBy(css="input[id='first-name']")
WebElement firstName;
	
@FindBy(css="input[id='last-name']")
WebElement lastName;

@FindBy(css="input[id='postal-code']")
WebElement postalCode;

@FindBy(id="continue")
WebElement continueButton;
	
	
public void information(String firstname,String lastname ,String code) {
	firstName.sendKeys(firstname);
	lastName.sendKeys(lastname);
	postalCode.sendKeys(code);
}

public checkoutOverviewPage goToCheckoutPage() {
	continueButton.click();
	checkoutOverviewPage overview =new checkoutOverviewPage(driver);
	return overview;
}


	
}
