package pages.formPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.PageBase;
import properties.XPaths;

public class NewRegisteredGuestFormPage extends PageBase {
    By newReservationButton;
    By searchReservationBar;
    By saveButton;

    public NewRegisteredGuestFormPage(WebDriver webDriver) {
        super(webDriver);
        newReservationButton = By.xpath(XPaths.getXPath("newReservation"));
        searchReservationBar = By.xpath(XPaths.getXPath("searchReservationBar"));
        saveButton = By.xpath(XPaths.getXPath("saveRecordButton"));
    }

    public void clickNewReservationButton() {
        wait.until(ExpectedConditions.elementToBeClickable(newReservationButton));
        webDriver.findElement(newReservationButton).click();
    }

    public void clickSearchReservationBar() {
        wait.until(ExpectedConditions.elementToBeClickable(searchReservationBar));
        webDriver.findElement(searchReservationBar).click();
    }

    public void clickSaveButton(){
        fluentWaitForElement(webDriver,saveButton,
                ExpectedConditions.elementToBeClickable(saveButton));
        webDriver.findElement(saveButton).click();
    }
}
