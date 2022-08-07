package demoselenium2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Alert_Tc {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\ria\\eclipse\\java-2022-06\\eclipse\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Click Button to see alert
		driver.findElement(By.xpath("//button[@id='alertButton']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
//		On button click, alert will appear after 5 seconds
		driver.findElement(By.xpath("//button[@id='timerAlertButton']")).click();
		Thread.sleep(6000);
		driver.switchTo().alert().accept();
		
//		On button click, prompt box will appear
		driver.findElement(By.xpath("//button[@id='promtButton']")).click();
		Alert prompt = driver.switchTo().alert();
		prompt.sendKeys("welcome");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		WebElement text=driver.findElement(By.cssSelector("#promptResult"));
		System.out.println(text.getText());
		}

}
