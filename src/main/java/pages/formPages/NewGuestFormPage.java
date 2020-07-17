package pages.formPages;

import models.Guest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.PageBase;
import properties.XPaths;

public class NewGuestFormPage extends PageBase {
    By guestFormFirstNameField;
    By guestFormLastNameField;
    By guestFormIdCardField;
    By saveButton;
    public NewGuestFormPage(WebDriver webDriver) {
        super(webDriver);
        guestFormFirstNameField = By.xpath(XPaths.getXPath("guestFormFirstNameField"));
        guestFormLastNameField = By.xpath(XPaths.getXPath("guestFormLastNameField"));
        guestFormIdCardField = By.xpath(XPaths.getXPath("guestFormIdCardField"));
        saveButton = By.xpath(XPaths.getXPath("saveRecordButton"));
    }

    public void enterFirstName(String firstName){
        wait.until(ExpectedConditions.presenceOfElementLocated(guestFormFirstNameField));
        webDriver.findElement(guestFormFirstNameField).sendKeys(firstName);
    }
    public void enterLastName(String lastName){
        wait.until(ExpectedConditions.presenceOfElementLocated(guestFormLastNameField));
        webDriver.findElement(guestFormLastNameField).sendKeys(lastName);
    }
    public void enterIdCard(String cardId){
        wait.until(ExpectedConditions.presenceOfElementLocated(guestFormIdCardField));
        webDriver.findElement(guestFormIdCardField).sendKeys(cardId);
    }

    public void enterGuestInfo(Guest guest){
        enterFirstName(guest.getFirstName());
        enterLastName(guest.getLastName());
        enterIdCard(guest.getId());
    }
    public void clickSaveButton(){
        fluentWaitForElement(webDriver,saveButton,ExpectedConditions.elementToBeClickable(saveButton));
        webDriver.findElement(saveButton).click();
    }
    public void addGuest(Guest guest){
        enterGuestInfo(guest);
        clickSaveButton();
    }
}
