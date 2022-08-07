package demoselenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Menu_Tc {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\ria\\eclipse\\java-2022-06\\eclipse\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demoqa.com/menu");
		driver.manage().window().maximize();
		WebElement menu2=driver.findElement(By.xpath("//a[normalize-space()='Main Item 2']"));
		WebElement menu1 =driver.findElement(By.xpath("//a[normalize-space()='Sub Item']"));
		Actions act = new Actions(driver);
//		act.moveToElement(menu2).moveToElement(menu1).sendKeys(Keys.ARROW_RIGHT).perform();		
		act.moveToElement(menu2).moveToElement(menu1).perform();
		
		  System.out.println(menu1.getText());
;
	}

}
