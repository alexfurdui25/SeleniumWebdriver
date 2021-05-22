package web.steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
// agregare de pasi
public class SignInStepDefinition {
    @Steps
    SignInSteps steps;
    @Given("SignIn: I am a user on sign in page")
    public void open_sign_in_page() {
        steps.open_signIn_page();
    }
    @Given("SignIn: I click sign up link")
    public void click_sign_up_link() {
        steps.click_sign_up_link();
    }
    @When("SignIn: I provide wrong credentials and click Log In button")
    public void provide_wrong_credentials() {
        steps.complete_email_input("whatever@gmail.com");
        steps.complete_pass_input("wrongpass");
        steps.click_log_in_button();
    }
    @When("SignIn: I provide email: (.*)$")
    public void provide_email(String email) {
        steps.complete_email_input(email);
    }
    @Then("SingIn: I see invalid credentials error")
    public void invalid_credentials() {
        steps.verify_invalid_credentials_error();
    }
    @Then("SingIn: I see invalid email error")
    public void invalid_email() {
        steps.verify_invalid_email_error_displayed();
    }
    @Then("SingIn: I do not see invalid email error anymore")
    public void invalid_email_not_displayed() {
        steps.verify_invalid_email_error_not_displayed();
    }
}