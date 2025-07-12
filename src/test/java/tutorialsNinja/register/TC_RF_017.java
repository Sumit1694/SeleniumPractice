package tutorialsNinja.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_017 {

	@Test
	public void verifyRegisterWithMandatoryFields() throws InterruptedException
	{
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.get("https://tutorialsninja.com/demo/");
	
	driver.findElement(By.xpath("//span[text()='My Account']")).click();
	driver.findElement(By.linkText("Register")).click();
	
	driver.findElement(By.id("input-firstname")).sendKeys("Sumit");
	driver.findElement(By.id("input-lastname")).sendKeys("rane");
	driver.findElement(By.id("input-email")).sendKeys(generateNewEmail());
	driver.findElement(By.id("input-telephone")).sendKeys("234354657");
	driver.findElement(By.id("input-password")).sendKeys("RaneSumit123");
	driver.findElement(By.id("input-confirm")).sendKeys("RaneSumit123");
	driver.findElement(By.xpath("//input[@value='Continue']")).click();
	
	String expectedWarningMsg = "Warning: You must agree to the Privacy Policy!";
	String actualWarningMsg=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
	Assert.assertEquals(actualWarningMsg, expectedWarningMsg);
	
	driver.quit();

}	
	public static String generateNewEmail()
	{
		return new Date().toString().replaceAll(" ", "").replaceAll(":", "")+"@gmail.com";
		
	}
}
