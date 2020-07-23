package ui.cucumber.facebook;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/facebook/", tags = { "@Login" }, glue = { "ui.cucumber.facebook.step" })
public class AcceptanceTest {
}
