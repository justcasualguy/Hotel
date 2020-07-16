package pages;

import models.Room;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import properties.XPaths;

public class NewRoomFormPage extends PageBase{
    By roomNumber;
    By pricePerDay;
    By saveButton;
    public NewRoomFormPage(WebDriver webDriver) {
        super(webDriver);
        roomNumber = By.xpath(XPaths.getXPath("roomNumberField"));
        pricePerDay = By.xpath(XPaths.getXPath("pricePerDayField"));
        saveButton = By.xpath(XPaths.getXPath("saveObjectButton"));
    }

    public void  enterRoomNumber(int i){
        wait.until(ExpectedConditions.presenceOfElementLocated(roomNumber));
        webDriver.findElement(roomNumber).sendKeys(String.valueOf(i));
    }

    public void  enterPricePerDay(int i){
        wait.until(ExpectedConditions.presenceOfElementLocated(pricePerDay));
        webDriver.findElement(pricePerDay).sendKeys(String.valueOf(i));
    }

    public void clickSaveButton(){
        By success = By.xpath(XPaths.getXPath("saveSuccessToast"));
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        webDriver.findElement(saveButton).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(success));

    }

    public void addRoom(Room room){
        enterRoomNumber(room.getNumber());
        enterPricePerDay(room.getPricePerDay());
        clickSaveButton();
    }
    public void addRoom(int roomNumber,int pricePerDay){
        enterRoomNumber(roomNumber);
        enterPricePerDay(pricePerDay);
        clickSaveButton();
    }
}
