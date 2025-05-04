package ParallelDemo;

import OnlyDemo.ClickBtn;
import OnlyDemo.DropdownSelect;
import OnlyDemo.EnterText;
import SeleniumBasics.ThreadLocalClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class OnlyTestMethodParallel {

    ClickBtn btn;
    EnterText tx;
    DropdownSelect ds;
    WebDriver cd;

    @BeforeMethod
    public void setup() throws MalformedURLException {

        ChromeOptions chromeOptions=new ChromeOptions();
        cd = new RemoteWebDriver(new URL("http://192.168.29.87:4444"),chromeOptions);
        ThreadLocalClass.setTl(cd);
        cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void init(){
      //  ThreadLocalClass.getTl();
        btn=new ClickBtn(ThreadLocalClass.getTl());
        btn.hitTheUrl("https://only-testing-blog.blogspot.com/").clickbtn();
    }

    @Test
    public void type()
    {
       // ThreadLocalClass.getTl();
        tx=new EnterText(ThreadLocalClass.getTl());
        tx.hitTheUrl("https://only-testing-blog.blogspot.com/").enter("Hello Test Complete");
    }

    @Test
    public void drpsel()
    {
       // ThreadLocalClass.getTl();
        ds=new DropdownSelect(ThreadLocalClass.getTl());
        ds.hitTheUrl("https://only-testing-blog.blogspot.com/").drpselect();
    }

}
