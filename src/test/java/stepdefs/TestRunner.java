package stepdefs;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

import hooks.GlobalHooks;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features", glue= {"stepdefs"},
plugin = {"pretty","html:target/htmlreport"})
public class TestRunner {

	private static GlobalHooks globalHooks;
	
	@Before
	public static void setUp() {
		System.out.println("test runnnnnnnnnnnnnnnnnnnnnnn");
		globalHooks = new GlobalHooks();
		globalHooks.loadUrl();
	}
	
	@After
	public static void tear() {
		globalHooks.tearDown();
	}
}
