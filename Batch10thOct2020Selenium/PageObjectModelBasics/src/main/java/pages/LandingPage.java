package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.Page;

public class LandingPage extends Page {



	public LandingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//*[@id=\"mount_0_0\"]/div/div[1]/div[1]/div[3]/div/div/div[1]/div[1]/div/div[1]/div/div/div[1]/div/div/div[1]/ul/li/div/a/div[1]/div[2]/div/div/div/div/span/span")
	public WebElement myProfile;

	public MyProfilePage gotoProfile() {

		myProfile.click();

		return new MyProfilePage(driver);
	}

	public void updateStatus() {

	}

	public void gotoGroups() {

	}

	public void gotoFriends() {

	}

}
