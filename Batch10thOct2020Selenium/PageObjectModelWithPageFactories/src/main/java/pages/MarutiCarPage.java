package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class MarutiCarPage extends BasePage {

	public MarutiCarPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//*[@id=\"root\"]/div[3]/div[2]/div/h1")
	public WebElement carTitle;
	
	public String getCarTitle() {
		
		return carTitle.getText();
	}
}
