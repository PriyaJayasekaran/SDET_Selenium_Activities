package SDET_Project_HRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class Verify_Title_Activity1 {
WebDriver driver;
	
	@BeforeMethod
	  public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");
			
	  }
	
	@Test
  public void VerifyTitle() {
        
		String Title = driver.getTitle();
		System.out.println("The Title of the page is:" + Title);
				
		Assert.assertEquals("OrangeHRM", Title);		
		System.out.println("Website title matches");		
  }
  
  @AfterMethod
  public void afterClass() {
	  driver.close();
  }
}
