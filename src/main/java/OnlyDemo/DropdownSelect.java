package OnlyDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownSelect {

    WebDriver cd;
    public DropdownSelect(WebDriver wd){
        this.cd=wd;
    }

    public DropdownSelect drpselect()
    {
        Select s=new Select(cd.findElement(By.xpath("//*[@id='dropdown']")));
        s.selectByValue("option3");
        return this;
    }

    public DropdownSelect hitTheUrl(String url) {
        cd.get(url);
        return this;
    }
}
