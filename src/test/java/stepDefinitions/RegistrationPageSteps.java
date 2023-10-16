package stepDefinitions;

import configs.BaseConfigs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.appication.RegistrationPage;

public class RegistrationPageSteps extends BaseConfigs {

    RegistrationPage registrationPage = new RegistrationPage(driver,wait,actions);


    @Given("the User enters {word}, {word}, {word}, {word}, {word}")
    public void the_user_enters_registration_credentials(String username, String email, String phoneNumber,
                                                         String password, String passwordConfirmation){
        registrationPage.enter_registration_credentials(username, email, phoneNumber, password, passwordConfirmation);
    }

    @When("the User is trying to register")
    public void the_user_is_trying_to_register() {
        registrationPage.click_registration_btn();
    }
    @Then("the <error> message is displayed")
    public void the_username_already_exist_please_try_some_other_username_message_is_displayed(String message) {
        Assert.assertTrue(registrationPage.errorMessageWithCorrectText(message));
    }

    @Then("the {word} message is displayed")
    public void theErrorMessageIsDisplayed(String message) {

    }
    @Then("the Username already exist! Please try some other username. message should be displayed")
    public void the_username_already_exist_please_try_some_other_username_message_should_be_displayed() {
        Assert.assertTrue(registrationPage.errorMessageWithCorrectText("Username already exist! Please try some other username."));
    }
    @Then("the Passwords didn't match!! message should be displayed")
    public void the_passwords_didn_t_match_message_should_be_displayed() {
        Assert.assertTrue(registrationPage.errorMessageWithCorrectText("Passwords didn't match!!"));
    }
    @Then("the Email Already Registered!! message should be displayed")
    public void the_email_already_registered_message_should_be_displayed() {
        Assert.assertTrue(registrationPage.errorMessageWithCorrectText("Email Already Registered!!"));
    }
}
