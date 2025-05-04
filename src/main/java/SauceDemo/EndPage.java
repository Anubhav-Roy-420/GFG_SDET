package SauceDemo;

import SeleniumBasics.Util;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EndPage {

    WebDriver cd;
    Util ut;
    WebDriverWait wait;
    WebElement b2home;
    WebElement endtext;

    public EndPage(WebDriver wd)
    {
        this.cd=wd;
        this.ut=new Util(cd);
        this.wait= new WebDriverWait(cd, Duration.ofSeconds(10));
    }

    public EndPage backToHomePage()
    {
        ut.Delay(2);
        endtext= cd.findElement(By.xpath("//*[@data-test='complete-header']"));
        Assert.assertEquals("Order not placed successfully","Thank you for your order!",endtext.getText());
        b2home=cd.findElement(By.xpath("//*[@data-test='back-to-products']"));
        wait.until(ExpectedConditions.elementToBeClickable(b2home));
        b2home.click();
        return this;
    }
}
