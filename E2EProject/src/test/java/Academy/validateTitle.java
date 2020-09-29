package Academy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LandingPage;
import resources.base;

public class validateTitle extends base {
	
	public static Logger logs = (Logger) LogManager.getLogger(validateTitle.class.getName());
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws Exception
	{
		driver = initializeDriver();

		logs.info("Driver is initialised");
		driver.get(prop.getProperty("url"));
		logs.info("User is redirected to particular page");
		logs.trace("This is a trace messgae");
	}
	
	@Test
	public void basePageNavigation()
	{
		SoftAssert SA = new SoftAssert();
		
		
		LandingPage lp = new LandingPage(driver);
		Assert.assertEquals(lp.getTitle().getText(),"An Academy to Learn Earn & Shine in your QA Career");
		logs.debug("Assert Validated");
		Assert.assertFalse(lp.getTitle().isDisplayed());
		SA.assertAll();
	
	}
	
	@AfterTest
	public void TearDown()
	{
		driver.quit();
	}
	
}
