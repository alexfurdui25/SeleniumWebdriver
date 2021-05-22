package web.pages;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.List;
// toate elementele identificate; dintr-o anumita pagina
public class SignInPage extends PageObject {
    @FindBy(xpath = "//input[@placeholder='Enter your email']")
    public WebElementFacade emailInput;
    @FindBy(xpath = "//input[@placeholder='Enter your password']")
    public WebElementFacade passInput;
    @FindBy(xpath = "//span[text()='Log in']/parent::button")
    public WebElementFacade logInButton;
    @FindBy(xpath = "//span[text()='Invalid email/password combination']")
    public WebElementFacade invalidCredentialsError;
    @FindBy(xpath = "//p[text()='Please enter a valid email address!']")
    public List<WebElementFacade> invalidEmailError;
    @FindBy(xpath = "//a[@data-test-id='sign-up-link']")
    public WebElementFacade signUpLink;
}