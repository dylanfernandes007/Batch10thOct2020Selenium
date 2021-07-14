package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Page {
	
	/*
	 * HomePage ISA Page
	 * LandingPage ISA Page
	 * MyProfilePage ISA Page
	 * 
	 */
	
	
	
	public WebDriver driver;
	
	
	public Page(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
