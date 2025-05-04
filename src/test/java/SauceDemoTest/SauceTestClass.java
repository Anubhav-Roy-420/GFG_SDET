package SauceDemoTest;

import SauceDemo.*;
import SeleniumBasics.Util;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class SauceTestClass {

    LoginPage lp;
    CataloguePage cp;
    ProductDetailsPage pp;
    WebDriver cd;
    CartPage ctp;
    YourInfoPage yp;
    Util ut;
    FinalCheckoutPage fcp;
    EndPage ep;

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

    @Test
    public void initiate()
    {
        lp=new LoginPage(cd);
        cp=new CataloguePage(cd);
        ctp=new CartPage(cd);
        fcp=new FinalCheckoutPage(cd);
        ep=new EndPage(cd);
        lp.hitTheUrl("https://www.saucedemo.com/").
                enterCreds("standard_user","secret_sauce").
                submit();
        ut.Delay(2);
        cp.clickProduct("Sauce Labs Backpack");
        ut.Delay(2);
        pp=new ProductDetailsPage(cd);
        pp.addToCart().goToCart();
        ctp.checkoutClick();
        yp=new YourInfoPage(cd);
        yp.enterInfo("Test","QA","12345").clickContinue();
        fcp.finishOrder();
        ep.backToHomePage();
    }
}
