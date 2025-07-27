package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LandingPage extends AbstractComponent{

	public WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
//	driver.findElement(By.cssSelector("#userEmail")).sendKeys("santoman@gmail.com");
//	driver.findElement(By.cssSelector("#userPassword")).sendKeys("Santoman@11");
//	driver.findElement(By.id("login")).click();
	
//	driver.findElement(By.cssSelector("[role='alert']")).getText()

	@FindBy(css = "#userEmail")
	WebElement Email;
	 
	@FindBy(css = "#userPassword")
	WebElement Password;
	
	@FindBy(id = "login")
	WebElement loginbutton;
	
	@FindBy(xpath  = "//*[@id='toast-container']//*[@aria-label='Incorrect email or password.']")
	WebElement errortext;
	
	public void goToUrl() {
		WebDriverManager.chromedriver().setup();
		
		driver.get("https://rahulshettyacademy.com/client/auth/login");
		
	}
		
		
	public ProductCatague loginApplication(String email,String password) {
		Email.sendKeys(email);
		Password.sendKeys(password);
		loginbutton.click();
		ProductCatague productcatague =new ProductCatague(driver);
	    return	productcatague;
	}

 public String getTheErrorMessage() throws InterruptedException
 {
	waitForWebElementsToAppear(errortext);
	 return errortext.getText();
 }

		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
