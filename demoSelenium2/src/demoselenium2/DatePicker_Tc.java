package demoselenium2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePicker_Tc {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\ria\\eclipse\\java-2022-06\\eclipse\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demoqa.com/date-picker");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//Select Date
		WebElement select_date = driver.findElement(By.xpath("//input[@id='datePickerMonthYearInput']"));
		select_date.click();
		Select month = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']")));
		month.selectByVisibleText("August");
		Select year = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']")));
		year.selectByVisibleText("2004");
		WebElement dt = driver.findElement(By.cssSelector("div[aria-label='Choose Thursday, August 19th, 2004']"));
		dt.click();
		
		//Date And Time
		WebElement select_month = driver.findElement(By.xpath("//input[@id='dateAndTimePickerInput']"));
		select_month.click();
		driver.findElement(By.xpath("//div[@class='react-datepicker__month-dropdown-container react-datepicker__month-dropdown-container--scroll']//span[@class='react-datepicker__month-read-view--down-arrow']")).click();
		WebElement dat = driver.findElement(By.xpath("//div[normalize-space()='September']"));
		js.executeScript("arguments[0].click();",dat);
//		List<WebElement> sel_month=driver.findElements(By.xpath("//div[contains(@class,'react-datepicker__month-dropdown')]//child::div[@class='react-datepicker__month-option']"));
//		for(WebElement s_m:sel_month) {
//			String s= s_m.getText();
//				if(s.equals("March")) {	
//					s_m.click();
//				}
//		}
		
		select_month.click();
		driver.findElement(By.xpath("//span[@class='react-datepicker__year-read-view--down-arrow']")).click();
		WebElement yr = driver.findElement(By.xpath("//div[normalize-space()='2019']"));
		js.executeScript("arguments[0].click();",yr);
		 
		WebElement time = driver.findElement(By.xpath("//li[normalize-space()='16:00']"));
		js.executeScript("arguments[0].click();",time);
			
			Thread.sleep(2000);
			WebElement show = driver.findElement(By.xpath("//input[@id='dateAndTimePickerInput']"));
			System.out.println(show.getAttribute("value"));
			
		 
		 

	}

}
