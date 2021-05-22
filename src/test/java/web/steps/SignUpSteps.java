package web.steps;
import net.thucydides.core.annotations.Step;
import org.testng.Assert;
import web.pages.SignInPage;
import web.pages.SignUpPage;
public class SignUpSteps {
    SignUpPage signUp;
    @Step
    void click_personal() {
        signUp.personalRadioButton.click();
    }
    @Step
    void click_continue_button() {
        signUp.continueButton.click();
    }
    @Step
    void input_first_name(String fname) {
        signUp.input.clear();
        signUp.input.sendKeys(fname);
    }
    @Step
    void verify_invalid_fname_error_not_displayed() {
        Assert.assertEquals(signUp.invalidFieldValueError.size(), 0, "Element was wrongly displayed");
    }
    @Step
    void verify_invalid_fname_error_displayed() {
        Assert.assertEquals(signUp.invalidFieldValueError.size(), 1, "Error message not displayed");
    }
}