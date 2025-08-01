package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import abstractComponents.AbstractComponent;

public class CheckOutPage  extends AbstractComponent{
    public WebDriver driver;
    
	public CheckOutPage(WebDriver driver) {
	        super(driver);
	        this.driver=driver;
	        PageFactory.initElements(driver, this);
	}
	
	
	

	@FindBy(xpath = "(//*[@class='input txt'])[1]")
	WebElement cvv;
	@FindBy(xpath = "(//*[@class='input txt'])[2]")
	WebElement nameoncard;
	@FindBy(css  = "[placeholder='Select Country']")
	WebElement country;
	@FindBy(css = ".ta-item.list-group-item.ng-star-inserted")
	List<WebElement> countrylist;
	@FindBy(css = ".btnn.action__submit.ng-star-inserted")
	WebElement submit;
	
	By input=By.cssSelector(".input.txt.text-validated");
	By list=By.cssSelector(".ta-item.list-group-item.ng-star-inserted");
	By actionbutton=By.cssSelector(".btnn.action__submit.ng-star-inserted");
	
	
	
	
	public void enterDetails(String cvvno,String name,String countryname) throws InterruptedException {
		waitForElementsToAppear(input);
		cvv.sendKeys(cvvno);
		nameoncard.sendKeys(name);
		country.sendKeys(countryname);
		waitForElementsToAppear(list);
		countrylist.stream().filter(f->f.getText().equals(countryname)).findFirst().ifPresent(WebElement::click);
		
	}
	
	public ConfirmationPage placeorder(WebDriver driver) throws InterruptedException {
		waitForElementsToAppear(actionbutton);
		Thread.sleep(5000);
		submit.click();
		ConfirmationPage confirmationpage = new ConfirmationPage(driver);
		return confirmationpage;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
