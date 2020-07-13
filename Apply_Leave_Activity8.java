package SDET_Project_HRM;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class Apply_Leave_Activity8 {
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
  public void Apply_Leave() throws InterruptedException {
						
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");	
		driver.findElement(By.id("btnLogin")).click();		
		
							
		
		{

			  driver.findElement(By.xpath("//*[@id=\"menu_leave_viewLeaveModule\"]")).click();
			  			  
			  driver.findElement(By.xpath("//*[@id=\"menu_leave_applyLeave\"]")).click();
			  			  
			  driver.findElement(By.xpath("//*[@id=\"applyleave_txtLeaveType\"]")).click();

			  Actions leave = new Actions(driver);
			  leave.sendKeys(Keys.chord(Keys.DOWN)).perform();

			  leave.click();
			  
			  Thread.sleep(100);
		  
			  driver.findElement(By.xpath("//*[@id=\"applyleave_txtFromDate\"]")).clear();

			  driver.findElement(By.xpath("//*[@id=\"applyleave_txtFromDate\"]")).sendKeys("2020-06-01");
			  
			  driver.findElement(By.xpath("//*[@id=\"applyleave_txtToDate\"]")).clear();

			  driver.findElement(By.xpath("//*[@id=\"applyleave_txtToDate\"]")).sendKeys("2020-06-10");

			  
			  Actions days = new Actions(driver);

		      days.sendKeys(Keys.chord(Keys.DOWN)).perform();

			  days.click();

			  driver.findElement(By.xpath("//*[@id=\"applyBtn\"]")).click();			  

			  driver.findElement(By.xpath("//*[@id=\"menu_leave_viewMyLeaveList\"]")).click();
			  

			  driver.findElement(By.xpath("//*[@id=\"calFromDate\"]")).clear();

			  driver.findElement(By.xpath("//*[@id=\"calFromDate\"]")).sendKeys("2020-06-01");

			  
			  driver.findElement(By.xpath("//*[@id=\"calToDate\"]")).clear();

			  driver.findElement(By.xpath("//*[@id=\"calToDate\"]")).sendKeys("2020-06-10");  

			  driver.findElement(By.id("btnSearch")).click();
		}
		  		

	}
		
  @AfterClass
  public void afterClass() {
	  driver.close();
  }
}
