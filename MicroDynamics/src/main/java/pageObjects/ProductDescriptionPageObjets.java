package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductDescriptionPageObjets {
	WebDriver driver = null;
	
	@FindBy(xpath = "//div[@class='BreadCrumb_peBreadCrumb__2CyhJ']")
	private WebElement ProductSearchPageNavigation;
	
	@FindBy(xpath = "//h1")
	private WebElement ProductTitle;
	
	public ProductDescriptionPageObjets(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isNavigationShown() {
		boolean navigationFlag = ProductSearchPageNavigation.isDisplayed();
		return navigationFlag;
	}
	
	public String printNavigation() {
		String navigationPath = null;
		if(this.isNavigationShown()) {
			navigationPath = ProductSearchPageNavigation.getText();
			return navigationPath;
		}
		else {
			Assert.fail("Navigation path is not dispalyed on Product Description Page");
		}
		return navigationPath;
	}
	
	public boolean isProductTitleDisplay() {
		boolean productTitleFlag = ProductTitle.isDisplayed();
		return productTitleFlag;
	}
	
	public String printProductTitle() {
		String productTitle = null;
		if(this.isProductTitleDisplay()) {
			productTitle = ProductTitle.getText();
			return productTitle;
		}
		else {
			Assert.fail("Product Title is not displaying after clicing product link");
		}
		return productTitle;
	}

}
