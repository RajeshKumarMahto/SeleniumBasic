package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasicPopUps {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/");
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		
		//Basic Auth Pop up
//		driver.findElement(By.linkText("Basic Auth")).click();
//		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
//		Thread.sleep(3000);
		
		
		//Java Script Alerts
		//1. Information/Alert Popup
		driver.findElement(By.linkText("JavaScript Alerts")).click();
		driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//p[text()='You successfully clicked an alert']")).getText());
		//2. JS confirmation Popup
		driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
		driver.switchTo().alert().dismiss();
		System.out.println(driver.findElement(By.xpath("//p[text()='You clicked: Cancel']")).getText());
		driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
		driver.switchTo().alert().accept();
		System.out.println(driver.findElement(By.xpath("//p[text()='You clicked: Ok']")).getText());
		
		
		driver.quit();
		
		
		

	}

}
