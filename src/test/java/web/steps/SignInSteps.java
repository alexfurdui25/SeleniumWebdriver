package web.steps;
import net.serenitybdd.core.exceptions.SerenityManagedException;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.webdriver.exceptions.ElementNotFoundAfterTimeoutError;
import org.testng.Assert;
import web.pages.SignInPage;
// definim cei mai mici pasi ce ii poate face un user pe o pagina (interactionand cu elementele din ea)
public class SignInSteps {
    SignInPage signIn;
    @Step
    void open_signIn_page() {
        signIn.open();
    }
    @Step
    void complete_email_input(String email){
        signIn.emailInput.waitUntilVisible();
        signIn.emailInput.clear();
        signIn.emailInput.sendKeys(email);
    }
    @Step
    void complete_pass_input(String pass){
        signIn.passInput.waitUntilVisible();
        signIn.passInput.clear();
        signIn.passInput.sendKeys(pass);
    }
    @Step
    void click_log_in_button() {
        signIn.logInButton.waitUntilClickable();
        signIn.logInButton.submit();
    }
    @Step
    void click_sign_up_link() {
        signIn.signUpLink.waitUntilClickable();
        signIn.signUpLink.click();
    }
    @Step
    void verify_invalid_email_error_not_displayed() {
        Assert.assertEquals(signIn.invalidEmailError.size(), 0, "Element was wrongly displayed");
    }
    @Step
    void verify_invalid_email_error_displayed() {
        Assert.assertEquals(signIn.invalidEmailError.size(), 1, "Error message not displayed");
    }
    @Step
    void verify_invalid_credentials_error() {
        Assert.assertTrue(signIn.invalidCredentialsError.isDisplayed());
    }
}