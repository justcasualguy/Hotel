package pages.detailPages;

import models.Guest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.PageBase;
import properties.XPaths;

import java.util.ArrayList;
import java.util.List;

public class ReservationDetailsPage extends PageBase {
    By reservationId;
    By deleteButton;
    By confirmDeleteButton;
    By confirmationToast;
    By guestsListFirstName;
    By guestsListLastName;
    By reservedRooms;
    public ReservationDetailsPage(WebDriver webDriver) {
        super(webDriver);
        reservationId = By.xpath(XPaths.getXPath("reservationId"));
        deleteButton = By.xpath(XPaths.getXPath("deleteButton"));
        confirmDeleteButton = By.xpath(XPaths.getXPath("confirmDeleteButton"));
        confirmationToast = By.xpath(XPaths.getXPath("saveSuccessToast"));
        guestsListFirstName = By.xpath(XPaths.getXPath("guestsListFirstName"));
        guestsListLastName = By.xpath(XPaths.getXPath("guestsListLastName"));
        reservedRooms = By.xpath(XPaths.getXPath("reservedRooms"));
    }

    public void deleteReservation(){
        clickDeleteButton();
        clickConfirmDeleteButton();
    }

    public void clickDeleteButton(){
        fluentWaitForElement(webDriver,deleteButton,
                ExpectedConditions.presenceOfAllElementsLocatedBy(deleteButton));
        fluentWaitForElement(webDriver,deleteButton,
                ExpectedConditions.numberOfElementsToBeMoreThan(deleteButton,0));

        findFirstDisplayed(webDriver.findElements(deleteButton)).click();
    }
    public void clickConfirmDeleteButton(){
        fluentWaitForElement(webDriver,confirmDeleteButton,
                ExpectedConditions.elementToBeClickable(confirmDeleteButton));


        webDriver.findElement(confirmDeleteButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationToast));

    }

    public List<Guest> getGuests(){
        wait.until(ExpectedConditions.presenceOfElementLocated(reservedRooms));
        List<WebElement> guestsFirstName=webDriver.findElements(guestsListFirstName);
        if(guestsFirstName.size()==0)
            return null;
        List<WebElement> guestsLastName = webDriver.findElements(guestsListLastName);
        List<Guest> guests = new ArrayList<>();

        for(int i=0;i<guestsFirstName.size();i++){
            guests.add(new Guest(
                    guestsFirstName.get(i).getText(),
                    guestsLastName.get(i).getText()
            ));
        }
        return guests;
    }

    public String getReservationId(){
        wait.until(ExpectedConditions.presenceOfElementLocated(reservationId));
        return webDriver.findElement(reservationId).getText();
    }
}
