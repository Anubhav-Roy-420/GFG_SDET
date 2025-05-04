package SauceDemo;

import SeleniumBasics.Util;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    WebDriver cd;
    Util ut;
    WebDriverWait wait;
    ProductDetailsPage pdp;

    public CartPage(WebDriver wd)
    {
        this.cd=wd;
        ut=new Util(cd);
        wait=new WebDriverWait(cd, Duration.ofSeconds(10));

    }



    public CartPage checkoutClick()
    {
        WebElement checkoutBtn;
        pdp=new ProductDetailsPage(cd);
        String productPageName=pdp.productName.getText();
        String cartPageName=cd.findElement(By.xpath("//div[@class='cart_item_label']/a/div")).getText();
        Assert.assertEquals("Product Name mismatch",productPageName,cartPageName);
        checkoutBtn=cd.findElement(By.xpath("//button[@id='checkout']"));
        ut.Delay(1);
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn));
        checkoutBtn.click();
        Assert.assertEquals("Cannot go to \"Your Info\" page","Checkout: Your Information",
                cd.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText());
        return this;
    }
}
