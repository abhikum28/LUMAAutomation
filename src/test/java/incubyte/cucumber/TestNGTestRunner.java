package incubyte.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/java/incubyte/cucumber", glue = "incubyte.stepdefinitions",
monochrome = true)
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}
