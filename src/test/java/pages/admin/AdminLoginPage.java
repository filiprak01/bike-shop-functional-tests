package pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class AdminLoginPage extends BasePage {
    public AdminLoginPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }


    @FindBy(xpath = "//input[@name=\"username\"]")
    protected WebElement usernameInput;

    @FindBy(xpath = "//input[@name=\"password\"]")
    protected WebElement passwordInput;

    @FindBy(xpath = "//input[@value = \"Log in\"]")
    protected WebElement loginBtn;

    @FindBy(xpath = "//h1")
    protected WebElement loginPlaceholder;

    protected String errorMessageAlert = "//div[contains(@class, \"danger\")]";



    public void login(String username, String password){
        wait.until(ExpectedConditions.visibilityOf(loginPlaceholder));
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        clickElement(loginBtn);
    }
}

