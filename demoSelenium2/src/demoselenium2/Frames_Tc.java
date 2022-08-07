package demoselenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Frames_Tc {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\ria\\eclipse\\java-2022-06\\eclipse\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demoqa.com/frames");
		driver.manage().window().maximize();
		//frame1
		driver.switchTo().frame("frame1");
		WebElement text1= driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		System.out.println(text1.getText());
		driver.switchTo().defaultContent();
		//frame 2
		driver.switchTo().frame("frame2");
		WebElement text2= driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		System.out.println(text2.getText());
		driver.close();

	}

}
