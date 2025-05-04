package ParallelDemo;

import SauceDemo.*;
import SeleniumBasics.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class SauceDemoTest {
    LoginPage lp;
    CataloguePage cp;
    Util ut;
    WebDriver cd;


    @BeforeTest
    public void setup() throws MalformedURLException {


        final Map<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        chromePrefs.put("profile.password_manager_leak_detection", false); // <======== This is the important one

        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
        cd = new RemoteWebDriver(new URL("http://192.168.29.87:4444"),chromeOptions);
        cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ut=new Util(cd);
    }

    @Test(priority = 1)
    public void initiate() {
        lp = new LoginPage(cd);
        lp.hitTheUrl("https://www.saucedemo.com/").
                enterCreds("standard_user", "secret_sauce").
                submit();
        ut.Delay(2);

    }

    @Test(priority = 2)
    public void clickProduct(){
        cp = new CataloguePage(cd);
        cp.clickProduct("Sauce Labs Backpack");
    }
}
