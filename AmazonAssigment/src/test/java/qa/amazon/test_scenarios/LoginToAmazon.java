package qa.amazon.test_scenarios;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.amazon.PO.Amazon_HomePagePO;
import qa.amazon.PO.Amazon_LoginPagePO;
import qa.amazon.base.BaseTest;

public class LoginToAmazon extends BaseTest {

	public Amazon_LoginPagePO login;
	public Amazon_HomePagePO homePage;



	@BeforeMethod
	public void setup() {
		login = new Amazon_LoginPagePO(driver);
		homePage = new Amazon_HomePagePO(driver);
	}


	@Test
	public void loginAmazon() throws InterruptedException  {
		System.out.println("Start login");
		login.clickOnSignInButtonFromAmazonHome();
		System.out.println("next line");
		login.enterEmailMobileNumber(config.getUserName());
		login.clickOnContinueButton();
		login.enterPassword(config.getPassword());
		login.clickOnLoginButton();

		//login.loginMethod("himanshu080290@gmail.com", "Himanshu@0802");

		String title = homePage.getHomePageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, "
				+ "Books, Watches, Shoes and More - Amazon.in");
		System.out.println("Successfull Login");

	}
}
