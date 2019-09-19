package qa.amazon.test_scenarios;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.amazon.PO.Amazon_HomePagePO;
import qa.amazon.PO.Amazon_SearchPagePO;
import qa.amazon.base.BaseTest;

public class AmazonHomePageAfterSignUp extends BaseTest {
	//Amazon_LoginPagePO login;
	public Amazon_HomePagePO homepage;
	Amazon_SearchPagePO search;

	@BeforeMethod
	public void setup() {
		homepage = new Amazon_HomePagePO(driver);
		search = new Amazon_SearchPagePO(driver);

	}

	@Test
	public void searchProduct() {
		homepage.enterSearchProductName("hard disk");
		homepage.clickOnSearchButton();
		System.out.println("search complete");
		
		
		

	}

}
