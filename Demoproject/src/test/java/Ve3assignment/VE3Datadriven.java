package Ve3assignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VE3Datadriven {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		
		FileInputStream file=new FileInputStream("C:\\Users\\duton\\OneDrive\\Desktop\\VE3.xlsx");
		
		Workbook workbook= new XSSFWorkbook(file);
		
		Sheet sheet=workbook.getSheetAt(0);
		
		Row row=sheet.getRow(0);
		
       String search=row.getCell(0).getStringCellValue();
       workbook.close();
       
       
		driver.get("https://www.ve3.global/");
		  driver.manage().window().maximize();
	        
	        
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
	        Thread.sleep(3000);
	        WebElement searchclick=driver.findElement(By.xpath("//i[@class='icon icon-magnifying-glass-search']"));
	        searchclick.click();
	        WebElement searchinput=driver.findElement(By.xpath("//input[@name='s']"));
	        WebElement searchbutton=driver.findElement(By.xpath("//button[@class='hfe-search-submit']"));
	        
	        
	        searchinput.sendKeys(search);
	        searchbutton.click();
	        
	        Thread.sleep(3000);
	        
	        driver.quit();
	        
	        
	        

	}

}
