package SauceDemo;

import SeleniumBasics.Util;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailsPage {

    WebDriver cd;
    Util ut;
    WebDriverWait wait;
    WebElement productName;

    public ProductDetailsPage(WebDriver wd)
    {
        this.cd=wd;
        this.ut=new Util(cd);
        this.wait= new WebDriverWait(cd, Duration.ofSeconds(10));
        this.productName=cd.findElement(By.xpath("//div[@data-test='inventory-item-name']"));

    }

    public ProductDetailsPage addToCart()
    {

        WebElement addToCartBtn=cd.findElement(By.xpath("//*[@id='add-to-cart']"));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
        addToCartBtn.click();
        ut.Delay(2);
        WebElement removeBtn=cd.findElement(By.xpath("//*[@id='remove']"));
        WebElement cartBadge=cd.findElement(By.xpath("//*[@data-test='shopping-cart-badge']"));
        Assert.assertEquals(true,removeBtn.isDisplayed());
        Assert.assertEquals(true,cartBadge.isDisplayed());
        return this;
    }

    public ProductDetailsPage goToCart()
    {

        cd.findElement(By.xpath("//*[@data-test='shopping-cart-link']")).click();
        return this;
    }

//    public String getProductName()
//    {
//        productName=cd.findElement(By.xpath("//div[@data-test='inventory-item-name']"));
//        return productName.getText();
//    }
}
