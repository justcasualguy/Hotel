package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import properties.XPaths;

public class AddGuestPage extends PageBase{
    String idChars="abc";
    static int idDigits=123456;
    By firstNameField;
    By lastNameField;
    By idCardField;
    By searchGuestByIdButton;
    By saveGuestButton;


    public AddGuestPage(WebDriver webDriver) {
        super(webDriver);
        firstNameField = By.xpath(XPaths.getXPath("firstNameField"));
        lastNameField = By.xpath(XPaths.getXPath("lastNameField"));
        idCardField = By.xpath(XPaths.getXPath("idCardField"));
        searchGuestByIdButton = By.xpath(XPaths.getXPath("searchGuestByIdButton"));
        saveGuestButton = By.xpath(XPaths.getXPath("saveGuestButton"));
    }
    public void addGuest(){
        enterFirstName();
        enterLastName();
        enterCardId();
        clickSaveButton();
    }

    public void enterFirstName(){
        wait.until(ExpectedConditions.elementToBeClickable(firstNameField));
        webDriver.findElement(firstNameField).sendKeys("Guest"+idDigits);
    }
    public void enterLastName(){
        wait.until(ExpectedConditions.elementToBeClickable(lastNameField));
        webDriver.findElement(lastNameField).sendKeys("Guest"+idDigits);
    }
    public void enterCardId(){
        wait.until(ExpectedConditions.elementToBeClickable(idCardField));
        webDriver.findElement(idCardField).sendKeys(idChars+String.valueOf(idDigits++));
    }
    public void clickSaveButton(){
        wait.until(ExpectedConditions.elementToBeClickable(saveGuestButton));
        webDriver.findElement(saveGuestButton).click();
    }
}
