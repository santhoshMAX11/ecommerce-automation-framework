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

 
	

	//  List<WebElement> cartproducts=driver.findElements(By.cssSelector(".cartSection h3"));
//    boolean check=  cartproducts.stream().anyMatch(c->c.getText().equalsIgnoreCase(product));
//    Thread.sleep(3000);
//    driver.findElement(By.xpath("//*[text()='Checkout']")).click(); 
 //   driver.findElement(By.xpath("//*[text()='Checkout']")).click();
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
