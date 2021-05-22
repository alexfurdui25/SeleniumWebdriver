package web.pages;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.List;
public class SignUpPage extends PageObject  {
    @FindBy(xpath = "//span[@data-test-id='select-personal-radio-btn']")
    public WebElementFacade personalRadioButton;
    @FindBy(xpath = "//span[text()='CONTINUE']")
    public WebElementFacade continueButton;
    @FindBy(xpath = "//input")
    public WebElementFacade input;
    @FindBy(xpath = "//p[text()='invalid field value']")
    public List<WebElementFacade> invalidFieldValueError;
}