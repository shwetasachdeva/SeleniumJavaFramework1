package Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
	public WebDriver driver;
	
	public static Logger Log = (Logger) LogManager.getLogger(HomePage.class);
	
	@BeforeTest
	public void initialize() throws Exception
	{
		driver = initializeDriver();
		Log.info("Driver is initialised");
	}
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String email, String pwd) throws Exception
	{

		driver.get(prop.getProperty("url"));
		Log.info("Navigated to Homepage");
		LandingPage lp = new LandingPage(driver);
		lp.getLogin().click();
		LoginPage l = new LoginPage(driver);
		l.getEmail().sendKeys(email);
		l.getPassword().sendKeys(pwd);
		l.getLogin().click();
		Log.info(email);
		
	}

	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][2];
		data[0][0] = "nonrestricteduser@gmail.com";
		data[0][1] = "Password@1";
		//data[0][2] = "Non-Restricted User";
		
		data[1][0] = "restricteduser@gmail.com";
		data[1][1] = "Password@1";
		//data[1][2] = "Restricted User";
		
		return data;
	

	}
	
	@AfterTest
	public void TearDown()
	{
		driver.quit();
		Log.info("Test Completed");
	}
}
