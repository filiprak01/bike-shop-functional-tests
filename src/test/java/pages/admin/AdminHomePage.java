package pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class AdminHomePage extends BasePage {
    public AdminHomePage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[@id=\"site-name\"]")
    protected WebElement pagePlaceHolder;

    @FindBy(xpath = "//th//a[@href=\"/admin/auth/user/\"]")
    protected WebElement userBtn;

    @FindBy(xpath = "//a[@href = \"/admin/logout/\"]")
    protected WebElement logoutBtn;

    protected String errorMessageAlert = "//div[contains(@class, \"danger\")]";


    public void goToUserTab(){
        wait.until(ExpectedConditions.visibilityOf(pagePlaceHolder));
        clickElement(userBtn);
    }
    public void logout(){
        clickElement(logoutBtn);
    }

}
