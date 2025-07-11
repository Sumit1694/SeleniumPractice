package tutorialsNinja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_004 {
	@Test
	public void verifyRegisterWithAllFields() throws InterruptedException
	{
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.get("https://tutorialsninja.com/demo/");

	driver.findElement(By.xpath("//span[text()='My Account']")).click();
	driver.findElement(By.linkText("Register")).click();
	driver.findElement(By.xpath("//input[@value='Continue']")).click();
	
	String FirstNameWarningmsg="First Name must be between 1 and 32 characters!";
	String LastNameWarningmsg="Last Name must be between 1 and 32 characters!";
	String EmailAddressWarningmsg="E-Mail Address does not appear to be valid!";
	String TelephoneNumberWarningmsg="Telephone must be between 3 and 32 characters!";
	String PasswordWarningmsg="Password must be between 4 and 20 characters!";
	String PrivacyPolicyWarningmsg="Warning: You must agree to the Privacy Policy!";
	
	Assert.assertEquals(driver.findElement(By.xpath("//input[@name='firstname']//following-sibling::div[@class='text-danger']")).getText(), FirstNameWarningmsg);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@name='lastname']//following-sibling::div[@class='text-danger']")).getText(), LastNameWarningmsg);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@name='email']//following-sibling::div[@class='text-danger']")).getText(), EmailAddressWarningmsg);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@name='telephone']//following-sibling::div[@class='text-danger']")).getText(), TelephoneNumberWarningmsg);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@name='password']//following-sibling::div[@class='text-danger']")).getText(), PasswordWarningmsg);
	Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(), PrivacyPolicyWarningmsg);
	
	driver.quit();
	
}
}