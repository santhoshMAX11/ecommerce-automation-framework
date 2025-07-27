package pageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import abstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{
    
	public WebElement driver;
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		
		
		
	}

//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary")));
//    assertEquals(driver.findElement(By.cssSelector(".hero-primary")).getText(),"THANKYOU FOR THE ORDER.");
//	driver.quit();
	@FindBy(css = ".hero-primary")
	WebElement confirmationtext;
	
	By confirmtxt=By.cssSelector(".hero-primary");
	
	public String confirmationtext() {
		waitForElementsToAppear(confirmtxt);
		return confirmationtext.getText();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
