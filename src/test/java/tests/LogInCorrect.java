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

public class LogInCorrect {

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
    public void logInCorrect(){
        driver.get("http://localhost:8000");
        homePage.goToLogin();
        String password = System.getProperty("password");
        String username = System.getProperty("username");
        loginPage.login(username , password);
        Assert.assertTrue(homePage.successMessageWithCorrectText("Logged In Sucessfully!!"), "Message is not visible");
        homePage.logout();
    }

    @AfterClass
    public void quit(){
        driver.quit();
    }
}
