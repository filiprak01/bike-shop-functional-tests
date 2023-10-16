package stepDefinitions;


import configs.BaseConfigs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.appication.HomePage;
import pages.appication.LoginPage;

import static configs.Hooks.*;

public class LoginPageSteps extends BaseConfigs {

    LoginPage loginPage = new LoginPage(driver,wait,actions);


    @Given("the User entered {word} and {word}")
    public void user_entered_username_and_password(String username, String password){
        loginPage.enterCredentials(username, password);
    }
    @When("the User is trying to login")
    public void the_user_is_trying_to_login(){
        loginPage.clickLoginBtn();
    }

    @Then("the User can see login page with incorrect login message")
    public void the_user_can_see_login_page_with_incorrect_login_message(){
        Assert.assertTrue(loginPage.errorMessageWithCorrectText("Bad Credentials!!"), "Wrong or no error message");
    }
    @Then("the account creation message is displayed")
    public void the_account_creation_message_is_displayed() {
        Assert.assertTrue(loginPage.successMessageWithCorrectText("Your Account has been created succesfully!!" +
                " Please check your email to confirm your email address in order to activate your account."));
    }
}
