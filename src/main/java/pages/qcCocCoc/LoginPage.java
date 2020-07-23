package pages.qcCocCoc;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;


@DefaultUrl("https://cp.qc.coccoc.com/sign-in?lang=vi-VN")
public class LoginPage extends PageObject {

    @FindBy(name = "email")
    private WebElementFacade emailField;

    @FindBy(name = "password")
    private WebElementFacade passwordField;

    @FindBy(css = "button[data-track_event-action='Login']")
    private WebElementFacade btnLogin;

    @FindBy(xpath = "//form[@method='post'][not(@name)]//div[@class='form-errors clearfix']")
    private WebElementFacade errorMessageElement;

    public void login(String email, String password) {
        waitFor(emailField);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        btnLogin.click();
    }

    public String getMessageError(){
        waitFor(errorMessageElement);
        return errorMessageElement.getTextContent();
    }


}
