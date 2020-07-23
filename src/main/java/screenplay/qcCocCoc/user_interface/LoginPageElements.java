package screenplay.qcCocCoc.user_interface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPageElements {

    public static Target EMAIL_FIELD    =  Target.the("email field")
            .located(By.name("email"));

    public static Target
            PASSWORD_FIELD = Target.the("password field")
            .located(By.name("password"));

    public static Target BTN_LOGIN = Target.the("btn login")
            .located(By.cssSelector("button[data-track_event-action='Login']"));

    public static Target ERROR_MESSAGE_ELEMENT   = Target.the("error message element")
            .located(By.xpath("//form[@method='post'][not(@name)]//div[@class='form-errors clearfix']"));



}
