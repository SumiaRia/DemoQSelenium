package demoselenium2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/*test case
1 Launch new browser
2 Open URL https://itera-qa.azurewebsites.net/home/automation
3click on webtable button
4click add
5.edit
6.delete table row*/
public class WebTable_Tc2 {

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
		driver.findElement(By.xpath("//button[@id='addNewRecordButton']")).click();
		Thread.sleep(2000);
//		add
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("md");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("rat");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("rat@gmail.com");
		driver.findElement(By.xpath("//input[@id='age']")).sendKeys("40");
		driver.findElement(By.xpath("//input[@id='salary']")).sendKeys("20000");
		driver.findElement(By.xpath("//input[@id='department']")).sendKeys("HR");
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		Thread.sleep(3000);
//		edit
		driver.findElement(By.xpath("//div[@class='action-buttons']//span[@id='edit-record-4']")).click();
		Thread.sleep(3000);
		WebElement edit=driver.findElement(By.xpath("//input[@id='salary']"));
		edit.clear();
		edit.sendKeys("40000");
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		Thread.sleep(3000);
		//delete
		driver.findElement(By.xpath("//div[@class='action-buttons']//span[@id='delete-record-4']")).click();

	}

}
