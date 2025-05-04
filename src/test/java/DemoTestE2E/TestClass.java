package DemoTestE2E;

import DemoTestEver.HomePage;
import DemoTestEver.LoginPage;
import DemoTestEver.ProductPage;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TestClass {

    LoginPage lp;
    LoginPage lp1;
    HomePage hp;
    HomePage hp1;
    WebDriver cd;
    ProductPage pg;
    ProductPage pg1;
    WebDriver cd1;

    @BeforeTest
    public void setup() throws MalformedURLException {

        ChromeOptions chromeOptions=new ChromeOptions();
        FirefoxOptions firefoxOptions=new FirefoxOptions();
        cd = new RemoteWebDriver(new URL("http://192.168.29.87:4444"),chromeOptions);
        cd1 = new RemoteWebDriver(new URL("http://192.168.29.87:4444"),chromeOptions);
        //cd1 = new RemoteWebDriver(new URL("http://192.168.29.87:4444"),firefoxOptions);
    }

//    @AfterTest
//    public void teardown()
//    {
//        cd.quit();
//    }

    @DataProvider(name = "dp")
    public String[] readJson() throws IOException, ParseException {
        JSONParser jp= new JSONParser();
        FileReader f= new FileReader(".\\Login.json");
        Object obj=jp.parse(f);
        JSONObject jobj= (JSONObject) obj;
        String[] str=new String[1];
        str[0]=(String)((JSONObject)jobj.get("Credentials")).get("username") + "," + (String)((JSONObject)jobj.get("Credentials")).get("password")
                + "," + (String)((JSONObject)jobj.get("Credentials")).get("login");
        return str;

    }

    @Test(dataProvider = "dp", priority = 1)
    public void initiate(String data) throws InterruptedException {
        String[] creds=data.split(",");
        lp=new LoginPage(cd);
        System.out.println(lp);
        hp=new HomePage(cd);
        pg=new ProductPage(cd);
        lp.hitTheUrl(creds[2]).
                enterCreds(creds[0],creds[1]).submit();
        cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        hp.clickProduct("Nike react infinity run flyknit");
        pg.addSize("\"L\"").addColor("\"Black\"").addQty("2");

    }



    @Test(dataProvider = "dp", priority = 2)
    public void initiate1(String data) throws InterruptedException {
        String[] creds=data.split(",");
        lp1=new LoginPage(cd1);
        hp1=new HomePage(cd1);
        pg1=new ProductPage(cd1);
        lp1.hitTheUrl(creds[2]).
                enterCreds(creds[0],creds[1]).submit();
        cd1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        hp1.clickProduct("Nike react infinity run flyknit");
        pg1.addSize("\"L\"").addColor("\"Black\"").addQty("0.5");

    }

    /*@Test(priority = 2)
    public void initiateFirefox() throws MalformedURLException, InterruptedException {

        LoginPage lp1=new LoginPage(cd1);
        HomePage hp1=new HomePage(cd1);
        lp1.hitTheUrl("https://demo.evershop.io/account/login").
                enterCreds("akhiljda@gmail.com","Password").submit();
        Thread.sleep(3000);
        hp1.clickProduct(By.xpath("//*[@id=\"app\"]/div/main/div[3]/div/div/div[3]/div[2]/a/span"));

    }

     */
}
