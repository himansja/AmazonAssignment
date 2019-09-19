package linear.framework.amazon.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {
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
		driver.findElement(By.xpath("//a[@data-nav-role='signin']//span[@class='nav-line-1']")).click();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("himanshu080290@gmail.com");
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Himanshu@0802");
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		System.out.println(driver.getTitle());
		driver.navigate().to("https://www.amazon.in/s?k=iphone+case+6s&page=2&qid=1559633553&ref=sr_pg_2");
		driver.findElement(By.xpath("//li[@class='a-selected']//following-sibling::li[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[@class='a-selected']//following-sibling::li[1]")).click();
		
		System.err.println("end of program");

	}
}