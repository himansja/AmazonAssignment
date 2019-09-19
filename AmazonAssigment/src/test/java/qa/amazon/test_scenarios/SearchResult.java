package qa.amazon.test_scenarios;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.amazon.PO.Amazon_SearchPagePO;
import qa.amazon.base.BaseTest;

public class SearchResult  extends BaseTest {
	public Amazon_SearchPagePO searchPage;

	@BeforeMethod
	public void setUp() {
		searchPage = new Amazon_SearchPagePO(driver);
	}

	@Test
	public void verifySortDropDown() {
		searchPage.sortSearchProduct("Price: Low to High");
	}
	
	@Test
	public void searchProduckAndClick() {
		System.out.println("Sorting of the search result");
		searchPage.sortSearchProduct("Price: Low to High");
		searchPage.clickOnSearchedProduct("Lenovo F309 USB3.0 1TB External Hard Disk, Grey");
	}


}
