package configs;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

public class BaseConfigs {

    public static ChromeDriver driver;
    protected static ChromeOptions options;
    public static WebDriverWait wait;
    public static Actions actions;
    @BeforeSuite
    public void setUp(){
        //Windows
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\java\\configs\\chromedriver.exe");
        //Linux + MACOS
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/java/configs/chromedriver");
    }
}
