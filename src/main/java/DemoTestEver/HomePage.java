package DemoTestEver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    WebDriver cd;
    //private By pro1=By.xpath("//span[text()='Nike react infinity run flyknit']");
    //private By pro2=By.xpath("//span[text()='Nike court vision low']");
    //private By pro3=By.xpath("//span[text()='Nike zoom fly']");
    //private By pro4=By.xpath("//span[text()='Nike air zoom pegasus 35']");
    String s="//span[text()='']";

    public HomePage(WebDriver wd)
    {
        this.cd=wd;
    }

    public String replace(String str1, String rep)
    {
        StringBuffer res=new StringBuffer(str1);
        res.insert(15,rep);
        return res.toString();
    }

    public HomePage clickProduct(String product)
    {
        String s1=replace(s,product);
        cd.findElement(By.xpath(s1)).click();
        return this;
    }


}
