package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.xpi.XpiDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import properties.XPaths;

public class UserHomePage extends PageBase {

    By receptionDeskButton;
    By reservationsButton;
    By hotelsButton;
    By guestsButton;

    public UserHomePage(WebDriver webDriver) {
        super(webDriver);
        receptionDeskButton = By.xpath(XPaths.getXPath("receptionDeskButton"));
        reservationsButton = By.xpath(XPaths.getXPath("reservationsButton"));
        hotelsButton = By.xpath(XPaths.getXPath("hotelsButton"));
        guestsButton = By.xpath(XPaths.getXPath("guestsButton"));
    }

    public void clickReceptionDeskButton() {
        wait.until(ExpectedConditions.elementToBeClickable(receptionDeskButton));
        String preClickUrl = webDriver.getCurrentUrl();
        while (webDriver.getCurrentUrl().equals(preClickUrl))
            webDriver.findElement(receptionDeskButton).click();
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.xpath(XPaths.getXPath("receptionPageArticles")),1
        ));

    }

    public void clickReservationsButton() {
//        String preClickUrl = webDriver.getCurrentUrl();
//        while (webDriver.getCurrentUrl().equals(preClickUrl)) {
//            PageBase.fluentWaitForElement(webDriver, reservationsButton,
//                    ExpectedConditions.presenceOfElementLocated(
//                            reservationsButton
//                    ));
            PageBase.fluentWaitForElement(webDriver, reservationsButton,
                    ExpectedConditions.elementToBeClickable(
                            reservationsButton
                    ));
            webDriver.findElement(reservationsButton).click();
      //  }
    }
    public void clickHotelsButton(){
        PageBase.fluentWaitForElement(webDriver,hotelsButton
        ,ExpectedConditions.elementToBeClickable(hotelsButton)
        );

        webDriver.findElement(hotelsButton).click();
    }

    public void clickGuestsButton(){
        PageBase.fluentWaitForElement(webDriver,guestsButton
                ,ExpectedConditions.elementToBeClickable(guestsButton)
        );

        webDriver.findElement(guestsButton).click();
    }
}
