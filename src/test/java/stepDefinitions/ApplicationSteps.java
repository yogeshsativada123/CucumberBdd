package stepDefinitions;

import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.ApplicationPage;


public class ApplicationSteps extends BaseTest {
	private ApplicationPage applicationPage;
	
	@Given("User should land on application Page")
    public void userShouldLandOnApplicationPage() throws Exception {
		applicationPage = new ApplicationPage(driver);
    }
	
	@When("User should click on SignUp and Enter Deatils")
	public void userShouldClickOnSignupAndEnterDeatils() {
		applicationPage.userClickOnSignupAndEnterDeatils();
	}

}
