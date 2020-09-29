package resources;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class base {
	
	public WebDriver driver = null;
	public Properties prop;
	public WebDriver initializeDriver() throws Exception
	{
		
		String projectPath = System.getProperty("user.dir");
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream(projectPath+ "/src/main/java/resources/data.properties");
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromeDriver/chromedriver");
			driver = new ChromeDriver(); 
			
		}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", projectPath+"/drivers/geckoDriver/geckodriver");
			driver = new FirefoxDriver(); 
			//WebDriverWait  wt = new WebDriverWait();
		}
		else if(browserName.equalsIgnoreCase("Safari"))
		{
			//Safari Code 
			driver = new SafariDriver();
			driver.get("https://www.google.com");
			System.out.print(driver.getTitle());
			
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
		
	}
	
	public void getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"\\reports"+ testCaseName+".png";
		FileUtils.copyFile(source, new File(destination));
		
		
	}
}
