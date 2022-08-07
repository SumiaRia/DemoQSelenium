package demoselenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioButton_Tc {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\ria\\eclipse\\java-2022-06\\eclipse\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demoqa.com/elements");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[normalize-space()='Radio Button']")).click();
		Thread.sleep(3000);
		WebElement radio =driver.findElement(By.xpath("//div[@class='custom-control custom-radio custom-control-inline']//input[@id='impressiveRadio' and contains(@type,'radio')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", radio);
		
		driver.close();
	}

}
