import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import pages.LoginPage;
import properties.GlobalProperties;

import java.util.HashMap;
import java.util.Map;

public class TestBase {
    protected static WebDriver webDriver;

    public TestBase() {
        if (webDriver == null) {
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);
            System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
            webDriver = new ChromeDriver(options);
            webDriver.manage().window().maximize();

        }


    }

    @BeforeSuite
    public void setup() {
        webDriver.get(
                GlobalProperties.getProperty("url")
        );
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.enterCredentials();
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }
}
