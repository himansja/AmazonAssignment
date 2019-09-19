package qa.amazon.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import qa.amazon.base.BaseTestPageObject;

public class Amazon_HomePagePO extends BaseTestPageObject {
	
	public WebDriver driver;
	
	
	By searchField = By.xpath("//input[@id='twotabsearchtextbox']");
	By searchIcon = By.xpath("//input[@value='Go']");

	public Amazon_HomePagePO(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	
	public void enterSearchProductName(String text) {
		findElementSafely(searchField).sendKeys(text);
	}
	
	public void clickOnSearchButton() {
		findElementSafely(searchIcon).click();
	}

	public String  getHomePageTitle() {
		return getTitleOfPage();
	}

}
