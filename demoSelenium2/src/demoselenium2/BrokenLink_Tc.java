package demoselenium2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
/**/

public class BrokenLink_Tc {

	public static void main(String[] args) throws InterruptedException, IOException{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\ria\\eclipse\\java-2022-06\\eclipse\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demoqa.com/elements");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement button =driver.findElement(By.xpath("//span[normalize-space()='Broken Links - Images']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",button);
		Thread.sleep(3000);
		List<WebElement>links=driver.findElements(By.tagName("a"));
		int brokenlink = 0;
		for(WebElement element:links) {
			String url = element.getAttribute("href");
			if(url==null ||url.isEmpty()) {
				System.out.println("the url is Empty");
				continue;
			}
			URL urlLink = new URL(url);
			try {
				HttpURLConnection httpcon = (HttpURLConnection) urlLink.openConnection();
				httpcon.connect();
				if(httpcon.getResponseCode()>=400) {
					System.out.println(httpcon.getResponseCode() +url+" is"+" broken link");
					brokenlink++; //how many link is broken will be showed
				}
				else {
					System.out.println(httpcon.getResponseCode() +url+" is"+" valid link");
				}
			} catch (Exception e) {
				
			}
		}
		
		System.out.println("Number of broken link:"+brokenlink);
		driver.quit();

	}

}
