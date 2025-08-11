package runner;

import io.cucumber.testng.CucumberOptions;
import stepdefinition.SalesforceBase;


@CucumberOptions(features = "src/test/java/feature/", glue = "stepdefinition", publish = true)
public class CucumberRunner extends SalesforceBase {

}
