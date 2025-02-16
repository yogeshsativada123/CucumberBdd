package baseRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature/",
        glue = "src/test/java/stepDefinitions",
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        tags = "@sample" )

public class TestRuunner {

	public static void main(String[] args) {
		
	}

}
