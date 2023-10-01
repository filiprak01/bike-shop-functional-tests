package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.admin.AdminHomePage;
import pages.admin.AdminLoginPage;
import pages.admin.AdminUserPage;
import pages.appication.HomePage;
import pages.appication.RegistrationPage;

import java.time.Duration;

public class RemoveAccount {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    protected AdminHomePage adminHomePage;
    protected AdminLoginPage adminLoginPage;
    protected AdminUserPage adminUserPage;


    @BeforeClass
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("headless=new");
        options.addArguments("window-size=1920,1080");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        adminHomePage = new AdminHomePage(driver, wait, actions);
        adminLoginPage = new AdminLoginPage(driver, wait, actions);
        adminUserPage = new AdminUserPage(driver, wait, actions);
        PageFactory.initElements(driver, this);
    }

    @Test
    public void logInCorrect() throws InterruptedException{
        driver.get("http://localhost:8000/admin/login");
        adminLoginPage.login("admin", "admin");
        adminHomePage.goToUserTab();
        adminUserPage.deleteUser("test");
        Assert.assertTrue(adminUserPage.successMessageWithCorrectText("Successfully deleted 1 user."));
        adminHomePage.logout();
    }

    @AfterClass
    public void quit(){
        driver.quit();
    }
}
