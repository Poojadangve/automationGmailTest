package test.automationGmailTest.pageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.automationGmailTest.AbstractComponents.AbstractComponents;

public class ComposeMail extends AbstractComponents {

	WebDriver driver;

	public ComposeMail(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "z0")
	WebElement clickOnComposeMailOtp;

	By waitForComposeMailScreen = By.xpath("//input[@role='combobox']");

	@FindBy(xpath = "//input[@role='combobox']")
	WebElement enterToMailId;

	@FindBy(name = "subjectbox")
	WebElement enterSubject;

	@FindBy(xpath = "//div[@role='textbox']")
	WebElement enterBodyOfMail;

	@FindBy(xpath = "//div[@aria-label='More options']")
	WebElement clickOnMoreOtp;

	By waitForAllMoreOtp = By.xpath("//div[@class='M9']/descendant::div[@class='J-N-Jz']");

	@FindBy(xpath = "//div[@class='M9']/descendant::div[@class='J-N-Jz']")
	List<WebElement> allMoreOtp;

	By waitForAllLabelOtp = By.xpath("//div[@class='J-M agd jQjAxd aX1']/descendant::div[@class='J-LC-Jo J-J5-Ji']");

	@FindBy(xpath = "//div[@class='J-M agd jQjAxd aX1']/descendant::div[@class='J-LC-Jo J-J5-Ji']")
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

	public void composeToMail(String emailId, String subject, String bodyText) throws Exception {
		clickOnComposeMailOtp.click();
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		String composeMailScreen = it.next();
		driver.switchTo().window(composeMailScreen);
		waitForElementToAppear(waitForComposeMailScreen);
		Thread.sleep(1000);
		enterToMailId.sendKeys(emailId);
		enterSubject.sendKeys(subject);
		Thread.sleep(1000);
		enterBodyOfMail.sendKeys(bodyText);
		Thread.sleep(1000);
	}

	public void clickOnMoreOtp() {
		clickOnMoreOtp.click();
	}

	public List<WebElement> getAllMoreOtp() {
		return allMoreOtp;
	}

	public void selectTargetedMoreOtp() throws Exception {
		String expectedResult = "Label";
		for (int i = 0; i < getAllMoreOtp().size(); i++) {
			String getText = getAllMoreOtp().get(i).getText();
			Thread.sleep(1000);
			if (getText.equalsIgnoreCase(expectedResult)) {
				Actions action = new Actions(driver);
				action.moveToElement(getAllMoreOtp().get(i)).build().perform();
			}
		}
	}

	public List<WebElement> getAllLabelOtp() {
		return allLabelOtp;
	}

	public void selectSocial() throws Exception {
		String expectedLabel = "Social";
		for (int i = 0; i < getAllLabelOtp().size(); i++) {
			String getLabel = getAllLabelOtp().get(i).getText();
			Thread.sleep(1000);
			if (getLabel.equalsIgnoreCase(getLabel)) {
				getAllLabelOtp().get(i).click();
				break;
			}
		}
	}

	public void clickOnSendOtp() {
		clickOnSendButton.click();
	}

	public List<WebElement> getAllMailList() {
		return allMails;
	}

	public void makeStarred() {
		String mailText = "pooja.dangve93@gmail.com";
		for (int i = 0; i <= getAllMailList().size(); i++) {
			String getMail = getAllMailList().get(i).getAttribute("email");
			if (getMail.equalsIgnoreCase(mailText)) {
				makeStarred.click();
				openTheMail.click();
				break;
			}
		}
	}

	public String validateSubjectText() {
		String text = getSubjectText.getText();
		return text;
	}

	public String validateBodyText() {
		String textBody = getBodytext.getText();
		return textBody;
	}
}
