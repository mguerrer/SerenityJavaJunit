package ui.cucumber.qc_coccoc.step;

import common.BaseTest;
import common.CoreConstant;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;


public class LoginPage extends BaseTest {

    @Steps
    private pages.qcCocCoc.LoginPage loginPage_pageobject;


    @cucumber.api.java.en.Given("^Navigate to quang cao coc coc login site$")
    public void navigateToQuangCaoCocCocLoginSite() {

        loginPage_pageobject.open();

    }

    @When("^Login with '(.*)' and '(.*)'$")
    public void loginWithEmailAndPassword(String email, String password) {

        loginPage_pageobject.login(email,password);

    }

    @Then("^Should navigate to home page site$")
    public void shouldNavigateToHomePageSite() {
        WebDriverWait wait = new WebDriverWait(getDriver(),2);
        wait.until(ExpectedConditions.urlContains("welcome"));
        softAssertImpl.assertAll();

    }

    @Then("^Should prompt with '(.*)'$")
    public void shouldPromptWithErrormessage(String errorMessage) {

        softAssertImpl.assertThat("Verify message error",loginPage_pageobject.getMessageError().contains(errorMessage),true);
        softAssertImpl.assertAll();

    }
}
