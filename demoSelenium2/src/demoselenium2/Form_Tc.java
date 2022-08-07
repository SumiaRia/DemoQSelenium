package demoselenium2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Form_Tc {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\ria\\eclipse\\java-2022-06\\eclipse\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demoqa.com/forms");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement webtable =driver.findElement(By.xpath("//span[normalize-space()='Practice Form']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",webtable);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("md");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("rat");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("md@gmail.com");
		WebElement radio =driver.findElement(By.xpath("//div[@class='custom-control custom-radio custom-control-inline']//input[@id='gender-radio-1']"));
		js.executeScript("arguments[0].click();",radio);
		driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys("012345678");
		
		//date picker
		WebElement bod = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
		bod.click();
		Select month = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']")));
		month.selectByVisibleText("August");
		Select year = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']")));
		year.selectByVisibleText("2004");
//		Thread.sleep(3000);
//		List<WebElement> date=driver.findElements(By.xpath("//div[@role='listbox']//div[@class='react-datepicker__week']/child::div[@role='option']"));//either class problem
//		for(WebElement dt:date) {
//			String d= dt.getText();
//				if(d.equals("15")) {	
//					dt.click();
//				}
		
		 WebElement dt = driver.findElement(By.cssSelector("div[aria-label='Choose Thursday, August 19th, 2004']"));
		 dt.click();
		
		
		//auto suggestion
		WebElement subject= driver.findElement(By.xpath("//input[@id='subjectsInput']"));
		subject.sendKeys("Computer");
		subject.sendKeys(Keys.ARROW_DOWN);
		subject.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		//multiple checkbox
		List<WebElement> checkbox = driver.findElements(By.xpath("//div[@id='hobbiesWrapper']//div[@class='col-md-9 col-sm-12']//div[@class='custom-control custom-checkbox custom-control-inline']//label[@class='custom-control-label']"));
		for(WebElement ck: checkbox) {
			String check= ck.getText();
			if(check.equalsIgnoreCase("Sports")||check.equals("Music")) {
				js.executeScript("arguments[0].click();",ck);
		}
	}
		
		//upload picture
		driver.findElement(By.xpath("//input[@id='uploadPicture']")).sendKeys("C:\\\\Users\\\\ria\\\\Pictures\\\\ayat\\\\20211113_234438_0000.png");
		
		//address
		driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("10/2-A dhaka");
		
		
		//state
		WebElement state=driver.findElement(By.xpath("//div[@id='state']//div[contains(@class,' css-yk16xz-control')]"));
		js.executeScript("arguments[0].click();",state);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='react-select-3-option-0']")));
		WebElement st=driver.findElement(By.xpath("//div[@id='react-select-3-option-0']"));//div[@id='state']//div[contains(@class,' css-yk16xz-control')]
		js.executeScript("arguments[0].click();",st);
//		List<WebElement> startdropdown=driver.findElements(By.xpath("//div[@class=' css-26l3qy-menu']//div[@class=' css-11unzgr']//child::div"));
//		for(WebElement item: startdropdown) {
//			if(item.getText().equals("Uttar Pradesh")) {
//				js.executeScript("arguments[0].click();",item);
//				System.out.println("successful");
//				break;
//	}
//}
		System.out.println("successful");	
	}
}

	
