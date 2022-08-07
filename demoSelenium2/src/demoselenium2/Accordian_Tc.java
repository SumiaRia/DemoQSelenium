package demoselenium2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Accordian_Tc {
/*test case
 * Check after a click on the Accordion it open the content of the clicked section.
 * Check if the sections are sortable or not.
 * Check the width and height of the Accordion is as per the specification document.
 * Check if all the sections can be expanded and close back again.
 * 
 *  
 * */
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\ria\\eclipse\\java-2022-06\\eclipse\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demoqa.com/accordian");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		Check after a click on the Accordion it open the content of the clicked section.&Check the width and height of the Accordion is as per the specification document.
		WebElement section1=driver.findElement(By.cssSelector("#section1Heading"));
		WebElement collaps1 = driver.findElement(By.xpath("//div[@id='section1Content']//p[contains(text(),\"Lorem Ipsum is simply dummy text of the printing a\")]"));
		System.out.println("Section 1 text: "+collaps1.getText());
		//WebElement size = driver.findElement(By.xpath("//input[@id='txtUsername']"));
		org.openqa.selenium.Dimension dim= collaps1.getSize();
		System.out.println("height: "+dim.height);
		System.out.println("width: "+dim.width);
		section1.click();
		
		
		// Check if the sections are sortable or not.
		List<WebElement>sorts= driver.findElements(By.xpath("//div[@class='card-header']"));
		ArrayList org = new ArrayList();
		ArrayList temp = new ArrayList();
		for(WebElement sorting : sorts) {
			org.add(sorting.getText());
			temp.add(sorting.getText());
		}
		System.out.println("the original list: "+org);
		System.out.println("the temp list: "+temp);	
		Collections.sort(temp);
		System.out.println("After sorting  temp list: "+temp);	
		if(org.equals(temp)) {
			System.out.println("The accordian section is sorting");
		}
		else {
			System.out.println("The accordian section is not sorting");
		}
//
//		List<WebElement>accordian= driver.findElements(By.xpath("//div[@class='card']//child::div[@class='collapse']"));
//		//Dimension dim = ((WebElement) accordian).getSize();
//		for(WebElement a: accordian) {
//			
//			Dimension dim = a.getSize();
//			System.out.println("height: "+dim.height);
//			System.out.println("width: "+dim.width);
//		}
		//div[@id='accordianContainer']//div[@class='accordion']//div[@class='card']
//		WebElement section2=driver.findElement(By.cssSelector("#section2Heading"));
//		section2.click();
//		WebElement section3=driver.findElement(By.cssSelector("#section3Heading"));
//		js.executeScript("arguments[0].click();", section3);
		
//		Actions act = new Actions(driver);
//		act.doubleClick(section2).perform();
//		Thread.sleep(2000);
//		act.doubleClick(section3).perform();
		
		//Check if all the sections can be expanded and close back again.
		List<WebElement>section = driver.findElements(By.xpath("//div[@class='accordion']//div[@class='card']//div[@class='card-header']"));
		for(WebElement s : section) {
	        System.out.println(s.getSize());
	        js.executeScript("arguments[0].click();", s);
	        Thread.sleep(2000);
//		for(int s=1; s<6; s++) {
//		}
		}
	}

}
