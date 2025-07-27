package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
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
import org.testng.annotations.Test;

import TestComponents.baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.CartPage;
import pageObjects.CheckOutPage;
import pageObjects.ConfirmationPage;
import pageObjects.LandingPage;
import pageObjects.OrderPage;
import pageObjects.ProductCatague;
//updated files
public class FinaloutTest extends baseTest {
	String product = "ZARA COAT 3";

	@Test(dataProvider = "getData")
	public void finaloutTest(HashMap<String, String> input) throws InterruptedException {

		ProductCatague productcatague = landingpage.loginApplication(input.get("email"),input.get("password"));
		productcatague.getproductlist();
		productcatague.getProductByName(input.get("product"));
		productcatague.addToCart(input.get("product"));
		CartPage cartpage = productcatague.goToCartPage();
		boolean check = cartpage.verifyProducts(input.get("product"));
		// Assert.assertTrue(check);
		CheckOutPage checkoutpage = cartpage.goToCheckout();
		checkoutpage.enterDetails("1109", "santoman", "India");
		ConfirmationPage confirmationpage = checkoutpage.placeorder(driver);
		String confirmtext = confirmationpage.confirmationtext();
		AssertJUnit.assertEquals(confirmtext, "THANKYOU FOR THE ORDER.");
	}
		
		@Test(dependsOnMethods = {"finaloutTest"})
		public void OrderHistoryTest() {
			ProductCatague productcatague = landingpage.loginApplication("santoman@gmail.com", "Santoman@11");
			OrderPage orderpage =productcatague.goToOrderPage();
			Assert.assertTrue(orderpage.verifyTheProducts(product));
		}
		
		@DataProvider
		public  Object[][] getData() throws IOException {
		List<HashMap<String,String>> data=	getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\data\\data.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
		}
		
		
		
		
		
		
		
		

	}

