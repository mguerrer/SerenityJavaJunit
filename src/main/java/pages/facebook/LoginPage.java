package pages.facebook;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import static common.CoreConstant.FACEBOOK_URL_LOGIN;

@DefaultUrl("https://www.facebook.com/login")
public class LoginPage extends PageObject {

    @FindBy(name = "email")
    private WebElementFacade emailField;

    @FindBy(name = "pass")
    private WebElementFacade passwordField;

    @FindBy(name = "login")
    private WebElementFacade btnLogin;

    public void navigate(){
        getDriver().get(FACEBOOK_URL_LOGIN);
    }

    public void login(String email, String password) {
        waitFor(emailField);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        btnLogin.click();
    }

}
