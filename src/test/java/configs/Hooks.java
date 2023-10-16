package configs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Hooks extends BaseConfigs{


    @Before
    public void setUp(){
        this.options = new ChromeOptions();
        this.options.addArguments("headless=new");
        this.options.addArguments("incognito");
        this.options.addArguments("window-size=1920,1080");
        this.driver = new ChromeDriver(options);
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(4));
        this.actions = new Actions(this.driver);
        driver.get("http://localhost:8000/");
    }


    @After
    public void clean(){
        this.driver.close();
    }
}
