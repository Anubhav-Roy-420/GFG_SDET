package SeleniumBasics;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumBasics {

    public static void Demo() throws MalformedURLException, InterruptedException {

        ChromeOptions options = new ChromeOptions();
        WebDriver cd = new RemoteWebDriver(new URL("http://192.168.29.87:4444"),options);
        Util wait=new Util(cd);
        cd.get("https://demo.evershop.io/account/login");
        cd.manage().window().maximize();
        cd.findElement(By.xpath("//input[@name = 'email']")).sendKeys("akhiljda@gmail.com");
        cd.findElement(By.name("password")).sendKeys("Password");
        cd.findElement(By.xpath("//button[@type = 'submit']")).click();
        wait.ExplicitWait(5,By.xpath("//*[@id=\"app\"]/div/main/div[2]/div/div/div[1]/div/h3"));
        String s=cd.findElement(By.xpath("//*[@id=\"app\"]/div/main/div[2]/div/div/div[1]/div/h3")).getText();
        System.out.println(s);
        //Assert.assertEquals("Login Failed","An Amazing EverShop Store",cd.getTitle() );
        //Assert.assertEquals("Login Failed", "Kids shoes collection", s.trim());
        cd.quit();
    }

    public static void main(String args[]) throws MalformedURLException, InterruptedException {

        Demo();
    }
}
