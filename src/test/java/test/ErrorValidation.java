package test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestComponents.baseTest;
import pageObjects.CartPage;
import pageObjects.ProductCatague;

public class ErrorValidation extends baseTest {

	
	@Test
	public void loginErroValidation() throws InterruptedException {
	    landingpage.loginApplication("santoman@gmail.com", "Santoman11");
	  String text=  landingpage.getTheErrorMessage();
		assertEquals(text, "Incorrect email or password.");
		
	}
	
	@Test
	public void productErrorValidation() throws InterruptedException
	{
		String product = "ZARA COAT 3";

		ProductCatague productcatague = landingpage.loginApplication("santoman@gmail.com", "Santoman@11");
		productcatague.getproductlist();
		productcatague.getProductByName(product);
		productcatague.addToCart(product);
		CartPage cartpage = productcatague.goToCartPage();
		boolean check = cartpage.verifyProducts(product);
		Assert.assertTrue(check);
	}
	
	
	
	
	
	
}
