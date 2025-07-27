package abstractComponents;

import java.awt.print.PageFormat;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.CartPage;
import pageObjects.OrderPage;

public class AbstractComponent {

    WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	//driver.findElement(By.xpath("//*[@routerlink='/dashboard/cart']")).click();
	@FindBy(xpath = "//*[@routerlink='/dashboard/cart']")
	WebElement cartpage;
	
	@FindBy(css = "[routerlink='/dashboard/myorders']")
	WebElement orderpage;
	
	
	public CartPage goToCartPage() throws InterruptedException {
		Thread.sleep(5000);
		cartpage.click();
		CartPage cartpage = new CartPage(driver);
		return cartpage;
		
	}
	
	public void waitForElementsToAppear(By web) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(7));
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(web));
	}
	
	
	public void waitForWebElementsToAppear(WebElement web) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(7));
		 wait.until(ExpectedConditions.visibilityOfAllElements(web));
	}
	
	public OrderPage goToOrderPage() {
		orderpage.click();
		OrderPage orderpage=new OrderPage(driver);
		return orderpage;
	}
	
	
	
	
	
}
