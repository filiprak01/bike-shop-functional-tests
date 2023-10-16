package stepDefinitions;

import configs.BaseConfigs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.admin.AdminUserPage;

public class AdminUserPageSteps extends BaseConfigs {

    AdminUserPage adminUserPage = new AdminUserPage(driver, wait, actions);


    @Given("user with {word} exists")
    public void user_with_test_exists(String name) {
        Assert.assertTrue(adminUserPage.doesUserExist(name));
    }
    @When("removing user with {word}")
    public void removing_user_with_test(String name) {
        adminUserPage.deleteUser(name);
    }
    @Then("the user removed successfully message is displayed")
    public void the_user_removed_successfully_message_is_displayed() {
        Assert.assertTrue(adminUserPage.successMessageWithCorrectText("Successfully deleted 1 user."));
    }
}
