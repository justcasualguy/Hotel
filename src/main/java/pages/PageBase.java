package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;


public class PageBase {
    protected WebDriver webDriver;
    protected WebDriverWait wait;


    public PageBase(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    public static String putStringInXPath(String xpath, String str) {
        return String.format(xpath, str);
    }

    public static WebElement findFirstDisplayed(List<WebElement> elements) {
        for (WebElement we : elements)
            if (we.isDisplayed())
                return we;
        return null;

    }

    public static void fluentWaitForElement(WebDriver driver,By locator, ExpectedCondition expectedCondition){

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofMinutes(1))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        try {
             wait.until(expectedCondition);
        } catch (TimeoutException e){
            Assert.fail("Element "+locator+ " not found");
            throw new NullPointerException("Element is null");
        }

    }


}
