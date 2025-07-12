package tutorialsNinja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_014 {

	@Test
	public void verifyHeightWidthOfTextFields()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		String ExpectedHeight = "34px";
		String ExpectedWidth = "701.25px";
		
		String actualFirstNameFieldHeight = driver.findElement(By.id("input-firstname")).getCssValue("height");
		String expectedFirstNameFieldWidth = driver.findElement(By.id("input-firstname")).getCssValue("width");
		
		Assert.assertEquals(actualFirstNameFieldHeight, ExpectedHeight);
		Assert.assertEquals(expectedFirstNameFieldWidth, ExpectedWidth);
		
		String actuallastNameFieldHeight = driver.findElement(By.id("input-lastname")).getCssValue("height");
		String actuallastNameFieldWidth = driver.findElement(By.id("input-lastname")).getCssValue("width");
		
		Assert.assertEquals(actuallastNameFieldHeight, ExpectedHeight);
		Assert.assertEquals(actuallastNameFieldWidth, ExpectedWidth);
		
		String actualemailFieldHeight = driver.findElement(By.id("input-email")).getCssValue("height");
		String actualemailFieldWidth = driver.findElement(By.id("input-email")).getCssValue("width");
		
		Assert.assertEquals(actualemailFieldHeight, ExpectedHeight);
		Assert.assertEquals(actualemailFieldWidth, ExpectedWidth);
		
		String actualtelephoneFieldHeight = driver.findElement(By.id("input-telephone")).getCssValue("height");
		String actualtelephoneFieldWidth = driver.findElement(By.id("input-telephone")).getCssValue("width");
		
		Assert.assertEquals(actualtelephoneFieldHeight, ExpectedHeight);
		Assert.assertEquals(actualtelephoneFieldWidth, ExpectedWidth);
		
		String actualpasswordFieldHeight = driver.findElement(By.id("input-password")).getCssValue("height");
		String actualpasswordFieldWidth = driver.findElement(By.id("input-password")).getCssValue("width");
		
		Assert.assertEquals(actualpasswordFieldHeight, ExpectedHeight);
		Assert.assertEquals(actualpasswordFieldWidth, ExpectedWidth);
		
		String actualconfirmpasswordFieldHeight = driver.findElement(By.id("input-confirm")).getCssValue("height");
		String actualconfirmpasswordFieldWidth = driver.findElement(By.id("input-confirm")).getCssValue("width");
		
		Assert.assertEquals(actualconfirmpasswordFieldHeight, ExpectedHeight);
		Assert.assertEquals(actualconfirmpasswordFieldWidth, ExpectedWidth);
		
		driver.quit();
	}
}
