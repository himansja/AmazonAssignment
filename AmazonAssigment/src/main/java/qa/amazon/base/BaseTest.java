package qa.amazon.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	public static WebDriver driver;
	public static String projectPath;
	public static String driverPath;
	public static ConfigFileReader config;


	static {
		/** User Directory Path */
		projectPath = System.getProperty("user.dir");
		System.out.println("Path of the Project "+projectPath);

		/** Driver folder path */
		driverPath = projectPath + "/Drivers";
		System.out.println("Path of the Driver folder "+driverPath);

		/**Creating object of ConfigFile Reader */
		config = new ConfigFileReader(projectPath);
		config.loadPropertiesFile();
		
	}

	//@BeforeMethod
	@BeforeSuite
	public void invokeBrowser() {
		String ChromedriverPath = driverPath + "/chromedriver.exe";
		System.out.println("Path of the chromedriver "+ChromedriverPath);
		System.setProperty("webdriver.chrome.driver", ChromedriverPath);
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get(config.getAppURL());
		driver.manage().window().maximize();
		
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);	

	}

	//@AfterMethod
	@AfterSuite
	public void closeBrower() {
		System.out.println("Programs Ends Here");
		//driver.quit();
	}

}
