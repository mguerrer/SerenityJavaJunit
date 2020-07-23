package ui.screenplay.qc_coccoc;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import screenplay.qcCocCoc.questions.CurrentUrl;
import screenplay.qcCocCoc.tasks.Login;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.containsString;

@RunWith(SerenityRunner.class)
public class LoginPage {

    private Actor donald = Actor.named("Donald");


    @Managed(uniqueSession = true)
    private WebDriver hisBrowser;

    @Before
    public void annaCanBrowseTheWeb() {
        donald.can(BrowseTheWeb.with(hisBrowser));
    }

    @Test
    public void login_with_correct_credential() {

        givenThat(donald).wasAbleTo(Login.loginThePage("Ledinhcuong99@gmail.com",
                "Test11011990"));
        then(donald).should(seeThat(CurrentUrl.information(),containsString("welcome")));
    }

}
