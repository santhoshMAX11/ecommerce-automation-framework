package test;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		String product="ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(7));
		
		driver.get("https://rahulshettyacademy.com/client/auth/login");
		driver.findElement(By.cssSelector("#userEmail")).sendKeys("santoman@gmail.com");
		driver.findElement(By.cssSelector("#userPassword")).sendKeys("Santoman@11");
		driver.findElement(By.id("login")).click();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".col-lg-4.col-md-6.col-sm-10")));
        List<WebElement> products= driver.findElements(By.cssSelector(".col-lg-4.col-md-6.col-sm-10"));
        WebElement pro=   products.stream().filter(p->p.findElement(By.cssSelector("b")).getText().equals(product)).findFirst().orElse(null);  
        pro.findElement(By.cssSelector(".btn.w-10.rounded")).click();
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@routerlink='/dashboard/cart']")));	
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement( By.cssSelector(".ng-animating"))));
        Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@routerlink='/dashboard/cart']")).click();
       // wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.cssSelector(".cartSection"))));
	    List<WebElement> cartproducts=driver.findElements(By.cssSelector(".cartSection h3"));
	    boolean check=  cartproducts.stream().anyMatch(c->c.getText().equalsIgnoreCase(product));
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//*[text()='Checkout']")).click();
		
	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".input.txt.text-validated")));
		driver.findElement(By.xpath("(//*[@class='input txt'])[1]")).sendKeys("1109");
		driver.findElement(By.xpath("(//*[@class='input txt'])[2]")).sendKeys("santoman");
		driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("India");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ta-item.list-group-item.ng-star-inserted")));
	    List<WebElement> country=	driver.findElements(By.cssSelector(".ta-item.list-group-item.ng-star-inserted"));
	    country.stream().filter(f->f.getText().equals("India")).findFirst().ifPresent(WebElement::click);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnn.action__submit.ng-star-inserted")));
	    Thread.sleep(5000);
		driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary")));
	    assertEquals(driver.findElement(By.cssSelector(".hero-primary")).getText(),"THANKYOU FOR THE ORDER.");
		driver.quit();
		
		
		
		
		

	}

}
