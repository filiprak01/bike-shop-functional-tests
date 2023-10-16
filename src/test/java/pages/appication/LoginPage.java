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

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1")
    protected WebElement loginPlaceholder;

    @FindBy(xpath = "//input[@id = \"username\"]")
    protected WebElement usernameInput;

    @FindBy(xpath = "//input[@id = \"password\"]")
    protected WebElement passwordInput;

    @FindBy(xpath = "//button[@form = \"form\"]")
    protected WebElement signInBtn;

    protected String errorMessageAlert = "//div[contains(@class, \"danger\")]";
    protected String successMessageAlert = "//div[contains(@class, \"success\")]";

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
    public boolean successMessageWithCorrectText(String text){
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(successMessageAlert)));
            return getTextFromNonInput(driver.findElement(By.xpath(successMessageAlert))).
                    strip().
                    trim().
                    compareToIgnoreCase(text) == 0;
        }catch(TimeoutException e){
            return false;
        }
    }

    public void login(String username, String password){
        wait.until(ExpectedConditions.visibilityOf(loginPlaceholder));
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        clickElement(signInBtn);
    }
    public void enterCredentials(String username, String password){
        wait.until(ExpectedConditions.visibilityOf(loginPlaceholder));
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
    }

    public void clickLoginBtn(){
        clickElement(signInBtn);
    }
}
