package testRunner;

import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
		
        features = ".//Features/Login.feature",
        glue = "stepDefinitions",
        monochrome = true,
        plugin = {"pretty","html:target/cucumber-reports/Login Report.html"} // Extent Report plugin
)

public class TafeTestRunner {

}
