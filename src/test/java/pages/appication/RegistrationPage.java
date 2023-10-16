package pages.appication;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id = \"username\"]")
    protected WebElement usernameInput;

    @FindBy(xpath = "//input[@id = \"phone_num\"]")
    protected WebElement phoneNumberInput;

    @FindBy(xpath = "//input[@id = \"email\"]")
    protected WebElement emailInput;

    @FindBy(xpath = "//input[@id = \"pass1\"]")
    protected WebElement passwordInput;

    @FindBy(xpath = "//input[@id = \"pass2\"]")
    protected WebElement passwordInputConfirmation;

    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block mb-4\"]")
    protected WebElement registerButton;

    @FindBy(xpath = "//h1")
    protected WebElement registrationPlaceholder;

    protected String errorMessageAlert = "//div[contains(@class, \"danger\")]";
    protected String successMessageAlert = "//div[contains(@class, \"success\")]";

    public void register(String username, String phoneNumber, String email, String password, String passwordConfirmation){
        wait.until(ExpectedConditions.visibilityOf(registrationPlaceholder));
        usernameInput.sendKeys(username);
        phoneNumberInput.sendKeys(phoneNumber);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        passwordInputConfirmation.sendKeys(passwordConfirmation);
    }
    public void enter_registration_credentials(String username, String email, String phoneNumber, String password, String passwordConfirmation){
        wait.until(ExpectedConditions.visibilityOf(registrationPlaceholder));
        usernameInput.sendKeys(username);
        phoneNumberInput.sendKeys(phoneNumber);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        passwordInputConfirmation.sendKeys(passwordConfirmation);
    }
    public void click_registration_btn(){
        clickElement(registerButton);
    }

    public boolean errorMessageWithCorrectText(String text){
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(errorMessageAlert)));
            return getTextFromNonInput(driver.findElement(By.xpath(errorMessageAlert))).
                    strip().
                    trim().
                    compareToIgnoreCase(text) == 0;
        }catch(TimeoutException e){
            return false;
        }
    }
}
