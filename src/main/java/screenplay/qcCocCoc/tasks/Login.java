package screenplay.qcCocCoc.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.thucydides.core.annotations.Step;
import screenplay.qcCocCoc.actions.Navigate;
import screenplay.qcCocCoc.user_interface.LoginPageElements;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {

    private final String email_text;
    private final String password_text;

    @Step("{0} Login with email '#email_text' and password '#password_text'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Navigate.theRightPlace(),
                Click.on(LoginPageElements.EMAIL_FIELD),
                SendKeys.of(email_text).into(LoginPageElements.EMAIL_FIELD),
                Click.on(LoginPageElements.PASSWORD_FIELD),
                SendKeys.of(password_text).into(LoginPageElements.PASSWORD_FIELD),
                Click.on(LoginPageElements.BTN_LOGIN)
                );

    }

    public Login(String email_text, String password_text){
        this.email_text = email_text;
        this.password_text = password_text;

    }



    public static Login loginThePage(String email_text, String password_text) {
        return instrumented(Login.class
        ,email_text,password_text);
    }

}
