package demoselenium2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tooltips_Tc {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\ria\\eclipse\\java-2022-06\\eclipse\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demoqa.com/tool-tips");
		driver.manage().window().maximize();
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement button=driver.findElement(By.xpath("//button[@id='toolTipButton']"));
		act.moveToElement(button).perform();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='buttonToolTip']//div[@class='tooltip-inner']")));
		String text1= driver.findElement(By.xpath("//div[@id='buttonToolTip']//div[@class='tooltip-inner']")).getText(); //buttonToolTip //f8 debugger
		System.out.println(text1);
//		Thread.sleep(2000);
		
		WebElement input=driver.findElement(By.xpath("//input[@id='toolTipTextField']"));
		act.moveToElement(input).perform();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='textFieldToolTip']//div[@class='tooltip-inner']")));
		String text2= driver.findElement(By.xpath("//div[@id='textFieldToolTip']//div[@class='tooltip-inner']")).getText();
		System.out.println(text2);
  	    Thread.sleep(1000);
		
		WebElement anchor=driver.findElement(By.xpath("//a[normalize-space()='Contrary']"));
		act.moveToElement(anchor).perform();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='contraryTexToolTip']//div[@class='tooltip-inner']")));
		String text3= driver.findElement(By.xpath("//div[@id='contraryTexToolTip']//div[@class='tooltip-inner']")).getText();
		System.out.println(text3);
//		Thread.sleep(2000);
		
		WebElement section=driver.findElement(By.xpath("//a[normalize-space()='1.10.32']"));
		act.moveToElement(section).perform();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='sectionToolTip']//div[@class='tooltip-inner']")));
		String text4= driver.findElement(By.xpath("//div[@id='sectionToolTip']//div[@class='tooltip-inner']")).getText();
		System.out.println(text4);

	}

}
