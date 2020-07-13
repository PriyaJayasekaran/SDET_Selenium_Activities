package SDET_Project_HRM;

import java.util.List;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Retrieve_Emergency_Contacts_Activity9 {
WebDriver driver;
	
@BeforeClass
public void beforeClass() {
	driver = new FirefoxDriver();
	driver.get("http://alchemy.hguy.co/orangehrm");
	
	String Title = driver.getTitle();
	
	System.out.println("The Title of the page is:" + Title);
	
	Assert.assertEquals("OrangeHRM", Title);
	
	System.out.println("Website title matches");
		
}
	
	@Test
  public void Emergency_Contacts() throws InterruptedException  {
				
		WebDriverWait wait = new WebDriverWait (driver, 20);
		
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
		driver.findElement(By.id("btnLogin")).click();		
			
			Thread.sleep(100);
				
		WebElement MyInfoTab = driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']"));
		wait.until(ExpectedConditions.elementToBeClickable(MyInfoTab));
		MyInfoTab.click();
				
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("Emergency Contacts")).click();
				
		List<WebElement> allRows = driver.findElements(By.xpath("//table[contains(@class,'hover')]/tbody/tr")); 
		
		for (WebElement row : allRows) { 
		    List<WebElement> cells = row.findElements(By.tagName("td")); 

		    
		    for (WebElement cell : cells) {         

		    System.out.println(cell.getText());
		    
		    }
		}
		
  }
  

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
