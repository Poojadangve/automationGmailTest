package test.automationGmailTest.testClass;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import test.automationGmailTest.pageObjects.ComposeMail;
import test.automationGmailTest.pageObjects.LandingPage;
import test.automationGmailTest.test.BaseTest;

public class TestGmailClass extends BaseTest {

	@Test
	public void automateGmail() throws Exception {

		String emailId = "pooja.dangve93@gmail.com";
		String password = "Pooja@1dangve";
		String toMailId = "pooja.dangve93@gmail.com";
		String subjectText = "Test Mail";
		String bodyText = "Test Email Body";

		LandingPage landingPage = launchApplication();
		landingPage.loginToGmailAccount(emailId, password);
		Thread.sleep(6000);

		ComposeMail composeMail = new ComposeMail(driver);
		composeMail.composeToMail(toMailId, subjectText, bodyText);
		composeMail.clickOnMoreOtp();
		composeMail.getAllMoreOtp();
		List<WebElement> getallMoreOtp = composeMail.getAllMoreOtp();
		composeMail.selectTargetedMoreOtp();
		List<WebElement> allLabelOtp = composeMail.getAllLabelOtp();
		composeMail.selectSocial();
		composeMail.clickOnSendOtp();
		List<WebElement> allMailList = composeMail.getAllMailList();
		composeMail.makeStarred();
		String getsubjectText = composeMail.validateSubjectText();
		System.out.println(subjectText);
		Assert.assertEquals(getsubjectText, subjectText);
		Thread.sleep(3000);
		String getbodyText = composeMail.validateBodyText();
		System.out.println(bodyText);
		Assert.assertEquals(getbodyText, bodyText);

	}

}
