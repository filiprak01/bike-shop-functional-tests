package configs;

import org.testng.annotations.BeforeSuite;

public class BaseConfigs {


    @BeforeSuite
    public void setUp(){
        //Windows
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\java\\configs\\chromedriver.exe");
        //Linux + MACOS
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/java/configs/chromedriver");
    }
}
