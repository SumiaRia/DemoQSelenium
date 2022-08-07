package demoselenium2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
/*test case
1 Launch new browser
2 Open URL https://itera-qa.azurewebsites.net/home/automation
3click on links
click home 
close home tab
click all link below "Following links will send an api call"
print all the link current status


Close browser
*/
public class Links_Tc {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\ria\\eclipse\\java-2022-06\\eclipse\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demoqa.com/elements");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement buttons =driver.findElement(By.xpath("//span[normalize-space()='Links']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", buttons);
		Thread.sleep(3000);
		//link open in new tab
//		driver.findElement(By.xpath("//a[@id='dynamicLink']")).click();
		
		List<WebElement> links = driver.findElements(By.xpath("//div[@id='linkWrapper']//h5[2]/following::p/child::a"));
		for(WebElement li: links) {
			js.executeScript("arguments[0].click();", li);
//			System.out.println("you click: "+li.getText());
			WebElement text = driver.findElement(By.xpath("//p[@id='linkResponse']"));
			System.out.println("status : "+li.getText()+" "+text.getText());
		}
		

	}

}
