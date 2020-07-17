package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import properties.XPaths;

public class GuestsPage extends PageBase{
    By newButton;
    By guestDetailsLink;

    public GuestsPage(WebDriver webDriver) {
        super(webDriver);
        newButton = By.xpath(XPaths.getXPath("newRecordButton"));

    }

    public void clickNewGuestButton(){
        fluentWaitForElement(webDriver,newButton,
                ExpectedConditions.elementToBeClickable(newButton));
        webDriver.findElement(newButton).click();
    }

    public void addGuest(){

    }

    public void clickGuestDetailsLink(String firstname){
        By guestDetailsLink=By.xpath(putStringInXPath(
                XPaths.getXPath("guestDetailsLink"),
                firstname
        ));
        wait.until(ExpectedConditions.elementToBeClickable(
                guestDetailsLink
        ));

        webDriver.findElement(guestDetailsLink).click();

    }

}
