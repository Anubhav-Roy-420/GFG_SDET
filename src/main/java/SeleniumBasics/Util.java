package SeleniumBasics;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;

public class Util {

    public WebDriver driver;

    public WebDriverWait wait;

    public FluentWait fluentWait;

    public Util(WebDriver wd){
        this.driver=wd;
    }

    public void waitImplicit(int timeout)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
    }

    public void ExplicitWait(int timeout, By locator)
    {
        wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void Delay(int timeout)
    {
        wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nonExistentElement")));
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("Waited for "+timeout+" seconds (simulated).");
        }
    }

    public void FluentWait(int timeout, By locator, int polling ) {
        fluentWait = new FluentWait(driver).
                withTimeout(Duration.ofSeconds(timeout)).
                pollingEvery(Duration.ofSeconds(polling)).
                ignoring(NoSuchElementException.class);

        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void ScrolltoView( WebElement ele)
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
    }

    public String replaceString(String mstr, String f, String rep)
    {
           String str= mstr.replace(f,rep);
           return str;
    }

    public boolean isElementVisible(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false; // Element is not present, so it's not visible
        }
    }
}
