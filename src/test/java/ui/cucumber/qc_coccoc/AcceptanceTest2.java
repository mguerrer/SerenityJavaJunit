package ui.cucumber.qc_coccoc;


import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/qcCocCoc/", tags = { "@pending" }, glue = { "ui.cucumber.qc_coccoc.step" })
public class AcceptanceTest2 {
}
