package tutorialsNinja.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_011 {

	@Test
	public void RegisterAccountWithKeyboardKeys()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		Actions actions = new Actions(driver);
		for(int i=1;i<=23;i++)
		{
			actions.sendKeys(Keys.TAB).perform();
		}
		
		actions.sendKeys("sumit").pause(Duration.ofSeconds(1))
		.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys("rane")
		.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(generateNewEmail())
		.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys("354657645")
		.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys("Sumit123")
		.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys("Sumit123")
		.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(Keys.LEFT)
		.pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
		.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(Keys.SPACE)
		.pause(Duration.ofSeconds(1)).sendKeys(Keys.ENTER).perform();
		
		String heading = driver.findElement(By.xpath("//div[@id='content']//h1")).getText();
		Assert.assertEquals(heading, "Your Account Has Been Created!");
		
		driver.quit();

		
	}

	public static String generateNewEmail() {
        return new Date().toString().replaceAll(" ", "").replaceAll(":", "") + "@gmail.com";

	}
}
