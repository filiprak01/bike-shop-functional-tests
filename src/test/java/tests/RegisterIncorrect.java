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

public class RegisterIncorrect {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    protected HomePage homePage;
    protected RegistrationPage registrationPage;



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
        registrationPage = new RegistrationPage(driver, wait, actions);
        PageFactory.initElements(driver, this);
    }

    @Test
    public void logInCorrect(){
        driver.get("http://localhost:8000");
        homePage.goToRegistration();
        //user with existing username
        registrationPage.register("user2", "123456789", "test@test.pl", "NewPassword", "NewPassword");
        Assert.assertTrue(registrationPage.errorMessageWithCorrectText("Username already exist! Please try some other username."));
        homePage.goToRegistration();
        //not matching passwords
        registrationPage.register("test2", "123456789", "test123@test.com", "Password", "NewPassword");
        Assert.assertTrue(registrationPage.errorMessageWithCorrectText("Passwords didn't match!!"));
        //existing email
        homePage.goToRegistration();
        registrationPage.register("test2", "123456789", "filip.rak.20001@gmail.com", "NewPassword", "NewPassword");
        Assert.assertTrue(registrationPage.errorMessageWithCorrectText("Email Already Registered!!"));
    }

    @AfterClass
    public void quit(){
        driver.quit();
    }
}
