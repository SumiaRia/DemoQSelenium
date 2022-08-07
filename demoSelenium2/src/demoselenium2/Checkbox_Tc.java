package demoselenium2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Checkbox_Tc {

	public static void main(String[] args) throws InterruptedException {
		/*test case
	 	1 Launch new browser
	    2 Open URL https://itera-qa.azurewebsites.net/home/automation
	    3click on checkbox button
	    4click expand all button
	    5select all the checkbox
	    6uncheck all the checkbox
	    7Check the Check Box ‘React’ and private for category Document
	    
	    Close browser
	*/
		System.setProperty("webdriver.gecko.driver","C:\\Users\\ria\\eclipse\\java-2022-06\\eclipse\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demoqa.com/elements");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-1']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='rct-options']//button[@class='rct-option rct-option-expand-all']")).click();
		driver.findElement(By.xpath("//label[@for='tree-node-home']//span[@class='rct-checkbox']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[@for='tree-node-home']//span[@class='rct-checkbox']")).click();
		Thread.sleep(2000);
		List<WebElement> checkbox = driver.findElements(By.xpath("//li[@class='rct-node rct-node-parent rct-node-expanded']//span[@class='rct-title']"));
		for(WebElement ck: checkbox) {
			String check= ck.getText();
			if(check.equalsIgnoreCase("Commands")||check.equals("React"))
				ck.click();
		}
		
	}

}
