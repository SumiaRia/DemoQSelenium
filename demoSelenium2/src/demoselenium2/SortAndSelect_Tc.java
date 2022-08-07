package demoselenium2;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class SortAndSelect_Tc {
//bug found
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\ria\\eclipse\\java-2022-06\\eclipse\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demoqa.com/sortable");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='demo-tab-grid']")).click();
//		driver.findElement(By.xpath("//div[@class='create-grid']//div[@class='list-group-item list-group-item-action'][normalize-space()='One']")).click();
		List<WebElement> selgrid = driver.findElements(By.xpath("//div[@id='demo-tabpane-grid']//div[@class='create-grid']//child::div[@class='list-group-item list-group-item-action']"));
		Actions act = new Actions(driver);
		int box= selgrid.size();
		System.out.println("size: "+box);
		for(int i=0;i<box-5;i++) {
			selgrid.get(i).click();
		}
		//the boxes is not clicked
		
		
//check whether sorted or not
		ArrayList org = new ArrayList();
		ArrayList temp = new ArrayList();
		for(WebElement grid: selgrid) {
			org.add(grid.getText());
			temp.add(grid.getText());
		}
		Collections.sort(temp);
		if(org.equals(temp)) {
			System.out.println("Sorted");
		}
		else {
			System.out.println("unsorted");
		}
	}

}
