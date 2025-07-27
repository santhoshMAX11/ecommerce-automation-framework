package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import abstractComponents.AbstractComponent;


public class ProductCatague extends AbstractComponent {
	public	WebDriver driver;
	
	
	
//	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".col-lg-4.col-md-6.col-sm-10")));
//    List<WebElement> products= driver.findElements(By.cssSelector(".col-lg-4.col-md-6.col-sm-10"));
//    WebElement pro=   products.stream().filter(p->p.findElement(By.cssSelector("b")).getText().equals(product)).findFirst().orElse(null);  
	//pro.findElement(By.cssSelector(".btn.w-10.rounded")).click();
	
	public ProductCatague(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".col-lg-4.col-md-6.col-sm-10")
	List<WebElement> products;
	
	@FindBy(css = ".btn.w-10.rounded")
	WebElement addtocartbutton;
	
	@FindBy(css = ".ng-animating")
	WebElement animateobject;
	By productsby=By.cssSelector(".col-lg-4.col-md-6.col-sm-10");
	By cartbutton=By.xpath("//*[@routerlink='/dashboard/cart']");
	
	
	
	
	
	public List<WebElement> getproductlist() {
	    waitForElementsToAppear(productsby);
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".col-lg-4.col-md-6.col-sm-10")));
		return products;
	}
	public WebElement getProductByName(String product) {
	
	WebElement pro=   products.stream().filter(p->p.findElement(By.cssSelector("b")).getText().equals(product)).findFirst().orElse(null);  
	return pro;
}
	
	 
	public void addToCart(String product) 
	{
		addtocartbutton.click();
		waitForElementsToAppear(cartbutton);
		waitForWebElementsToAppear(animateobject);
		
		
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@routerlink='/dashboard/cart']")));	
       // wait.until(ExpectedConditions.invisibilityOf(driver.findElement( By.cssSelector(".ng-animating"))));
		}
		
	
	
	
	
	
	
	
	
	
	
	
}
