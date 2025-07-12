package tutorialsNinja.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_009 {

    @Test
    public void verifyRegisterWithExistingEmailAddress() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
        
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("input-firstname")).sendKeys("Sumit");
        driver.findElement(By.id("input-lastname")).sendKeys("rane");
        driver.findElement(By.id("input-email")).sendKeys("Sumitrane19888@gmail.com");
        driver.findElement(By.id("input-telephone")).sendKeys("234354657");
        driver.findElement(By.id("input-password")).sendKeys("RaneSumit123");
        driver.findElement(By.id("input-confirm")).sendKeys("RaneSumit1235"); // intentionally mismatched
        driver.findElement(By.xpath("//label[@class='radio-inline']//input[@value='1']")).click();
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        
        Thread.sleep(1000); // for visibility; can be avoided if wait is implemented
        
        // Capture and verify error message
        String expectedErrorText = "Warning: E-Mail Address is already registered!";
        String actualErrorText = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
        Assert.assertEquals(actualErrorText, expectedErrorText);
        
        driver.quit();
    }

    public static String generateNewEmail() {
        return new Date().toString().replaceAll(" ", "").replaceAll(":", "") + "@gmail.com";
    }
}