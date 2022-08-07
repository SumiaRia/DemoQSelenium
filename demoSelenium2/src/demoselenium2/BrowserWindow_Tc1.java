package demoselenium2;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserWindow_Tc1 {

	public static void main(String[] args) throws InterruptedException {
		/*test case 1
		 * 1.open the  browser
		 * 2.navigate to the url
		 * 3.maximize the window
		 * 4.print the parent window handle
		 * click on all tab
		 * 5.click on 'new window; 3 times
		 * 6.print window handles
		 * 7.quit the browser
		 * */
		System.setProperty("webdriver.gecko.driver","C:\\Users\\ria\\eclipse\\java-2022-06\\eclipse\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		String parentwindow = driver.getWindowHandle();//4
		System.out.println("the parent window is: "+parentwindow);
		WebElement tab = driver.findElement(By.xpath("//button[@id='tabButton']"));
		tab.click();
		driver.findElement(By.xpath("//button[@id='windowButton']")).click();
		driver.findElement(By.xpath("//button[@id='messageWindowButton']")).click();
		Set<String> childwindow = driver.getWindowHandles();
		String lastwindow ="";
		for(String child: childwindow) {
			System.out.println("the child window is: "+child);
			driver.switchTo().window(child);
		}
		driver.switchTo().window(parentwindow);
		driver.close();
//		Thread.sleep(3000);
//		driver.switchTo().window(lastwindow);
//		driver.manage().window().maximize();
		
		
	}

}
