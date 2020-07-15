package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

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

}
