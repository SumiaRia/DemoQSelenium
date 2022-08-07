package demoselenium2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
/*
 * 1.how many rows in the table
 * 2.how many coloums in the table
	3.Retrieve the specifice row and column data
	4.Retrieve all the data from the table
	5.print release Version no of java language of selenium
	6.*/
public class WebTable_Tc1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\ria\\eclipse\\java-2022-06\\eclipse\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demoqa.com/elements");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement webtable =driver.findElement(By.xpath("//span[normalize-space()='Web Tables']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",webtable);
		Thread.sleep(3000);
		//driver.findElements(By.xpath("//div[@role='grid']//div[@class='rt-tbody']//div[@role='rowgroup']"))
		//column
		List<WebElement> column=driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']")); 
		System.out.println("there are "+column.size() +" columns");
		//specific data
		WebElement data =driver.findElement(By.xpath("//div[@role='rowgroup']//div[normalize-space()='Alden']"));
		System.out.println("Specific data: "+data.getText());
//		search
		WebElement search =driver.findElement(By.cssSelector("#searchBox"));
		search.sendKeys("Alden");
		search.sendKeys(Keys.ENTER);
		
		
		
		
	}

}
