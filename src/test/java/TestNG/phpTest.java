package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class phpTest {
	WebDriver driver;
	
	@BeforeMethod
	public void launch()
	{
		System.setProperty("webdriver.chrome.driver","/tmp/workspace/test/target/surefire-reports/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--no-sandbox");
		driver = new ChromeDriver(options);
		options.addArguments("--headless");
		driver.get("http://35.194.210.186:9999/");
       
	}
	
  @Test
  public void verifytabs() {
	  
	  System.out.println(driver.getTitle());
	  driver.findElement(By.id("About Us")).click();
	  String s = driver.getPageSource();
	 System.out.println("starts from here");
      System.out.println(s);
	  System.out.println("ends here");
      Assert.assertEquals(s, ""<html><head></head><body><p id=\"PID-ab2-pg\">This is <b>about</b> page. Lorem Ipsum Dipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>\n" + 
      		"<p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).</p>");
	  
      System.out.println("Website is deployed and is running fine");
  }
	
  
  @AfterMethod
	public void close()
	{
		driver.close();
	}
	
}
