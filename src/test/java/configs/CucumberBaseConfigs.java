package configs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CucumberBaseConfigs {
    public static WebDriver driver;
    public ChromeOptions chromeOptions;


    public void setUp(){
        //Windows
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\java\\configs\\chromedriver.exe");
        //Linux + MACOS
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/java/configs/chromedriver");
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("headless=new");
        chromeOptions.addArguments("incognito", "windows-size=1920,1080", "disable-gpu");
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://localhost:8000/");
    }

}
