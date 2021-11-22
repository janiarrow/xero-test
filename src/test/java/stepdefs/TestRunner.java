package stepdefs;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features/", glue= {"stepdefs"},
monochrome = true,
plugin = {"pretty","html:target/htmlreport"})
public class TestRunner {

}