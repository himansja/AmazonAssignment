package qa.amazon.PO;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import qa.amazon.base.BaseTestPageObject;

public class Amazon_SearchPagePO extends BaseTestPageObject {

	WebDriver driver;


	public Amazon_SearchPagePO(WebDriver driver) {
		super(driver);
		this.driver= driver;
	}


	By paginationCount = By.xpath("//li//following-sibling::li[@class='a-disabled']");
	By SearchProductList = By.xpath("//span[@data-component-type='s-search-results']/div/div/descendant::span[contains(@class,'a-text-normal')]");
	By pagiantionNextButton = By.xpath("//span//ul[@class='a-pagination']//li[contains(@class,'a-last')]");
	By paginationNextButtonEnabled = By.xpath("//span//ul[@class='a-pagination']//li[@class='a-last']");
	By pagiantionBlock = By.xpath("//span[@data-component-type='s-pagination']/div[@class='a-section s-border-bottom']");
	By submit = By.xpath("//span[@id='a-autoid-1']");
	By sortByDropDown = By.xpath("//span[@class='a-dropdown-container']");
	By dropDownList = By.xpath("//li[@class='a-dropdown-item']//a");

	public void sortSearchProduct(String sortBy) {
		clickOnWebElement(sortByDropDown);
		List<WebElement> dropList = findMultipleElementSafely(dropDownList);
		for(int i=0;i<dropList.size();i++) {
			if(dropList.get(i).getText().equalsIgnoreCase(sortBy)) {
				dropList.get(i).click();
				break;
			}

		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickOnSearchedProduct(String productName) {

		boolean flag = false;

		while(findElementSafely(pagiantionNextButton).isEnabled()) {

			List<WebElement> searchList = findMultipleElementSafely(SearchProductList);
			System.out.println(searchList.size());
			for(int i=0;i<searchList.size();i++) {	
				System.out.println("S.No" +i + " = "+searchList.get(i).getText());

				if(searchList.get(i).getText().equalsIgnoreCase(productName)) {
					WebElement l = searchList.get(i);
					Actions a= new Actions(driver);
					a.moveToElement(l).build().perform();
					a.click().build().perform();
					flag= true;
					switchToWindow();
					break;
				}		

			}

			if(flag) {
				break;
			}


			else if(!isClickable(pagiantionNextButton, driver)) {
				WebElement el = findElementSafely(paginationNextButtonEnabled);
				Actions a = new Actions(driver);
				a.moveToElement(el).build().perform();
				a.click().build().perform();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			else {
				break;
			}
		}


		System.err.println("PRODUCT NOT FOUND MATCHING YOUR CRITERIA");
	} 
}



