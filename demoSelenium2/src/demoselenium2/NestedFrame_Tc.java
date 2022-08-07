package demoselenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NestedFrame_Tc {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\ria\\eclipse\\java-2022-06\\eclipse\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demoqa.com/nestedframes");
		driver.manage().window().maximize();
		//parent frame
		driver.switchTo().frame("frame1");
		//WebElement childframe = driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
		driver.switchTo().frame(0);
		WebElement text = driver.findElement(By.xpath("//p[normalize-space()='Child Iframe']"));
		System.out.println("child: "+text.getText());
		driver.close();
		

	}

}
