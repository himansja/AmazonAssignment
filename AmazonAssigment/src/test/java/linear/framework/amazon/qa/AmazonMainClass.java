package linear.framework.amazon.qa;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonMainClass {

	public static WebDriver driver;
	public static void main(String[] args) throws Throwable {

		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		String driverPath = projectPath + "/Drivers/chromedriver.exe";
		System.out.println(driverPath);
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);	

		/*driver.findElement(By.xpath("//a[@data-nav-role='signin']//span[@class='nav-line-1']")).click();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("himanshu080290@gmail.com");
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Himanshu@0802");
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		System.out.println(driver.getTitle());*/
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone case");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='Go']")).click();
		Thread.sleep(2000);

		WebElement nexButton = driver.findElement(By.xpath("//span//ul[@class='a-pagination']//li[@class='a-last'] ")); //Next button
		//WebElement next = driver.findElement(By.xpath("//li[@class='a-disabled']//following-sibling::li")); // pagination button next to current selected button
		/*		String countText = driver.findElement(By.xpath("//li//following-sibling::li[@class='a-disabled']")).getText();
		System.out.println("Total pagination count" +countText);
		int paginationLimit = Integer.parseInt(countText);


		try {
			boolean flag = true;
			for(int j=0;j<paginationLimit;j++) {
				List<WebElement> searchList = driver.findElements(By.xpath("//span[@data-component-type='s-search-results']/div/div/descendant::span[contains(@class,'a-text-normal')]"));
				//System.out.println(searchList.size());
				for(int i=0;i<searchList.size();i++) {	
				//	System.out.println("S.No" +i + " = "+searchList.get(i).getText());

					if(searchList.get(i).getText().equalsIgnoreCase("RPM Euro Games PUBG Trigger R11 Mobile Gaming Controller Button triggers for Phone (Metal)")) {
						searchList.get(i).click();
						flag = false;
						break;
					}	

				}
				if(flag==false) {
					break;
				}
				//Thread.sleep(2000);
				//driver.findElement(By.xpath("//li[@class='a-selected']//following-sibling::li[1]")).click();
				//WebElement f = driver.findElement(By.xpath("//span//ul[@class='a-pagination']//li[@class='a-last'] "));
				//JavascriptExecutor js = (JavascriptExecutor)driver;
				//js.executeScript("arguments[0].scrollIntoView(true);",f);
				//driver.findElement(By.xpath("//span//ul[@class='a-pagination']//li[@class='a-last'] ")).click();
				//WebElement fin = driver.findElement(By.xpath("//ul[@class='a-pagination']//child::li[@class='a-last']/a"));
				WebElement we = driver.findElement(By.xpath("//ul[@class='a-pagination']//child::li[@class='a-last']/a"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", we);
				//driver.findElement(By.xpath("//ul[@class='a-pagination']//child::li[@class='a-last']/a")).click();

				Thread.sleep(5000);

			}
		} 
		catch (StaleElementReferenceException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
			//System.out.println("Product not found");
		}



		 *//**switching to product window *//*

		Set<String> setWindowsID = driver.getWindowHandles();
		List<String> windowID = new ArrayList<String>(setWindowsID);
		for(int k=0;k<windowID.size();k++) {
			System.out.println(windowID);
			if(windowID.get(k).equalsIgnoreCase("3A4FA057249E54BB22919C07DA61AFBA")) {
				driver.switchTo().window(windowID.get(k));
				System.out.println("Switching to window");
				driver.findElement(By.id("add-to-cart-button")).click();
				driver.findElement(By.xpath("//a[@id='hlb-ptc-btn-native']")).click();
				Thread.sleep(2000);

		  *//**Selecting Address *//*
				driver.findElement(By.xpath("//div[@class='a-spacing-base address-book']//child::div[@id='address-book-entry-0']//descendant::span[@class='a-button-inner'][1]//a[contains(text(),'Deliver to this address')]")).click();

		   *//** Clicking on continue button *//*
				driver.findElement(By.xpath("//div[@class='a-row a-spacing-medium']//child::input[@data-testid]")).click(); 
				System.out.println(driver.getTitle());
				System.out.println("Program ends here on Payment Page");		
				driver.quit();

			}
		}

	}
}*/


		try {
			boolean flag = false;
			do {

				List<WebElement> searchList = driver.findElements(By.xpath("//span[@data-component-type='s-search-results']/div/div/descendant::span[contains(@class,'a-text-normal')]"));
				System.out.println(searchList.size());
				for(int i=0;i<searchList.size();i++) {	
					System.out.println("S.No" +i + " = "+searchList.get(i).getText());

					if(searchList.get(i).getText().equalsIgnoreCase("Casedodo Leather Back Case Cover for Apple iPhone 7 - Sleeve - Shell White")) {
						WebElement l = searchList.get(i);
						Actions a= new Actions(driver);
						a.moveToElement(l).build().perform();
						a.click().build().perform();
						flag= true;
						break;
					}		

				}

				if(flag) {
					break;
				}
				else {
					
					WebElement el = driver.findElement(By.xpath("//span//ul[@class='a-pagination']//li[@class='a-last'] "));
					Actions a = new Actions(driver);
					a.moveToElement(el).build().perform();
					a.click().build().perform();
					//driver.findElement(By.xpath("//span//ul[@class='a-pagination']//li[@class='a-last'] ")).click();
					Thread.sleep(5000);
				}
			} while(driver.findElement(By.xpath("//span//ul[@class='a-pagination']//li[contains(@class,'a-last')] ")).isEnabled());



		} catch (StaleElementReferenceException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
			//System.out.println("Product not found");

		}






	}
}


