package SDET_Project_HRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
public class Add_Employee_Activity4 {
WebDriver driver;
	
	@Test
  public void Add_Employee() {
		
		driver = new FirefoxDriver();		
		driver.get("http://alchemy.hguy.co/orangehrm");
		
		String Title = driver.getTitle();		
		System.out.println("The Title of the page is:" + Title);
		
		Assert.assertEquals("OrangeHRM", Title);
		
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");				
		driver.findElement(By.id("btnLogin")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							
		driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"menu_pim_addEmployee\"]")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		

		WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']")); 
		WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']")); 
		
		firstName.sendKeys("Priya");
		lastName.sendKeys("J");
		
		driver.findElement(By.xpath("//input[@id='chkLogin']")).click();
		
		WebElement UserName = driver.findElement(By.xpath("//input[@id='user_name']"));
		
		UserName.sendKeys("Priya J");
						
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']")).click();
		
		System.out.println("Navigate to Admin Page");	
		
		WebElement SearchEmpName = driver.findElement(By.xpath("//input[@id='searchSystemUser_employeeName_empName']"));
		
		SearchEmpName.sendKeys("Priya J");
		
		System.out.println("Verification for employee creation completed successfully");
				
		driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
		
		WebElement verify = driver.findElement(By.linkText("Priya J"));
		Assert.assertEquals(verify.getText(), "Priya J");
		
		System.out.println("Add Employee completed successfully");
	}
		
	@AfterClass
	  public void afterClass() {
		  driver.close();
	  }		
  }

