package SDET_Project_HRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Edit_User_Activity5 {
WebDriver driver;
	
	@BeforeClass
	  public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");
		
		String Title = driver.getTitle();
		
		System.out.println("The Title of the page is:" + Title);
		
		Assert.assertEquals("OrangeHRM", Title);
					
	  }
	
	@Test
  public void Edit_User_Activity() throws InterruptedException {
				
		WebDriverWait wait = new WebDriverWait (driver, 30);		
		
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");		
		driver.findElement(By.id("btnLogin")).click();		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(100);
			
		WebElement MyInfoTab = driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']"));
		wait.until(ExpectedConditions.elementToBeClickable(MyInfoTab));
		MyInfoTab.click();
				
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement EditButton = driver.findElement(By.xpath("//input[@id='btnSave']"));
		wait.until(ExpectedConditions.elementToBeClickable(EditButton));
		EditButton.click();		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		
		driver.findElement(By.xpath("//input[@id='personal_txtEmpFirstName']")).clear();
		driver.findElement(By.xpath("//input[@id='personal_txtEmpFirstName']")).sendKeys("Priya");
				
		driver.findElement(By.xpath("//input[@id='personal_txtEmpLastName']")).clear();
		driver.findElement(By.xpath("//input[@id='personal_txtEmpLastName']")).sendKeys("J");
				
		driver.findElement(By.xpath("//input[@id='personal_optGender_2']")).click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		driver.findElement(By.xpath("//*[@id=\"personal_cmbNation\"]")).sendKeys("Indian");

		driver.findElement(By.xpath("//*[@id=\"personal_DOB\"]")).clear();

		driver.findElement(By.xpath("//*[@id=\"personal_DOB\"]")).sendKeys("2020-01-01");
				
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		
  }
  
  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
