package SDET_Project_HRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class URL_Activity2 {
WebDriver driver;
	
	@BeforeMethod
	  public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);	
	  }
	
	@Test
  public void URL() {
        String Title = driver.getTitle();
		
		System.out.println("The Title of the page is:" + Title);
		
		Assert.assertEquals("OrangeHRM", Title);
		
		System.out.println("Website title matches");		
		
		String headerURL = driver.findElement(By.xpath("//img[contains(@src,'/orangehrm/symfony/web/webres_5d69118beeec64.10301452/themes/default/images/login/logo.png')]")).getAttribute("src");
				
		System.out.println("URL of the header is:" +headerURL);
		
		System.out.println("URL activity completed successfully!!");
		
  }
  
  @AfterMethod
  public void afterClass() {
	  driver.close();
  }
}
