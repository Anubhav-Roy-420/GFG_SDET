package DataDrivenTest;

import DemoTestEver.LoginPage;
import ExcelManagerPackage.ExcelManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DDTestClass {

    WebDriver cd;
    LoginPage lp;

    @BeforeMethod
    public void setup() throws MalformedURLException {

        ChromeOptions chromeOptions=new ChromeOptions();
        FirefoxOptions firefoxOptions=new FirefoxOptions();
        cd = new RemoteWebDriver(new URL("http://192.168.29.87:4444"),chromeOptions);
    }

    @AfterMethod
    public void teardown(){
        cd.quit();
    }




    @DataProvider(name = "ExcelData")
    public Object[][] getData() throws IOException {
        return ExcelManager.getData();
    }


    @Test(dataProvider = "ExcelData")
    public void Login(String username, String pwd)
    {
        lp=new LoginPage(cd);
        lp.hitTheUrl("https://demo.evershop.io/account/login").enterCreds(username, pwd).submit();
    }

}
