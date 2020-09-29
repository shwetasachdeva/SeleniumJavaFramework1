package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver = null;
	By signIn = By.xpath("//a[@class='theme-btn']"); 
	By signUp = By.cssSelector("a[href = 'sign_up']"); 
	By title = By.xpath("//h2[@class='headline']");
	By projectBar = By.xpath("//a[contains(text(), 'Project')]");
	By navBar = By.xpath("//ul[contains(@class, 'navigation')]");
	
	public LandingPage(WebDriver driver) 
	{
		this.driver = driver;
	}

	public WebElement getLogin()
	{
		return driver.findElement(signIn);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getNavBar()
	{
		return driver.findElement(navBar);
	}
	public WebElement getProjectBar()
	{
		return driver.findElement(projectBar);
	}


}
