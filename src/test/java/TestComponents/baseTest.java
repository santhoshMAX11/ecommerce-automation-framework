package TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPage;

public class baseTest {
	
	//i made changes
	public WebDriver driver;//after creating gobally,edit locally
	public LandingPage landingpage;

	public WebDriver initializeDriver() throws IOException {

		Properties pro = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\GobalData.Properties");
		pro.load(fis);
		
		String browserName=System.getProperty("browser")!=null ? System.getProperty("browser"):pro.getProperty("browser");//maven & jenkins run
    	//String browserName = pro.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver =new EdgeDriver();
			//WebDriverManager.edgedriver().setup();
			//driver = new EdgeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	@BeforeMethod(alwaysRun = true)
	public LandingPage launchingApplication() throws IOException {
		driver = initializeDriver();
		landingpage = new LandingPage(driver);
		landingpage.goToUrl();
		//System.out.println("Launching browser instance: " + Thread.currentThread().getId());
        return landingpage;
	}

	@AfterMethod(alwaysRun = true)
	public void close() {

		driver.quit();
	}

	public String getScreenshot(String TestCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir")+"//reports//"+ TestCaseName + ".png");
		FileUtils.copyFile(source,destination);
	    return destination.getAbsolutePath();
		
	}

	public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException {
	
	   String jsonContent=  FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);
	   ObjectMapper mapper =new ObjectMapper();
	   List<HashMap<String,String>> data=   mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {}); 
	   return data;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
