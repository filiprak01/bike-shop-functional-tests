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
import pages.appication.HomePage;
import pages.appication.LoginPage;
import pages.appication.RegistrationPage;

import java.time.Duration;

public class RegisterCorrect {


    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    protected HomePage homePage;
    protected RegistrationPage registrationPage;
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
        registrationPage = new RegistrationPage(driver, wait, actions);
        PageFactory.initElements(driver, this);
    }

    @Test
    public void incorrectLogin() {
        driver.get("http://localhost:8000");
        homePage.goToRegistration();
        registrationPage.register("test", "123456789", "test@test.pl", "NewPassword", "NewPassword");
        Assert.assertTrue(loginPage.successMessageWithCorrectText("Your Account has been created succesfully!! Please check your email to confirm your email address in order to activate your account."));
    }

    @AfterClass
    public void close(){
        driver.quit();
    }
}
