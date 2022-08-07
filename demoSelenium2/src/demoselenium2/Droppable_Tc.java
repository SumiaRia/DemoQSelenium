package demoselenium2;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class Droppable_Tc {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\ria\\eclipse\\java-2022-06\\eclipse\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demoqa.com/droppable");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']")).click();
		//accept--blue color
//		WebElement accept =driver.findElement(By.xpath("//div[@id='acceptable']"));
//		WebElement drop =driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
//		Actions act = new Actions(driver);
//		act.dragAndDrop(accept, drop).perform();
		
		//will not accept---no color
		WebElement notaccept =driver.findElement(By.xpath("//div[@id='notAcceptable']"));
		WebElement drop =driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
		Actions act = new Actions(driver);
		act.dragAndDrop(notaccept, drop).perform();
		
		
		WebElement img =driver.findElement(By.xpath("//div[@id='acceptDropContainer']"));//section
		File source =  img.getScreenshotAs(OutputType.FILE);
		//File target =  new File("F:\\demoSelenium2\\src\\screenshots\\accept.png");
		File target =  new File("F:\\demoSelenium2\\src\\screenshots\\notaccept.png");
		FileHandler.copy(source, target);
		driver.quit();
			
		

	}

}
