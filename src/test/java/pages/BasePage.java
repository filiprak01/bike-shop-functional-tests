package pages;

import configs.BaseConfigs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterTest;

import java.time.Duration;

public class BasePage extends BaseConfigs {

    //this class is to hold all the common functionalities shared within pages


    protected WebDriver driver;
    protected WebDriverWait wait10s;
    protected WebDriverWait wait;
    protected WebDriverWait wait40s;
    protected WebDriverWait wait300s;
    protected Actions actions;


    public BasePage(WebDriver driver, WebDriverWait wait, Actions actions) {
        this.driver = driver;
        this.wait = wait;
        this.wait10s = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.wait40s = new WebDriverWait(driver, Duration.ofSeconds(40));
        this.wait300s = new WebDriverWait(driver, Duration.ofSeconds(300));
        this.actions = actions;
    }

    public void clickElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        actions.moveToElement(element).perform();
        //click method is also blocked by page loading
        element.click();

    }
    public void clickOptionElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        //click method is also blocked by page loading
        element.click();
    }
    public void clickElement(String xpath ){
        WebElement element = driver.findElement(By.xpath(xpath));
        clickElement(element);
    }
    public String getTextFromInput(WebElement inputElement){
        return inputElement.getAttribute("value");
    }
    public String getTextFromNonInput(WebElement nonInputElement){
        return nonInputElement.getAttribute("innerHTML");
    }


}
