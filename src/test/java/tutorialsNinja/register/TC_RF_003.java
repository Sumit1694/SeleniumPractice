package tutorialsNinja.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_003 {
		
		@Test
		public void verifyRegisterWithAllFields() throws InterruptedException
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
		driver.findElement(By.xpath("//label[@class='radio-inline']//input[@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Thread.sleep(3000);
		
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		
		String expectedHeading = "Your Account Has Been Created!";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']//h1")).getText(), expectedHeading);
		
		String expectedCongratulationsmsg = "Congratulations! Your new account has been successfully created!";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']//h1//following-sibling::p[1]")).getText(), expectedCongratulationsmsg);
		
		String expectedSecondmsg = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']//h1//following-sibling::p[2]")).getText(), expectedSecondmsg);
		
		String expectedthirdmsg = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']//h1//following-sibling::p[3]")).getText(), expectedthirdmsg);
		
		String expectedfourthmsg = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us.";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']//h1//following-sibling::p[4]")).getText(), expectedfourthmsg);
		
			driver.quit();
	}
		
	public static String generateNewEmail()
	{
		return new Date().toString().replaceAll(" ", "").replaceAll(":", "")+"@gmail.com";
		
	}
}
