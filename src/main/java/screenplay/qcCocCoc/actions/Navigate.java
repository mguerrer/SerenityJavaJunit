package screenplay.qcCocCoc.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;
import screenplay.qcCocCoc.user_interface.LoginPage;

public class Navigate implements Performable {

    public static Performable theRightPlace() {
        return new Navigate();

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(LoginPage.class)
        );

    }

}
