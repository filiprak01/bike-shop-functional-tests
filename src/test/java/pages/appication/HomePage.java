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

public class HomePage extends BasePage {

    public HomePage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href = \"/login\"]")
    protected WebElement loginBtn;

    @FindBy(xpath = "//a[@href = \"/register\"]")
    protected WebElement registerBtn;


    @FindBy(xpath = "//a[@href=\"/logout\"]")
    protected WebElement logoutBtn;



    protected String successMessageAlert = "//div[contains(@class, \"success\")]";



    public void goToLogin(){
        clickElement(loginBtn);
    }
    public boolean successMessageWithCorrectText(String text){
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(successMessageAlert)));
            return getTextFromNonInput(driver.findElement(By.xpath(successMessageAlert))).
                    trim().
                    strip().
                    compareToIgnoreCase(text) == 0;
        }catch (TimeoutException e){
            return false;
        }
    }
    public void logout(){
        clickElement(logoutBtn);
    }
    public void goToRegistration(){
        clickElement(registerBtn);
    }
}
