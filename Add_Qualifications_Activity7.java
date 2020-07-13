package SDET_Project_HRM;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class Add_Qualifications_Activity7 {
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
  public void Add_Qualifications() throws InterruptedException {
						
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");	
		driver.findElement(By.id("btnLogin")).click();		
		
		Thread.sleep(100);
		
		WebElement MyInfoTab = driver.findElement(By.id("menu_pim_viewMyDetails"));
		
		WebDriverWait wait = new WebDriverWait (driver, 30);
		wait.until(ExpectedConditions.visibilityOf(MyInfoTab));
		MyInfoTab.click();
		
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[9]/a")).click();

		driver.findElement(By.xpath("//*[@id=\"addWorkExperience\"]")).click();
		
		WebElement Company = driver.findElement(By.xpath("//*[@id=\"experience_employer\"]"));
		WebElement JobTitle = driver.findElement(By.xpath("//*[@id=\"experience_jobtitle\"]"));
		
		Company.sendKeys("IBM");
		JobTitle.sendKeys("Test Specialist");
		
		driver.findElement(By.xpath("//*[@id=\"btnWorkExpSave\"]")).click();
		
		System.out.println("Adding qualifications completed successfully");
				
  }
  
  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
