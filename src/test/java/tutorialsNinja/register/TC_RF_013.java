package tutorialsNinja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_013 {

	@Test
	public void verifyMandatoryFieldSymbolsAndColours()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		String expectedContent = "\"* \"";
		String expectedColor = "rgb(255, 0, 0)";
		
		WebElement firstNameLabel = driver.findElement(By.xpath("//label[@for='input-firstname']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String fnContent = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", firstNameLabel);
		System.out.println(fnContent);
		
		String fnColor = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", firstNameLabel);
		System.out.println(fnColor);
		
		Assert.assertEquals(fnContent, expectedContent);
		Assert.assertEquals(fnColor, expectedColor);
		
		WebElement lastNameLabel = driver.findElement(By.xpath("//label[@for='input-lastname']"));
		String lnContent = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", lastNameLabel);
		System.out.println(lnContent);
		
		String lnColor = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", lastNameLabel);
		System.out.println(lnColor);
		
		Assert.assertEquals(lnContent, expectedContent);
		Assert.assertEquals(lnColor, expectedColor);
		
		WebElement emailLabel = driver.findElement(By.xpath("//label[@for='input-email']"));
		String emailContent = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", emailLabel);
		System.out.println(emailContent);
		
		String emailColor = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", emailLabel);
		System.out.println(emailColor);
		
		Assert.assertEquals(emailContent, expectedContent);
		Assert.assertEquals(emailColor, expectedColor);
		
		WebElement telephoneLabel = driver.findElement(By.xpath("//label[@for='input-telephone']"));
		String telephoneContent = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", telephoneLabel);
		System.out.println(telephoneContent);
		
		String telephoneColor = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", telephoneLabel);
		System.out.println(telephoneColor);
		
		Assert.assertEquals(telephoneContent, expectedContent);
		Assert.assertEquals(telephoneColor, expectedColor);
		
		WebElement passwordLabel = driver.findElement(By.xpath("//label[@for='input-password']"));
		String passwordContent = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", passwordLabel);
		System.out.println(passwordContent);
		
		String passwordColor = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", passwordLabel);
		System.out.println(passwordColor);
		
		Assert.assertEquals(passwordContent, expectedContent);
		Assert.assertEquals(passwordColor, expectedColor);
		
		WebElement confpasswordLabel = driver.findElement(By.xpath("//label[@for='input-confirm']"));
		String confpasswordContent = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", confpasswordLabel);
		System.out.println(confpasswordContent);
		
		String confpasswordColor = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", confpasswordLabel);
		System.out.println(confpasswordColor);
		
		Assert.assertEquals(confpasswordContent, expectedContent);
		Assert.assertEquals(confpasswordColor, expectedColor);
		
		
		
		driver.quit();
		
		
		
		
	}
	
}
