package qa.amazon.test_scenarios;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.amazon.PO.productDetailPagePO;
import qa.amazon.base.BaseTest;

public class productDetailPage extends BaseTest{
	public productDetailPagePO productPage;
	
	@BeforeMethod
	public void setup() {
		productPage = new productDetailPagePO(driver);
	}
	
	@Test
	public void testCapacityChange() {
	productPage.clickOnHardDiskSize("2TB");
	}
}
