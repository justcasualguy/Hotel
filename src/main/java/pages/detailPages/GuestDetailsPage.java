package pages.detailPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.PageBase;
import properties.XPaths;

public class GuestDetailsPage extends PageBase {
    By relatedTab;
    By registeredGuestsButton;
    By registeredGuestsTableRow;
    By registeredGuestsTable;
    By newRegisteredGuestButton;
    By registeredGuestDetailsLink;
    By deleteButton;
    By confirmDeleteButton;
    public GuestDetailsPage(WebDriver webDriver) {
        super(webDriver);
        relatedTab = By.xpath(XPaths.getXPath("relatedTab"));
        registeredGuestsButton = By.xpath(XPaths.getXPath("registeredGuestsButton"));
        registeredGuestsTableRow = By.xpath(XPaths.getXPath("registeredGuestsTableRow"));
        registeredGuestsTable = By.xpath(XPaths.getXPath("registeredGuestsTable"));
        newRegisteredGuestButton = By.xpath(XPaths.getXPath("newRegisteredGuestButton"));
        registeredGuestDetailsLink = By.xpath(XPaths.getXPath("registeredGuestDetailsLink"));
        deleteButton = By.xpath(XPaths.getXPath("deleteButton"));
        confirmDeleteButton = By.xpath(XPaths.getXPath("confirmDeleteButton"));
    }

    public void clickRelatedTab(){
        fluentWaitForElement(webDriver,relatedTab,ExpectedConditions.elementToBeClickable(relatedTab));

        webDriver.findElement(relatedTab).click();
    }

    public void clickRegisteredGuests(){
        wait.until(ExpectedConditions.elementToBeClickable(registeredGuestsButton));
        Actions actions = new Actions(webDriver);
        actions.moveToElement( webDriver.findElement(registeredGuestsButton)).click().build().perform();
//        webDriver.findElement(registeredGuestsButton).click();
    }

    public int getRegisteredGuestsListSize(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //wait.until(ExpectedConditions.(registeredGuestsTable));
        return webDriver.findElements(registeredGuestsTableRow).size();
    }

    public void clickNewRegisteredGuestButton(){
        fluentWaitForElement(webDriver, newRegisteredGuestButton,
                ExpectedConditions.elementToBeClickable(newRegisteredGuestButton));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(newRegisteredGuestButton)).click().build().perform();
    }

    public void clickRegisteredGuest(){

        wait.until(ExpectedConditions.elementToBeClickable(
               registeredGuestDetailsLink
        ));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(registeredGuestDetailsLink)).
                click().build().perform();
       // webDriver.findElement(registeredGuestDetailsLink).click();
    }
    public void clickDeleteButton(){
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        webDriver.findElement(deleteButton).click();

    }
    public void clickConfirmDeleteButton(){
        wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteButton));
        webDriver.findElement(confirmDeleteButton).click();
    }
    public void deleteGuest(){
        clickDeleteButton();
        clickConfirmDeleteButton();
    }
}
