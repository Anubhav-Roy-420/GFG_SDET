package CucumberDemo;

import SauceDemo.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class stepdef {

    WebDriver cd;
    LoginPage lp;


    @Before("@login")
    public void setup() throws MalformedURLException {
        final Map<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        chromePrefs.put("profile.password_manager_leak_detection", false); // <======== This is the important one

        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
        cd = new RemoteWebDriver(new URL("http://192.168.29.87:4444"),chromeOptions);
        cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        lp=new LoginPage(cd);
    }

    @Given("the user opens the DemoTest Website")
    public void the_user_opens_the_demo_test_website() {
        lp.hitTheUrl("https://www.saucedemo.com/");
    }

    @When("The user enters userid and password")
    public void The_user_enters_userid_and_password()
    {
        lp.enterCreds("standard_user", "secret_sauce").submit();
    }
    @Then("The user is able to login to DemoTest successfully")
    public void The_user_is_able_to_login_to_DemoTest_successfully(){}
}
