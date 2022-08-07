package demoselenium2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProgressBar_Tc {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\ria\\eclipse\\java-2022-06\\eclipse\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demoqa.com/progress-bar");
		driver.manage().window().maximize();
		WebElement startstop=driver.findElement(By.xpath("//button[@id='startStopButton']"));
		startstop.click();
		WebElement bar=driver.findElement(By.xpath("//div[@role='progressbar']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.pollingEvery(Duration.ofMillis(100));
		wait.until(ExpectedConditions.attributeToBe(bar, "aria-valuenow", "50"));
		startstop.click();
		
		

	}

}
