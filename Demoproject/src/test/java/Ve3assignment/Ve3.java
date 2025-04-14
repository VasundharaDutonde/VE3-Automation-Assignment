package Ve3assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Ve3 {
	WebDriver driver=new ChromeDriver();
  @BeforeClass
  public void verifyHomepage() throws InterruptedException {
	  driver.navigate().to("https://www.ve3.global/");
	  driver.manage().window().maximize();
	  
	  Thread.sleep(3000);
  }  
 @Test(priority=0)
	  
	public void clickCookies()
	{
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		try
		{
		WebElement allowall=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Allow All']")));
			allowall.click();
			System.out.println("clicked on 'AllowAll' ");
	}catch(Exception e)
		{
		 System.out.println("could not click 'AllowAll': " +e.getMessage());
		}
	}

@Test(priority=1)  
	  
		public void clickSearch()
		{
			driver.findElement(By.xpath("//i[@class='icon icon-magnifying-glass-search']")).click();
			
		WebElement search=	driver.findElement(By.xpath("//input[@placeholder='Type & Hit Enter...']"));
			search.sendKeys("Testinga and QA");
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		WebElement searchclick=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='fas fa-search']")));
		searchclick.click();
		
		WebElement articleclick=driver.findElement(By.xpath("(//a[@class='title-animation-underline' and contains(text(),'Small Vision-Language Models')])[1]"));
		articleclick.click();
			
		}
@Test(priority=2,dataProvider="test1")
		
		public void formFillUP(String username,String email,String desc)
		{
			
			driver.findElement(By.xpath("//a[@class='elementor-button elementor-button-link elementor-size-lg elementor-animation-wobble-vertical']")).click();
			
			WebElement usernamefield=driver.findElement(By.xpath("//input[@id='00NSq000003CM1R']"));
			
		WebElement emailfield=driver.findElement(By.xpath("//input[@id='email']"));
			
		WebElement discriptionfield=driver.findElement(By.xpath("//textarea[@name='description']"));
		
		usernamefield.sendKeys("username");
		emailfield.sendKeys("email");
		discriptionfield.sendKeys("desc");
		
		driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
			
		driver.findElement(By.xpath("//input[@type='submit']")).click();
			
			JavascriptExecutor js=(JavascriptExecutor)driver;
			boolean isUsernamevalid=(Boolean) js.executeScript("return arguments[0].checkValidity();",usernamefield);
			boolean isEmailvalid=(Boolean) js.executeScript("return arguments[0].checkValidity();",emailfield);
			
			String usernamemsg= (String) js.executeScript("return arguments[0].validationmsg;",usernamefield);
			String emailmsg= (String) js.executeScript("return arguments[0].validationmsg;",emailfield);
			
			if(username.isEmpty()) {
				Assert.assertFalse(isUsernamevalid,"Username should be invalid");
				System.out.println("username error:" +usernamemsg);
			}
			if(email.isEmpty())
			{
				Assert.assertFalse(isEmailvalid,"Email should be invalid");
				System.out.println("email error:" +emailmsg);
			}
		}
		
 @AfterClass
	 public void closeApp()
	 {
		 driver.close();
	 }
	@DataProvider(name="test1")
	public static Object[][] contactForm()
	{
			return new Object[][] {{"Ajinkya tayade","aj12@gmail.com","VE3 is a tech platform sharing insights on AI, data science, and digital innovation"},{"Renuka Mahure","rm1203@gmail.com",""},{"","abtechno@gmail.com","VE3 is a tech platform sharing insights on AI, data science, and digital innovation."},
				                   {"","","VE3 is a tech platform sharing insights on AI, data science, and digital innovation"}};
			}
	}
	  
  

