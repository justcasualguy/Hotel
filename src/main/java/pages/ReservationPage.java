package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import properties.XPaths;

public class ReservationPage extends PageBase{
    By reservationId;
    By deleteButton;
    By confirmDeleteButton;
    public ReservationPage(WebDriver webDriver) {
        super(webDriver);
        reservationId = By.xpath(XPaths.getXPath("reservationId"));
        deleteButton = By.xpath(XPaths.getXPath("deleteReservationButton"));
        confirmDeleteButton = By.xpath(XPaths.getXPath("confrimDeleteButton"));
    }

    public void clickDeleteButton(){
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        webDriver.findElement(deleteButton).click();
    }
    public void clickConfirmDeleteButton(){
        wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteButton));
        webDriver.findElement(confirmDeleteButton).click();
    }
    public String getReservationId(){
        wait.until(ExpectedConditions.presenceOfElementLocated(reservationId));
        return webDriver.findElement(reservationId).getText();
    }
}
