package ui.cucumber.facebook.step;

import common.BaseTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class LoginPage extends BaseTest {

    @Steps
    private pages.facebook.LoginPage loginPage_facebook;

    @Given("^Navigate to facebook login page$")
    public void navigateToFacebookLoginPage() {

        loginPage_facebook.navigate();

    }


    @When("^Login facebook with '(.*)' and '(.*)'$")
    public void loginFacebookWithPhoneAndPassword(String phone, String password) {

        loginPage_facebook.login(phone,password);

    }

    @Then("^Should navigate to facebook homepage$")
    public void shouldNavigateToFacebookHomepage() {

        WebDriverWait wait = new WebDriverWait(getDriver(),2);
        wait.until(ExpectedConditions.not(ExpectedConditions.urlContains("login")));
        softAssertImpl.assertAll();

    }
}
