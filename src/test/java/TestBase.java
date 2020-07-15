import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import properties.GlobalProperties;

public class TestBase {
    protected static WebDriver webDriver;

    public TestBase() {
        if(webDriver==null){
            System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            webDriver.get(
                    GlobalProperties.getProperty("url")
            );
        }
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }
}
