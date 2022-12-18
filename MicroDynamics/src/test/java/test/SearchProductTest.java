package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePageObjects;
import pageObjects.ProductDescriptionPageObjets;


public class SearchProductTest {
	WebDriver driver = null;
	HomePageObjects hpo = null;
	ProductDescriptionPageObjets pdpo = null;
	
	@BeforeClass
	void launchApplication() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Akash Kare\\OneDrive\\Documents\\Automation\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://pharmeasy.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		hpo = new HomePageObjects(driver);
		pdpo = new ProductDescriptionPageObjets(driver);
	}
	
	@Test(priority=1)
	void urlTest() {
		String actualURL = hpo.getApplicationUrl();
		Assert.assertEquals(actualURL, "https://pharmeasy.in/", "URL Test is successful");
	}
	
	@Test(priority=2)
	void logoTest() {
		boolean actualLogo = hpo.isLogoPresent();
		Assert.assertTrue(actualLogo, "Logo Test Successful");
	}
	
	@Test(priority=3)
	void searchProduct() {
		hpo.clickSearchBar();
		hpo.setInputSerachBar("Dolo");
		hpo.clickFirstSearchResult();
		String navigationPath = pdpo.printNavigation();
		System.out.println(navigationPath);
		String productTitle = pdpo.printProductTitle();
		System.out.println(productTitle);
	}

	@AfterClass
	void closeApplication() {
		driver.quit();
	}
}
