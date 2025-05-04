package SeleniumBasics;

import org.openqa.selenium.WebDriver;

public class ThreadLocalClass {

   private static final ThreadLocal<WebDriver> driver=new ThreadLocal<>();

    public static WebDriver getTl() {
        return driver.get();
    }

    public static void setTl(WebDriver wd) {
        driver.set(wd);
    }
}
