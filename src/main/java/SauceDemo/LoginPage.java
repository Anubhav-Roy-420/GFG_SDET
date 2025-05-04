package SauceDemo;

import SeleniumBasics.Util;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver cd;
    Util ut;
    WebDriverWait wait;
    private By userNameField = By.xpath("//input[@name = 'user-name']");
    private By passwordField = By.xpath("//input[@name = 'password']");
    private By submitButtonField = By.xpath("//input[@type = 'submit']");

    public LoginPage(WebDriver wd){
        this.cd=wd;
        this.ut=new Util(cd);
        this.wait=new WebDriverWait(cd, Duration.ofSeconds(10));
    }

    public LoginPage hitTheUrl(String url) {
        cd.get(url);
        return this;
    }

    public LoginPage enterCreds(String username, String pwd)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField));
        cd.findElement(userNameField).sendKeys(username);
        ut.Delay(3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        cd.findElement(passwordField).sendKeys(pwd);
        ut.Delay(3);
        return this;
    }

    public LoginPage submit()
    {
        wait.until(ExpectedConditions.elementToBeClickable(submitButtonField));
        cd.findElement(submitButtonField).click();
        String product=cd.findElement(By.xpath("//span[@class= 'title']")).getText();
        Assert.assertEquals("Login failed","Products",product );
        return this;
    }


}
