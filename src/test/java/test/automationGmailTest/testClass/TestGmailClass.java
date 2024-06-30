package test.automationGmailTest.testClass;

import org.junit.Assert;

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
		ComposeMail composeMail = landingPage.loginToGmailAccount(emailId, password);
		Thread.sleep(6000);

		composeMail.composeToMail(toMailId, subjectText, bodyText);
		composeMail.selectSocialOpt();
		composeMail.clickOnSendOtp();
		composeMail.makeStarred();
		Thread.sleep(3000);
		String getsubjectText = composeMail.validateSubjectText();
		System.out.println(subjectText);
		Assert.assertEquals(getsubjectText, subjectText);
		Thread.sleep(3000);
		String getbodyText = composeMail.validateBodyText();
		System.out.println(bodyText);
		Assert.assertEquals(getbodyText, bodyText);

	}

}
