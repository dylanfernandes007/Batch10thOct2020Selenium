package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class NewCarsPage extends BasePage {

	public NewCarsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(linkText="Maruti Suzuki")
	public WebElement maruti;
	
	@FindBy(linkText="Hyundai")
	public WebElement hyundai;
	
	@FindBy(linkText="Toyota")
	public WebElement toyota;
	
	@FindBy(linkText="Kia")
	public WebElement kia;
	
	
	
	public MarutiCarPage selectMarutiCar() {
		
		maruti.click();
		
		return new MarutiCarPage(driver);
	}
	
	
	
	public void selectHyundaiCar() {
		
		hyundai.click();
		
	}
	
	
	public ToyotaCarPage selectToyotaCar() {
		
		toyota.click();
		
		return new ToyotaCarPage(driver);
		
		
	}
	
	
	
	public void selectKiaCar() {
		
		kia.click();
		
	}

}
