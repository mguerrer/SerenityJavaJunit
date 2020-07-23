package pages.qcCocCoc;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class HomePage extends PageObject {


    @FindBy(xpath = "//a[@data-track_event-action='Click to open']")
    WebElementFacade pageHeader;

    public void check_navigated(){

    }



}
