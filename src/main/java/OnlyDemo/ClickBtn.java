package OnlyDemo;

import SauceDemo.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClickBtn {

    WebDriver driver;
    public ClickBtn(WebDriver wd){
        this.driver=wd;
    }

    public ClickBtn hitTheUrl(String url) {
        driver.get(url);
        return this;
    }


    public ClickBtn clickbtn()
    {
        WebElement btn=driver.findElement(By.xpath("//*[@id='clickBtn']"));
        btn.click();
        return this;
    }
}
