package practiceFramework.Abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {

	 WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated  stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//common header
	@FindBy(css="a[class='shopping_cart_link']")
	WebElement addCartIcon;
	
	@FindBy(css="div[class='header_secondary_container']")
	WebElement HeaderText;
	
	public void WaitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));
	}
	
	public void clickonaddToCart() {
		addCartIcon.click();
	}
	
	public String getHeaderText() {
		String text=HeaderText.getText();
		return text;
	}
	
}
