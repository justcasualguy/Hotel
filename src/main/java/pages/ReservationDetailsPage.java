package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import properties.XPaths;

public class ReservationDetailsPage extends PageBase{
    By reservationId;
    By deleteButton;
    By confirmDeleteButton;
    By confirmationToast;
    public ReservationDetailsPage(WebDriver webDriver) {
        super(webDriver);
        reservationId = By.xpath(XPaths.getXPath("reservationId"));
        deleteButton = By.xpath(XPaths.getXPath("deleteButton"));
        confirmDeleteButton = By.xpath(XPaths.getXPath("confirmDeleteButton"));
        confirmationToast = By.xpath(XPaths.getXPath("saveSuccessToast"));
    }

    public void clickDeleteButton(){
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        webDriver.findElement(deleteButton).click();
    }
    public void clickConfirmDeleteButton(){
        wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteButton));
        webDriver.findElement(confirmDeleteButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationToast));

    }
    public String getReservationId(){
        wait.until(ExpectedConditions.presenceOfElementLocated(reservationId));
        return webDriver.findElement(reservationId).getText();
    }
}
