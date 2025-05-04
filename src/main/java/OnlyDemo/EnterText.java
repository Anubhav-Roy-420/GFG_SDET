package OnlyDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EnterText {

    WebDriver driver;
    public EnterText(WebDriver wd){
        this.driver=wd;
    }

    public EnterText hitTheUrl(String url) {
        driver.get(url);
        return this;
    }

    public EnterText enter(String t)
    {
        WebElement field=driver.findElement(By.xpath("//*[@id='textInput']"));
        field.sendKeys(t);
        return this;
    }
}
