import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import pages.LoginPage;
import properties.GlobalProperties;

public class TestBase {
    protected static WebDriver webDriver;

    public TestBase() {
        if(webDriver==null){
            System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();

        }
    }
    @BeforeSuite
    public void setup(){
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
