package ParallelDemo;

import OnlyDemo.ClickBtn;
import OnlyDemo.EnterText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class OnlyTest {

    ClickBtn btn;
    EnterText tx;
    WebDriver cd;

    @BeforeTest
    public void setup() throws MalformedURLException {

        ChromeOptions chromeOptions=new ChromeOptions();
        FirefoxOptions firefoxOptions=new FirefoxOptions();
        cd = new RemoteWebDriver(new URL("http://192.168.29.87:4444"),chromeOptions);
        cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void init(){
        btn=new ClickBtn(cd);
        btn.hitTheUrl("https://only-testing-blog.blogspot.com/").clickbtn();
    }

    @Test(priority = 2)
    public void type()
    {
        tx=new EnterText(cd);
        tx.enter("Hello Test Complete");
    }

}
