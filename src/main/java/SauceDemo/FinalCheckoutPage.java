package SauceDemo;

import SeleniumBasics.Util;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FinalCheckoutPage {

    WebDriver cd;
    Util ut;
    WebDriverWait wait;
    WebElement finish;
    WebElement finishTitle;

    public FinalCheckoutPage(WebDriver wd)
    {
        this.cd=wd;
        this.ut=new Util(cd);
        this.wait= new WebDriverWait(cd, Duration.ofSeconds(10));
    }

    public FinalCheckoutPage finishOrder()
    {
        ut.Delay(2);
        finish= cd.findElement(By.xpath("//*[@id='finish']"));
        wait.until(ExpectedConditions.elementToBeClickable(finish));
        finish.click();
        finishTitle= cd.findElement(By.xpath("//*[@data-test='title']"));
        Assert.assertEquals("Mismatch in title","Checkout: Complete!",finishTitle.getText());
        return this;
    }

}
