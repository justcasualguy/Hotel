package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import properties.XPaths;

public class UserHomePage extends PageBase{

    By receptionDeskButton;
    By reservationsButton;
    public UserHomePage(WebDriver webDriver){
        super(webDriver);
        receptionDeskButton = By.xpath(XPaths.getXPath("receptionDeskButton"));
        reservationsButton = By.xpath(XPaths.getXPath("reservationsButton"));
    }

    public void clickReceptionDeskButton(){
        wait.until(ExpectedConditions.elementToBeClickable(receptionDeskButton));
        webDriver.findElement(receptionDeskButton).click();

    }
    public void clickReservationsButton(){
        wait.until(ExpectedConditions.elementToBeClickable(receptionDeskButton));
        webDriver.findElement(reservationsButton).click();
    }
}
