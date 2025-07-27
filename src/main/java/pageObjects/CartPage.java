package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	  WebDriver driver;

    public CartPage(WebDriver driver) {
    	super(driver);
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
			}

    @FindBy(css = ".cartSection h3")
    List<WebElement> cartproducts;
    
    @FindBy(xpath = "//*[text()='Checkout']")
    WebElement checkoutpage;
    
    public boolean verifyProducts(String product) {
    	return cartproducts.stream().anyMatch(c->c.getText().equalsIgnoreCase(product));
    
    }
    
    
    public CheckOutPage goToCheckout() throws InterruptedException {
    	Thread.sleep(3000);
    	checkoutpage.click();
    	CheckOutPage checkoutpage=new CheckOutPage(driver);
    	return checkoutpage;
    }
    
    
    
    
    
    
    
    
    
    
}
