package tutorialsNinja.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_RF_019 {

	@Test(dataProvider="environmentSupplier")
	public void VerifyRegisteringAccountInDiffereTestEnvironment(String env)
	{
		String browserName = env;
		
		WebDriver driver = null;
		
		if(browserName.equals("chrome"))
		{
			 driver=new ChromeDriver();
		}else if(browserName.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}else if(browserName.equals("edge"))
		{
			driver = new EdgeDriver();
		}else {
			System.out.println("Invalid browser name!");
			return;
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("Sumit");
		driver.findElement(By.id("input-lastname")).sendKeys("rane");
		driver.findElement(By.id("input-email")).sendKeys(generateNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("234354657");
		driver.findElement(By.id("input-password")).sendKeys("RaneSumit123");
		driver.findElement(By.id("input-confirm")).sendKeys("RaneSumit123");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		
		driver.quit();
		
	}
	@DataProvider(name="environmentSupplier")
	public Object[][] passTestEnvironments() 
	{
		Object[][] envs = {{"chrome"},{"firefox"},{"edge"}};
		return envs;
	}
	
	
	public static String generateNewEmail()
	{
		return new Date().toString().replaceAll(" ", "").replaceAll(":", "")+"@gmail.com";
	}
	
}
