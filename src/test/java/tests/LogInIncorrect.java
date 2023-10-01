package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.appication.HomePage;
import pages.appication.LoginPage;

import java.time.Duration;

public class LogInIncorrect{


    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    protected HomePage homePage;
    protected LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("headless=new");
        options.addArguments("window-size=1920,1080");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        homePage = new HomePage(driver, wait, actions);
        loginPage = new LoginPage(driver, wait, actions);
        PageFactory.initElements(driver, this);
    }

    @Test
    public void incorrectLogin() {
        driver.get("http://localhost:8000");
        homePage.goToLogin();
        loginPage.login("bad_user", "TestPassword");
        Assert.assertTrue(loginPage.errorMessageWithCorrectText("Bad Credentials!!"), "Wrong or no error message");
        loginPage.login("user2", "wrong_password");
        Assert.assertTrue(loginPage.errorMessageWithCorrectText("Bad Credentials!!"), "Wrong or no error message");
    }

    @AfterClass
    public void close(){
        driver.quit();
    }
}
