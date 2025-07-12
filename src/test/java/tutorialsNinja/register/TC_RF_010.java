package tutorialsNinja.register;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class TC_RF_010 {

	@Test
	public void verifyRegisterWithExistingEmailAddress() throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Sumit");
		driver.findElement(By.id("input-lastname")).sendKeys("rane");
		driver.findElement(By.id("input-email")).sendKeys("Sumatran");
		driver.findElement(By.id("input-telephone")).sendKeys("234354657");
		driver.findElement(By.id("input-password")).sendKeys("RaneSumit123");
		driver.findElement(By.id("input-confirm")).sendKeys("RaneSumit1235"); // intentionally mismatched
		driver.findElement(By.xpath("//label[@class='radio-inline']//input[@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		Thread.sleep(1000); // for visibility; can be avoided if wait is implemented

		// Capture and verify error message
		File srcScreenshot1 = driver.findElement(By.xpath("//div[@id='content']")).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcScreenshot1, new File(System.getProperty("user.dir")+"\\Screenshots\\sc1Actual.png"));

		BufferedImage actualBimg=ImageIO.read(new File(System.getProperty("user.dir")+"\\Screenshots\\sc1Actual.png"));
		BufferedImage ExpectedBimg=ImageIO.read(new File(System.getProperty("user.dir")+"\\Screenshots\\sc1Expected.png")); 

		ImageDiffer imgDiffer = new ImageDiffer();
		ImageDiff imgDifference = imgDiffer.makeDiff(ExpectedBimg, actualBimg);

		Assert.assertFalse(imgDifference.hasDiff());
		//Second assertion
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("sumitran@");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Thread.sleep(3000);

		File srcScreenshot2 = driver.findElement(By.xpath("//div[@id='content']")).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcScreenshot2, new File(System.getProperty("user.dir")+"\\Screenshots\\sc2Actual.png"));

		Assert.assertFalse(compareTwoScreenshots(System.getProperty("user.dir")+"\\Screenshots\\sc2Actual.png", System.getProperty("user.dir")+"\\Screenshots\\sc2Expected.png"));
		//Third Assertion
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("sumitran@gmail");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String ExpectedWarningMsg = "E-Mail Address does not appear to be valid!";
		String ActualWarningMsg=driver.findElement(By.xpath("//div[@class='text-danger']")).getText();
		
		Assert.assertEquals(ExpectedWarningMsg, ActualWarningMsg);
		
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("sumitran@gmail.");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		File srcScreenshot3 = driver.findElement(By.xpath("//div[@id='content']")).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcScreenshot3, new File(System.getProperty("user.dir")+"\\Screenshots\\sc3Actual.png"));
		Assert.assertFalse(compareTwoScreenshots(System.getProperty("user.dir")+"\\Screenshots\\sc2Actual.png", System.getProperty("user.dir")+"\\Screenshots\\sc2Expected.png"));
		
		driver.quit();
	}

	public boolean compareTwoScreenshots(String actualImagePath, String expectedImagePath) throws IOException
	{
		BufferedImage actualBimg=ImageIO.read(new File(actualImagePath));
		BufferedImage ExpectedBimg=ImageIO.read(new File(expectedImagePath)); 

		ImageDiffer imgDiffer = new ImageDiffer();
		ImageDiff imgDifference = imgDiffer.makeDiff(ExpectedBimg, actualBimg);
		
		return imgDifference.hasDiff();

	}



}
