package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.PageBase;
import properties.GlobalProperties;
import properties.XPaths;

public class LoginPage extends PageBase {
    By usernameFieldLocator;
    By passwordFieldLocator;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
       usernameFieldLocator = By.xpath(XPaths.getXPath("usernameField"));
       passwordFieldLocator = By.xpath(XPaths.getXPath("passwordField"));

    }

    public void enterUsername() {

        wait.until(ExpectedConditions.elementToBeClickable(usernameFieldLocator));
        webDriver.findElement(usernameFieldLocator).
                sendKeys(GlobalProperties.getProperty("username"));
    }

    public void enterPassword() {
        wait.until(ExpectedConditions.elementToBeClickable(passwordFieldLocator));
        webDriver.findElement(passwordFieldLocator).
                sendKeys(GlobalProperties.getProperty("password"));

    }

    public void confrim(){
        webDriver.findElement(passwordFieldLocator)
                .sendKeys(Keys.ENTER);
    }

    public void enterCredentials(){
        enterUsername();
        enterPassword();
        confrim();
    }
}
