package Academy;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LandingPage;
import resources.base;

public class validateNavidationBar extends base {
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws Exception
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void basePageNavigation() throws Exception 
	{
		SoftAssert SA = new SoftAssert();	
		LandingPage lp = new LandingPage(driver);
		AssertJUnit.assertTrue(lp.getNavBar().isDisplayed());
		AssertJUnit.assertTrue(lp.getProjectBar().isDisplayed());
		SA.assertAll();
	}
	
	@AfterTest
	public void TearDown()
	{
		driver.quit();
	}

	
}
