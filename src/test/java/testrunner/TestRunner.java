package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features", 
    glue = "stepDefinitions", 
    plugin = {
        "pretty", 
        "html:target/cucumber-reports.html", 
        "json:target/cucumber-reports.json" 
    },
    monochrome = true, 
    tags = "@hotelBooking" 
)
public class TestRunner extends AbstractTestNGCucumberTests {
    
}

