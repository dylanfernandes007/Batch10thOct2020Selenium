package testnglearning;

import java.util.Date;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParameters {
	
	@Parameters({"browser","url"})
	@Test
	public void doLogin(String browser, String url) {
		
		Date d = new Date();
		System.out.println(d.toString());
		
		System.out.println(browser+"----"+url);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
