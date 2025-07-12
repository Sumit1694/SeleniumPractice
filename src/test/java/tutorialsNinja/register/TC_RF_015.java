package tutorialsNinja.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_015 {
	
	@Test
	public void VerifyLeadingAndTrailingSpacesautomaticallyAdjusted()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		String enteredFirstNameField = "    Sumit      ";
		driver.findElement(By.id("input-firstname")).sendKeys(enteredFirstNameField);
		String enteredLastNameField = "     rane       ";
		driver.findElement(By.id("input-lastname")).sendKeys(enteredLastNameField);
		String enteredEmail = "    "+generateNewEmail()+"    ";
		driver.findElement(By.id("input-email")).sendKeys(enteredEmail);
		String enteredTelephone = "    324553422    ";
		driver.findElement(By.id("input-telephone")).sendKeys(enteredTelephone);
		driver.findElement(By.id("input-password")).sendKeys("RaneSumit123");
		driver.findElement(By.id("input-confirm")).sendKeys("RaneSumit123");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		driver.findElement(By.xpath("//div[@class='pull-right']//a[@class='btn btn-primary']")).click();
		driver.findElement(By.linkText("Edit your account information")).click();
		
		Assert.assertEquals(driver.findElement(By.id("input-firstname")).getAttribute("value"), enteredFirstNameField);
		Assert.assertEquals(driver.findElement(By.id("input-lastname")).getAttribute("value"), enteredLastNameField);
		Assert.assertEquals(driver.findElement(By.id("input-email")).getAttribute("value"), enteredEmail);
		Assert.assertEquals(driver.findElement(By.id("input-telephone")).getAttribute("value"), enteredTelephone);
	}
	
	public static String generateNewEmail()
	{
		return new Date().toString().replaceAll(" ", "").replaceAll(":", "")+"@gmail.com";
		
	}

}
