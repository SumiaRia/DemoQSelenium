package demoselenium2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TextBox_Tc {

	public static void main(String[] args) throws InterruptedException {
		/*test case
		1.Launch new browser
	    2.Open URL https://itera-qa.azurewebsites.net/home/automation
	    3.click Element & text box 
	    4.fill the field with valid credential
	    5.click submit button
	    5.Close browser*/
		System.setProperty("webdriver.gecko.driver","C:\\Users\\ria\\eclipse\\java-2022-06\\eclipse\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//div[@class='category-cards']//div[1]//div[1]//div[2]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']//span")).click();
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("md");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("md@gmail.com");
		driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("asdgff");
		driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys("asdgff");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		Thread.sleep(5000);
		WebElement output = driver.findElement(By.xpath("//div[@id='output']"));
		System.out.println(output.getText());
		driver.close();
		
		

	}

}
