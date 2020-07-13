package SDET_Project_HRM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
public class Login_Activity3 {
WebDriver driver;
	
	@BeforeMethod
	  public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");
		
		String Title = driver.getTitle();
		
		System.out.println("Title of the page is:" + Title);
		
		Assert.assertEquals("OrangeHRM", Title);			
	  }
	
	@Test
	public void login() {
		
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");				
		driver.findElement(By.id("btnLogin")).click();
		
		WebElement header = driver.findElement(By.xpath("//h1"));
		
		Assert.assertEquals("Dashboard", header.getText());
		
		System.out.println("Login activity for HRM is completed successfully!!");
  }
  

  @AfterMethod
  public void afterClass() {
	  driver.close();
  }
}
