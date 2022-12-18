package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePageObjects {
	WebDriver driver = null;
	Actions act;
	
	@FindBy(xpath = "(//span[text()='Search for']//parent::div)[2]") 
	private WebElement SearchBar;
	
	@FindBy(xpath = "//input[@id='topBarInput']")
	private WebElement InputSearchBar;
	
	@FindBy(xpath = "(//div[@class='c-PJLV c-bXbWpx c-bXbWpx-bZJlhX-direction-column c-bXbWpx-iioqier-css']//a)[1]")
	private WebElement FirstSearchResult;
	
	@FindBy(xpath= "//a[@href='/']")
	private WebElement Logo;
	
	public HomePageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
	}
	
	public String getApplicationUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public boolean isLogoPresent() {
		boolean logoFlag = Logo.isDisplayed();
		return logoFlag;
	}
	
	public boolean isSearchBarDisplay() {
		boolean searchBarFlag = SearchBar.isDisplayed();
		return searchBarFlag;
	}
	
	public void clickSearchBar() {
		if(this.isSearchBarDisplay()) {
			SearchBar.click();
		}
		else {
			Assert.fail("SearchBar is not displaying on homepage");
		}
	}
	
	public boolean isInputSerachBarEnabled() {
		boolean inputSearchBarFlag = InputSearchBar.isEnabled();
		return inputSearchBarFlag;
	}
	
	public void setInputSerachBar(String search) {
		if(this.isInputSerachBarEnabled()) {
			InputSearchBar.sendKeys(search);
		}
		else {
			Assert.fail("SearchInput Field is not enabled on homepage");
		}
	}
	
	public boolean isFirstResutEnabled() {
		boolean firstSearchResultFlag = FirstSearchResult.isEnabled();
		return firstSearchResultFlag;
	}
	
	public void clickFirstSearchResult() {
		if(this.isFirstResutEnabled()) {
			act.moveToElement(FirstSearchResult).click().build().perform();
		}
		else {
			Assert.fail("First Search Result for serached text is not present" );
		}
	}
}
