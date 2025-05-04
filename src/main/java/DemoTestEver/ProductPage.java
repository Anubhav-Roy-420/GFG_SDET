package DemoTestEver;

import SeleniumBasics.Util;
import junit.framework.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    public WebDriver cd;
    WebDriverWait wait;

    public ProductPage(WebDriver wd) {
        this.cd = wd;
        this.wait=new WebDriverWait(cd,Duration.ofSeconds(10));
        this.ut=new Util(cd);
    }

    Util ut;

    String size="(//*[@class='variant-option-list flex justify-start gap-2 flex-wrap'])[1]/li/a[text()=*#]";
    String color="(//*[@class='variant-option-list flex justify-start gap-2 flex-wrap'])[2]/li/a[text()=*#]";
    String qty="//*[@placeholder='Qty']";





    public ProductPage addSize(String s) throws InterruptedException {


        String size1=ut.replaceString(size,"*#",s);
        System.out.println(size1);
        ut.ScrolltoView(cd.findElement(By.xpath(size1)));
        ut.Delay(2);
        cd.findElement(By.xpath(size1)).click();
        return this;
    }

    public ProductPage addColor(String c) throws InterruptedException {

        String color1=ut.replaceString(color,"*#",c);
        System.out.println(color1);
        ut.ScrolltoView(cd.findElement(By.xpath(color1)));
        ut.Delay(2);
        //Thread.sleep(5000);
        cd.findElement(By.xpath(color1)).click();
        return this;
    }

    public ProductPage addQty(String q)
    {
        WebElement addToCart= cd.findElement(By.xpath("//*[@class='add-to-cart mt-8']/div[2]/button"));
            ut.ScrolltoView(cd.findElement(By.xpath(qty)));
            ut.Delay(2);
            cd.findElement(By.xpath(qty)).clear();
            cd.findElement(By.xpath(qty)).sendKeys(q);
            ut.Delay(2);
            addToCart.click();
            Assert.assertEquals("Variants not added",false,ut.isElementVisible(By.xpath("//*[@id='app']/div/main/div[2]/div[2]/div/div[2]/div[2]/div[3]")));
//            if(q.equals('1')||q.equals(" "))
//            {
//                String s= (cd.findElement((By.xpath("//*[@id=\"productForm\"]/div/div/div[2]")))).getText();
//                Assert.assertEquals("Invalid Quantity","Qty is invalid",s.trim());
//            }
            Assert.assertEquals("Invalid Quantity",false,ut.isElementVisible(By.xpath("//*[@class='text-critical mt-4']")));
            return this;


    }

}
