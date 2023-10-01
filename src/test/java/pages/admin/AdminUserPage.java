package pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.util.List;

public class AdminUserPage extends BasePage {
    public AdminUserPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    @FindBy(xpath = "//select")
    protected WebElement dropdownUserActionMenu;

    @FindBy(xpath = "//option[@value=\"delete_selected\"]")
    protected WebElement deleteUserOptions;

    @FindBy(xpath = "//button[@name=\"index\"]")
    protected WebElement performActionBtn;

    @FindBy(xpath = "//th/a[contains(@href, \"change\")]")
    protected List<WebElement> userLabels;

    @FindBy(xpath = "//input[@type=\"checkbox\"]")
    protected List<WebElement> checkboxes;

    protected String successMessageAlert = "//li[@class = \"success\"]";

    protected String confirmActionBtn = "//input[contains(@value, \"sure\")]";

    protected String errorMessageAlert = "//div[contains(@class, \"danger\")]";


    public boolean deleteUser(String name)throws InterruptedException{
        int index = 0;
        boolean found = false;
        for(index = 0; index < userLabels.size(); index++ ){
            if(getTextFromNonInput(userLabels.get(index)).compareToIgnoreCase(name) == 0){
                found = true;
                break;
            }
        }
        if(found){
            //user have been found
            clickElement(checkboxes.get(index+1));
            clickElement(dropdownUserActionMenu);
            clickOptionElement(deleteUserOptions);
            clickElement(performActionBtn);
            clickElement(confirmActionBtn);
            return true;
        }
        //user was not found
        return false;
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
}
