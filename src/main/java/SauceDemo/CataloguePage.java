package SauceDemo;

import SeleniumBasics.Util;
import junit.framework.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CataloguePage {

    WebDriver cd;
    Util ut;
    WebDriverWait wait;

    String productName="//div[@class= 'inventory_item_name '][text()='*#']";

    public CataloguePage(WebDriver wd)
    {
        this.cd=wd;
        this.ut=new Util(cd);
        this.wait= new WebDriverWait(cd, Duration.ofSeconds(10));
    }

    public CataloguePage clickProduct(String product)
    {
//        WebElement alert = cd.switchTo().activeElement();
//        System.out.println("Alert text: " + alert.getText());
        String s1=ut.replaceString(productName,"*#",product);
        WebElement productLink= cd.findElement(By.xpath(s1));
        wait.until(ExpectedConditions.elementToBeClickable(productLink));
        String s=productLink.getText();
        productLink.click();
        ut.Delay(3);
        WebElement productPageTitle=cd.findElement(By.xpath("//*[@data-test='inventory-item-name']"));
        Assert.assertEquals("Cannot access Product Details Page",
        s,productPageTitle.getText());
        return this;
    }
}
