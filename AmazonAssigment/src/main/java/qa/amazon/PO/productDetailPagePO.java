package qa.amazon.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import qa.amazon.base.BaseTestPageObject;

public class productDetailPagePO extends BaseTestPageObject{
	WebDriver driver;



	public productDetailPagePO(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}


	By selectSizeList =By.xpath("//div[@id='variation_size_name']//li//descendant::div[@class='twisterTextDiv text']/span");




	public void clickOnHardDiskSize(String optionTobeSelected) {
		selectOptionFromList(selectSizeList, optionTobeSelected);
	}





}


