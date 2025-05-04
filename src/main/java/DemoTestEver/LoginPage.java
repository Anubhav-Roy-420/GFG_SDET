package DemoTestEver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    private By userNameField = By.xpath("//input[@name = 'email']");
    private By passwordField = By.xpath("//input[@name = 'password']");
    private By submitButtonField = By.xpath("//button[@type = 'submit']");


    public LoginPage(WebDriver wd) {
        this.driver = wd;
    }

    public LoginPage hitTheUrl(String url) {
        driver.get(url);
        return this;
    }

    public LoginPage enterCreds(String username, String pwd)
    {
        driver.findElement(userNameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(pwd);
        return this;
    }

    public LoginPage submit()
    {
        driver.findElement(submitButtonField).click();
        return this;
    }
}
