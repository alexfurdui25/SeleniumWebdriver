package web.steps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
public class SignUpStepDefinition {
    @Steps
    SignUpSteps steps;
    @When("SignUp: I click personal and continue")
    public void click_personal_and_continue() {
        steps.click_personal();
        steps.click_continue_button();
    }
    @When("SignUp: I provide first name: (.*)$")
    public void provide_fname(String fname) {
        steps.input_first_name(fname);
    }
    @Then("SingUp: I see invalid first name error")
    public void invalid_email() {
        steps.verify_invalid_fname_error_displayed();
    }
}