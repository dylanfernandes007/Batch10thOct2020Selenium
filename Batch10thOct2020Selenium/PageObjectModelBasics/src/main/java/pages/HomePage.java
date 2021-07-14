package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Page;

public class HomePage extends Page {

	
	
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id="email")
	public WebElement email;
	
	@FindBy(id="pass")
	public WebElement pass;
	
	@FindBy(id="u_0_b")
	public WebElement loginBtn;
	
	
	

	public LandingPage doLogin(String username, String password) {

		email.sendKeys(username);
		pass.sendKeys(password);
		loginBtn.click();
		return new LandingPage(driver);

	}

	public void createAccount() {

		//driver.findElement(By.id("u_0_2")).click();
	}

	public void forgotPassword() {

		//driver.findElement(By.xpath("//*[@id=\"u_0_a\"]/div[3]/a")).click();

	}

	public void validateLinks() {

	}
}
