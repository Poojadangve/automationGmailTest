package test.automationGmailTest.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.automationGmailTest.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{
	
	WebDriver driver;
	
	
	public LandingPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//a[contains(text(),'Sign in')]" )
	WebElement signInButton;
	
	@FindBy(id = "identifierId")
	WebElement enterUsername;
	
	@FindBy(xpath = "//span[contains(text(),'Next')]")
	WebElement nextButton;
	
	By waitForPasswordField = By.name("Passwd");
	
	@FindBy(name = "Passwd")
	WebElement enterPassword;

	public void goTo()
	{
		driver.get("https://mail.google.com/");
	}
	
	public ComposeMail loginToGmailAccount(String emailId, String password)
	{
		signInButton.click();
		enterUsername.sendKeys(emailId);

		
		nextButton.click();
		
		waitForElementToAppear(waitForPasswordField);

		enterPassword.sendKeys(password);
		
		nextButton.click();
		
		ComposeMail composeMail = new ComposeMail(driver);
		return composeMail;


	}

}
