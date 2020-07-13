package SDET_Project_HRM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Dir_Menu_Activity6 {
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
	public void login() {
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");		
		driver.findElement(By.id("btnLogin")).click();	
			
	}
		@Test
		public void Dir_Menu() {
			
			WebDriverWait wait = new WebDriverWait(driver , 10);
								
			WebElement menu = driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul"));
			WebElement directory = menu.findElement(By.partialLinkText("Directory"));
			
			if(directory.isDisplayed()) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menu_directory_viewDirectory\"]")));
				directory.click();
				
				wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div[3]/div[1]/div[1]/h1"), "Search Directory"));
				WebElement text = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[1]/h1"));
				
				Assert.assertEquals(text.getText(), "Search Directory");
		
		}
		}
		

		@AfterClass
		public void afterClass() {
			driver.close();
	}
}
