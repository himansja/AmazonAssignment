package qa.amazon.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTestPageObject {
	public WebDriver driver;


	public BaseTestPageObject(WebDriver driver) {
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	public  WebElement findElementSafely(final By locator) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(180, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(StaleElementReferenceException.class, NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver,WebElement>(){
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});
		return foo;
	}

	public  List<WebElement> findMultipleElementSafely(final By locator) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(180, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(StaleElementReferenceException.class, NoSuchElementException.class);

		List<WebElement> foo = wait.until(new Function<WebDriver,List<WebElement>>(){
			public List<WebElement> apply(WebDriver driver) {
				return driver.findElements(locator);
			}
		});
		return foo;
	}





	public void clickOnWebElement(By locator) {
		findElementSafely(locator).click();
	}

	public void sendTextOnElement(By locator, String text) {
		WebElement elm =findElementSafely(locator);
		elm.clear();
		elm.sendKeys(text);
	}

	public String getTextOfElement(By locator) {
		WebElement elm = findElementSafely(locator);
		return elm.getText();
	}

	public void getAttributeOfElement(By locator, String name) {
		WebElement elm = findElementSafely(locator);
		elm.getAttribute(name);
	}

	public boolean isElementClickable(By locator) {
		WebElement elm = findElementSafely(locator);
		return elm.isEnabled();
	}

	public boolean isElementSelected(By locator) {
		WebElement elm = findElementSafely(locator);
		return elm.isSelected();
	}

	public String getTitleOfPage() {
		return driver.getTitle();
	}


	public void waitForVisibilityOf(By locator,Integer...timeoutSeconds){
		int attempts =0;
		while (attempts < 2){
			try{
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator),(timeoutSeconds.length >0 ?timeoutSeconds[0]:null));
				break;
			}catch(Exception e){
				attempts++;
			}
		}
	}

	public void waitFor(ExpectedCondition<WebElement> condition, Integer timeoutInSeconds){
		timeoutInSeconds = timeoutInSeconds !=null ? timeoutInSeconds:30;
		WebDriverWait wait = new WebDriverWait(driver,timeoutInSeconds);
		wait.until(condition);
	}

	public boolean isClickable(By locator, WebDriver driver) 
	{

		WebElement el =findElementSafely(locator);
		String classes = el.getAttribute("class");
		boolean btn = classes.contains("a-disabled a-last");
		return btn;

	}

	public void switchToWindow() {
		String parentWindow = driver.getWindowHandle();
		Set<String> setWindowsID = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(setWindowsID);
		for(int i=0;i<window.size();i++) {

			if(!(window.get(i).equals(parentWindow))) {
				driver.switchTo().window(window.get(i));
				System.out.println("Switched to window");
			}
		}

	}

	public void selectOptionFromList(By locator, String textOfOptionToBeSelectedFromList) {

		List<WebElement> listsize = findMultipleElementSafely(locator);
		for(int i=0;i<listsize.size();i++) {
			if(listsize.get(i).getText().equalsIgnoreCase(textOfOptionToBeSelectedFromList)) {
				WebElement l = listsize.get(i);
				Actions a= new Actions(driver);
				a.moveToElement(l).build().perform();
				a.click().build().perform();
			}
		}
	}

}
