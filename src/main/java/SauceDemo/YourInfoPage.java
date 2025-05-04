package SauceDemo;

import SeleniumBasics.Util;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YourInfoPage {

    WebDriver cd;
    Util ut;
    WebDriverWait wait;
    WebElement fname;
    WebElement lname;
    WebElement zip;

    public YourInfoPage(WebDriver wd)
    {
        this.cd=wd;
        this.ut=new Util(cd);
        this.wait= new WebDriverWait(cd, Duration.ofSeconds(10));
    }



    public YourInfoPage enterInfo(String fname, String lname, String zip){

        this.fname=cd.findElement(By.xpath("//input[@name='firstName']"));
        this.lname=cd.findElement((By.xpath("//input[@name='lastName']")));
        this.zip=cd.findElement(By.xpath("//input[@name='postalCode']"));


        wait.until(ExpectedConditions.visibilityOf(this.fname));
        this.fname.sendKeys(fname);
        ut.Delay(1);
        wait.until(ExpectedConditions.visibilityOf(this.lname));
        this.lname.sendKeys(lname);
        ut.Delay(1);
        wait.until(ExpectedConditions.visibilityOf(this.zip));
        this.zip.sendKeys(zip);
        ut.Delay(1);
        return this;
    }

    public YourInfoPage clickContinue()
    {
        WebElement continueBtn=cd.findElement(By.xpath("//input[@name='continue']"));
        continueBtn.click();
        WebElement overviewTitle=cd.findElement(By.xpath("//span[@data-test='title']"));
        Assert.assertEquals("Mismatch in title","Checkout: Overview",overviewTitle.getText());
        return this;
    }
}
