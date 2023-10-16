package stepDefinitions;

import configs.BaseConfigs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.appication.HomePage;

public class HomePageSteps extends BaseConfigs {

    HomePage homePage = new HomePage(driver, wait, actions);


    @Given("the User is on login page")
    public void the_user_is_on_login_page(){
        homePage.goToLogin();

    }

    @Then("the User can see homepage with correct login message")
    public void then_user_can_see_homepage_with_correct_login_message(){
        Assert.assertTrue(homePage.successMessageWithCorrectText("Logged In Sucessfully!!"), "Message is not visible");
    }

    @Given("the User is on registration page")
    public void the_user_is_on_registration_page() {
        homePage.goToRegistration();
    }
}
