package ParallelDemo;

import DemoTestEver.HomePage;
import DemoTestEver.LoginPage;
import DemoTestEver.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class EvershopTest {

    LoginPage lp;
    HomePage hp;
    WebDriver cd;


    @BeforeTest
    public void setup() throws MalformedURLException {

        ChromeOptions chromeOptions=new ChromeOptions();
        FirefoxOptions firefoxOptions=new FirefoxOptions();
        cd = new RemoteWebDriver(new URL("http://192.168.29.87:4444"),chromeOptions);
        cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void initiate() throws InterruptedException {
        lp = new LoginPage(cd);
        lp.hitTheUrl("https://demo.evershop.io/account/login").
                enterCreds("akhiljda@gmail.com","Password").submit();

    }

    @Test(priority = 2)
    public void clickPdct(){
        hp = new HomePage(cd);
        hp.clickProduct("Nike react infinity run flyknit");
    }
}
