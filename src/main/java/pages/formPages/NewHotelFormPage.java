package pages.formPages;

import models.Hotel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.PageBase;
import properties.XPaths;

public class NewHotelFormPage extends PageBase {
    By hotelNameField;
    By cityField;
    By streetField;
    By zipCodeField;
    By saveButton;
    By confirmationToast;

    public NewHotelFormPage(WebDriver webDriver) {
        super(webDriver);
        hotelNameField= By.xpath(XPaths.getXPath("hotelNameField"));
        cityField=By.xpath(XPaths.getXPath("cityField"));
        streetField=By.xpath(XPaths.getXPath("streetField"));
        zipCodeField=By.xpath(XPaths.getXPath("zipCodeField"));
        saveButton = By.xpath(XPaths.getXPath("saveRecordButton"));
        confirmationToast = By.xpath(XPaths.getXPath("saveSuccessToast"));

    }

    public void enterHotelName(String name){
        wait.until(ExpectedConditions.presenceOfElementLocated(hotelNameField));
        webDriver.findElement(hotelNameField).sendKeys(name);
    }

    public void enterCity(String city){
        wait.until(ExpectedConditions.presenceOfElementLocated(cityField));
        webDriver.findElement(cityField).sendKeys(city);
    }

    public void enterStreet(String street){
        wait.until(ExpectedConditions.presenceOfElementLocated(streetField));
        webDriver.findElement(streetField).sendKeys( street);
    }
    public void enterZipCode(String zipcode){
        wait.until(ExpectedConditions.presenceOfElementLocated(zipCodeField));
        webDriver.findElement(zipCodeField).sendKeys(zipcode);
    }
    public void clickSaveButton(){
        wait.until(ExpectedConditions.presenceOfElementLocated(saveButton));
        webDriver.findElement(saveButton).click();
    }
    public void addHotel(Hotel hotel){
        By newHotelForm = By.xpath(XPaths.getXPath("newHotelForm"));
        PageBase.fluentWaitForElement(
                webDriver,
                newHotelForm,
                ExpectedConditions.presenceOfElementLocated(
                       newHotelForm)
                );

        enterHotelName(hotel.getName());
        enterCity(hotel.getCity());
        enterStreet(hotel.getStreet());
        enterZipCode(hotel.getZipCode());
        clickSaveButton();
        wait.until(ExpectedConditions.presenceOfElementLocated(confirmationToast));
    }

}
