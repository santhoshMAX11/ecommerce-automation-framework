package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {
	public WebDriver driver;

	public OrderPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".ng-star-inserted td:nth-child(3)")
	List<WebElement> products;

	public boolean verifyTheProducts(String product) {
		boolean check = products.stream().anyMatch(s -> s.getText().equalsIgnoreCase(product));
		return check;
	}

}
