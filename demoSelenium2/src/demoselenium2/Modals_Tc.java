package demoselenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Modals_Tc {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\ria\\eclipse\\java-2022-06\\eclipse\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demoqa.com/modal-dialogs");
		driver.manage().window().maximize();
		
//		small button
		driver.findElement(By.xpath("//button[@id='showSmallModal']")).click();
		WebElement modal1= driver.findElement(By.xpath("//div[@class='modal-content']//div[@class='modal-body']"));
		System.out.println("Modal: "+modal1.getText());
		driver.findElement(By.xpath("//div[@class='modal-content']//button[@id='closeSmallModal']")).click();
		Thread.sleep(2000);
		
		//large button
		driver.findElement(By.xpath("//button[@id='showLargeModal']")).click();
		WebElement modal2= driver.findElement(By.xpath("//div[@class='modal-content']//div[@class='modal-body']//p[contains(text(),\"Lorem Ipsum is simply dummy text of the printing a\")]"));
		System.out.println("Modal: "+modal2.getText());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='modal-content']//button[@id='closeLargeModal']")).click();
		
	}

}
