package pages.detailPages;

import models.Room;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.PageBase;
import pages.formPages.NewRoomFormPage;
import properties.XPaths;

import java.util.List;

public class HotelDetailsPage extends PageBase {
    By newRoomButton;
    By hotelName;
    By city;
    By street;
    By zipCode;
    By roomRows;
    By deleteButton;
    By confirmDeleteButton;
    NewRoomFormPage newRoomFormPage;

    public HotelDetailsPage(WebDriver webDriver) {
        super(webDriver);
        newRoomFormPage= new NewRoomFormPage(webDriver);
        newRoomButton = By.xpath(XPaths.getXPath("newRoomButton"));
        city = By.xpath(XPaths.getXPath("cityNameFieldText"));
        street = By.xpath(XPaths.getXPath("streetNameFieldText"));
        zipCode = By.xpath(XPaths.getXPath("zipCodeFieldText"));
        hotelName = By.xpath(XPaths.getXPath("hotelNameFieldText"));
        roomRows = By.xpath(XPaths.getXPath("roomRows"));
        deleteButton = By.xpath(XPaths.getXPath("deleteButton"));
        confirmDeleteButton = By.xpath(XPaths.getXPath("confirmDeleteButton"));
    }


    public void clickNewRoomButton(){
        PageBase.fluentWaitForElement(webDriver,newRoomButton,
                ExpectedConditions.elementToBeClickable(newRoomButton)
        );


        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(newRoomButton)).click().perform();
        By newRoomForm = By.xpath(XPaths.getXPath("newRecordForm"));

        PageBase.fluentWaitForElement(
                webDriver,
                newRoomForm,
                ExpectedConditions.presenceOfElementLocated(
                        newRoomForm)
        );
    }
    public void addRoom(Room room){
        clickNewRoomButton();
        newRoomFormPage.addRoom(room);
    }
    public void addRooms(List<Room> rooms){
        for(Room r:rooms)
            addRoom(r);
    }
    public void addRoom(int roomNumber,int pricePerDay){
        clickNewRoomButton();
        newRoomFormPage.addRoom(roomNumber,pricePerDay);
    }

    public String getHotelName(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(hotelName));
       return webDriver.findElement(hotelName).getText();
    }
    public String getCity(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(hotelName));
        return webDriver.findElement(city).getText();
    }
    public String getStreet(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(hotelName));
        return webDriver.findElement(street).getText();
    }
    public String getZipCode(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(hotelName));
        return webDriver.findElement(zipCode).getText();
    }

    public int getRoomsCount(){
        return webDriver.findElements(roomRows).size();
    }
    
    public void clickDeleteButton(){
        fluentWaitForElement(webDriver,deleteButton,
                ExpectedConditions.elementToBeClickable(deleteButton));
        webDriver.findElement(deleteButton).click();

    }

    public void clickConfrimDeleteButton(){
        fluentWaitForElement(webDriver,confirmDeleteButton,
                ExpectedConditions.elementToBeClickable(confirmDeleteButton));
        webDriver.findElement(confirmDeleteButton).click();
    }
}
