package stepDefinitions;

import configs.BaseConfigs;
import io.cucumber.java.en.Given;
import pages.admin.AdminHomePage;

public class AdminHomePageSteps extends BaseConfigs {

    AdminHomePage adminHomePage = new AdminHomePage(driver, wait, actions);

    @Given("the User is on admin user Panel")
    public void the_user_is_on_admin_user_panel() {
        adminHomePage.goToUserTab();
    }
}
