package web;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
// test runner, points to test locations by capability
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/signIn_capability/")
public class SignInCapabilityRunner {
}