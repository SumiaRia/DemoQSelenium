package demoselenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
/*test case
1. Go to the website https://demoqa.com/slider/;
2. Move the slider by dragging a mouse to the release point;*/

public class Slider_Tc {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\ria\\eclipse\\java-2022-06\\eclipse\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demoqa.com/slider");
		driver.manage().window().maximize();
		WebElement minimum=driver.findElement(By.xpath("//input[@type='range']"));
		System.out.println("location form minimum: "+minimum.getLocation());
		Actions act = new Actions(driver);
		act.dragAndDropBy(minimum, 200, 0).perform();
		WebElement show = driver.findElement(By.xpath("//input[@id='sliderValue']"));
		System.out.println(show.getAttribute("value"));
	}

}
