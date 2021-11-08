package com.mp;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartTest { 
	static WebDriver driver;
	@BeforeClass
	public static void lanuch() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	driver.manage().window().maximize();
	}
	@Before
	public void beforeMethod() {
		startTime = System.currentTimeMillis();
	}
	
	private long startTime;
	@Test
	public void mobliesPurchase() {
		driver.findElement(By.xpath("//button[text()='X']")).click();
		driver.findElement(By.name("q")).sendKeys("i phone mobiles");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	
		driver.findElement(By.xpath("(//div[contains(@class,'4rR01T')]) [1]")).click();
		
	}
	@Test
	public void windowsHandling() {
		String pW = driver.getWindowHandle();
		Set<String> alWin = driver.getWindowHandles();
		for(String x: alWin) {
			if(x.equals(pW)) {
				driver.switchTo().window(x); 
				}
				}
		}
	@After
	public void afterMethod() {
	long endTime = System.currentTimeMillis();
	long tt = startTime-endTime;
	System.out.println("Time taken is :"+ tt);
	}
	@AfterClass
	public void closebrowser() throws IOException {
		TakesScreenshot tk =(TakesScreenshot)driver;
		File source = tk.getScreenshotAs(OutputType.FILE);
		File target = new File(".//target//report.png");
		FileUtils.copyFile(source, target);
		driver.quit();
		}
	
	
}

