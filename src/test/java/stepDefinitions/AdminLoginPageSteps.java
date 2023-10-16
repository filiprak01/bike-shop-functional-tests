package stepDefinitions;

import configs.BaseConfigs;
import io.cucumber.java.en.Given;
import pages.admin.AdminLoginPage;

public class AdminLoginPageSteps extends BaseConfigs {


    AdminLoginPage adminLoginPage = new AdminLoginPage(driver, wait, actions);
    @Given("the User is logged into admin Panel")
    public void the_user_is_logged_into_admin_panel() {
        driver.get("http://localhost:8000/admin");
        adminLoginPage.fillCredentials("admin", "admin");
        adminLoginPage.clickLoginBtn();
    }

}
