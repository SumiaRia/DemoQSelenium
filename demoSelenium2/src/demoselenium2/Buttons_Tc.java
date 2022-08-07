package demoselenium2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

/*test case
	1 Launch new browser
	2 Open URL https://itera-qa.azurewebsites.net/home/automation
	3click on buttons
	4click double click me,right click me,click me


Close browser
*/
public class Buttons_Tc {
	

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\ria\\eclipse\\java-2022-06\\eclipse\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demoqa.com/elements");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement buttons =driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-4']//span[normalize-space()='Buttons']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", buttons);
		Thread.sleep(3000);
		Actions act =  new Actions(driver);
		//double click
		WebElement dobleclick = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
	    act.doubleClick(dobleclick).perform();
	    //right click
		WebElement rightclick = driver.findElement(By.xpath("//button[@id='rightClickBtn']"));
		act.contextClick(rightclick).perform();
		//click me
		WebElement clickme = driver.findElement(By.xpath("//button[normalize-space()='Click Me']"));
		act.click(clickme).perform();
		Thread.sleep(3000);
		List<WebElement> text = driver.findElements(By.xpath("//body/div[@id='app']/div[@class='body-height']/div[@class='container playgound-body']/div[@class='row']/div[@class='col-12 mt-4 col-md-6']/div[2]//p"));
		for(WebElement t: text) {
			System.out.println(t.getText());
		}
	}

}
