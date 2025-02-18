package stepDefinitions;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	@Before
    public void setUp(Scenario scenario) {
        System.out.println("Executing scenario: " + scenario.getName());
        BaseTest.initializeDriver(); // Start browser before each scenario
    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println("Finished scenario: " + scenario.getName());
        BaseTest.tearDown(); // Close browser after each scenario
    }
}
