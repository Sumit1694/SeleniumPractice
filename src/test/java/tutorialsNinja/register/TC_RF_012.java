package tutorialsNinja.register;

import java.time.Duration;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_012 {

	@Test
	public void VerifyPlaceHolderTextAttribute()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		String ExpectedFirstNamePlaceHolderText = "First Name";
		Assert.assertEquals(driver.findElement(By.id("input-firstname")).getAttribute("placeholder"), ExpectedFirstNamePlaceHolderText);
		
		String ExpectedLastNamePlaceHolderText = "Last Name";
		Assert.assertEquals(driver.findElement(By.id("input-lastname")).getAttribute("placeholder"), ExpectedLastNamePlaceHolderText);
		
		String ExpectedEmailPlaceHolderText = "E-Mail";
		Assert.assertEquals(driver.findElement(By.id("input-email")).getAttribute("placeholder"), ExpectedEmailPlaceHolderText);
		
		String ExpectedTelephonePlaceHolderText = "Telephone";
		Assert.assertEquals(driver.findElement(By.id("input-telephone")).getAttribute("placeholder"), ExpectedTelephonePlaceHolderText);
		
		String ExpectedPasswordPlaceHolderText = "Password";
		Assert.assertEquals(driver.findElement(By.id("input-password")).getAttribute("placeholder"), ExpectedPasswordPlaceHolderText);
		
		String ExpectedconfPasswordPlaceHolderText = "Password Confirm";
		Assert.assertEquals(driver.findElement(By.id("input-confirm")).getAttribute("placeholder"), ExpectedconfPasswordPlaceHolderText);		
		
		driver.quit();
	}

	public static String generateNewEmail() {
        return new Date().toString().replaceAll(" ", "").replaceAll(":", "") + "@gmail.com";

	}
}
	

