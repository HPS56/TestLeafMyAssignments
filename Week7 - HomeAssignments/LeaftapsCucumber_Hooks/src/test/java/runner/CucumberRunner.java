package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/*
 * Runner Class using TestNG abstract to run the test from cucumber feature files
 */

@CucumberOptions(features = "src/test/resources/features/", glue = "stepdefinition",publish = true)
public class CucumberRunner extends AbstractTestNGCucumberTests{

}
