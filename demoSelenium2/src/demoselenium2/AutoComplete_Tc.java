package demoselenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutoComplete_Tc {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\ria\\eclipse\\java-2022-06\\eclipse\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demoqa.com/auto-complete");
		driver.manage().window().maximize();
		//multi color
		WebElement multiple=driver.findElement(By.cssSelector("#autoCompleteMultipleInput"));
		multiple.sendKeys("Red");
		multiple.sendKeys(Keys.ARROW_DOWN);
		multiple.sendKeys(Keys.ENTER);
		multiple.sendKeys("green");
		multiple.sendKeys(Keys.ARROW_DOWN);
		multiple.sendKeys(Keys.ENTER);
		multiple.sendKeys(Keys.TAB);
		
		//single color
		WebElement single=driver.findElement(By.cssSelector("#autoCompleteSingleInput"));
		single.sendKeys("Red");
		single.sendKeys(Keys.ARROW_DOWN);
		single.sendKeys(Keys.ENTER);
		
		

	}

}
