package test.automationGmailTest.pageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.automationGmailTest.AbstractComponents.AbstractComponents;

public class ComposeMail extends AbstractComponents{
	
WebDriver driver;
	
	
	public ComposeMail(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "z0")
	WebElement clickOnComposeMailOtp;
	
	By waitForComposeMailScreen = By.xpath("//input[@role='combobox']");
	
	@FindBy(xpath ="//input[@role='combobox']")
	WebElement enterToMailId;
	
	@FindBy(name = "subjectbox")
	WebElement enterSubject;
	
	@FindBy(xpath = "//div[@role='textbox']")
	WebElement enterBodyOfMail;
	
	@FindBy(xpath = "//div[@aria-label='More options']")
	WebElement clickOnMoreOtp;
	
	By waitForAllMoreOtp = By.xpath("//div[@class='M9']/child::div[@role='menu'][2]/div/div/descendant::div[@class='J-N-Jz']");
	
	@FindBy(xpath = "//div[@class='M9']/child::div[@role='menu'][2]/div/div/descendant::div[@class='J-N-Jz']")
	List<WebElement> allMoreOtp;
	
	By waitForAllLabelOtp = By.xpath("//div[@class='J-M agd jQjAxd aX1']/div/div[@class='J-M-Jz aiL']/div/child::div/div");
	
	@FindBy(xpath = "//div[@class='J-M agd jQjAxd aX1']/div/div[@class='J-M-Jz aiL']/div/child::div/div")
	List<WebElement> allLabelOtp;
	
	@FindBy(xpath = "//div[@class='dC']/div[contains(text(),'Send')]")
	WebElement clickOnSendButton;
	
	@FindBy(xpath = "//tbody/tr[@role='row']/td[@role='gridcell'][1]/descendant::span[@class='bA4'][2]/span")
	List<WebElement> allMails;
	
	@FindBy(xpath = "//tbody/tr[@role='row']/td[@class='apU xY']")
	WebElement makeStarred;
	
	@FindBy(xpath = "//tbody/tr[@role='row']/td[4]")
	WebElement openTheMail;
	
	@FindBy(xpath = "//div[@class='ha']/h2")
	WebElement getSubjectText;
	
	@FindBy(xpath = "//div[@class='a3s aiL ']/div[1]")
	WebElement getBodytext;
	
	public void composeToMail(String emailId, String subject, String bodyText) throws Exception
	{
		clickOnComposeMailOtp.click();
		
		Set<String> window = driver.getWindowHandles();
		
		Iterator<String> it = window.iterator();

		String composeMailScreen = it.next();
		
		driver.switchTo().window(composeMailScreen);
		
		waitForElementToAppear(waitForComposeMailScreen);
		
		Thread.sleep(3000);
		
		enterToMailId.sendKeys(emailId);
		
		enterSubject.sendKeys(subject);
		Thread.sleep(3000);

		enterBodyOfMail.sendKeys(bodyText);
		Thread.sleep(3000);
	}

	public void selectSocialOpt() throws Exception
	{
		clickOnMoreOtp.click();
		
		waitForElementToAppear(waitForAllMoreOtp);
		
		List<WebElement> allOtp = allMoreOtp;
		String expectedResult = "Label";
		for(int i = 0; i<allOtp.size();i++)
		{
		 String getText = 	allOtp.get(i).getText();
		 
		 Thread.sleep(3000);
		 if(getText.equalsIgnoreCase(expectedResult))
		 {
			 allOtp.get(i).click();
			 break;
		 }
		}
		
		Thread.sleep(3000);
		List<WebElement> otp = allLabelOtp;
		
		String expectedLabel = "Social";
		
		for(int i = 0;i<otp.size();i++)
		{
			String getLabel = otp.get(i).getText();
			Thread.sleep(3000);
			if(getLabel.equalsIgnoreCase(getLabel))
			{
				otp.get(i).click();
				break;
			}
		}
		
		
	}
	
	public void clickOnSendOtp()
	{
		//Thread.sleep(3000);
		
		clickOnSendButton.click();
	}
	
	public void makeStarred()
	{
		
		
		//Thread.sleep(3000);
		List<WebElement> allMail = allMails;
		
		String mailText = "pooja.dangve93@gmail.com";
		
		for(int i = 0; i<= allMail.size();i++)
		{
			String getMail = allMail.get(i).getAttribute("email");
			
			//Thread.sleep(3000);
			if(getMail.equalsIgnoreCase(mailText))
			{
				makeStarred.click();
				//Thread.sleep(3000);
				openTheMail.click();
				break;

			}
			
		}
		}
		
		public String validateSubjectText()
		{
			
		//	Thread.sleep(3000);
		String text =getSubjectText.getText();
		return text;

		}
		
		public String validateBodyText()
		{
			//Thread.sleep(3000);
			String textBody = getBodytext.getText();
			return textBody;

		}
	
	
		
	
	
	
	
	
	
	
	
	
}
