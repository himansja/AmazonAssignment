package qa.amazon.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import qa.amazon.base.BaseTestPageObject;

public class Amazon_LoginPagePO extends BaseTestPageObject {

	public WebDriver driver;

	/** Receiving driver from TestNg Class*/
	public Amazon_LoginPagePO(WebDriver driver) {
		/** Passing driver object to BaseTestPageObjectClass */
		super(driver); 
		this.driver = driver;
	}

	By signInButton = By.xpath("//a[@data-nav-role='signin']//span[@class='nav-line-1']");
	By email_MobileNumberField = By.xpath("//input[@type='email']");
	By continueButton = By.xpath("//input[@id='continue']");
	By passwordField = By.xpath("//input[@type='password']");
	By LoginButton = By.xpath("//input[@id='signInSubmit']");

	public void clickOnSignInButtonFromAmazonHome() {
		clickOnWebElement(signInButton);
	}

	public void enterEmailMobileNumber(String username) {
		sendTextOnElement(email_MobileNumberField, username);
	}

	public void clickOnContinueButton() {
		clickOnWebElement(continueButton);
	}

	public void enterPassword(String pwd) {
		sendTextOnElement(passwordField, pwd);
	}

	public void clickOnLoginButton() {
		clickOnWebElement(LoginButton);	
	}

	/*public Amazon_HomePagePO loginMethod(String un, String pwd)  {
		clickOnSignInButtonFromAmazonHome();
		enterEmailMobileNumber(un);
		clickOnContinueButton();
		enterPassword(pwd);
		clickOnWebElement(LoginButton);	
		return new Amazon_HomePagePO(driver);
	}*/
}
