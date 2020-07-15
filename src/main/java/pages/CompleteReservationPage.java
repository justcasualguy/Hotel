package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import properties.XPaths;

import java.util.List;

public class CompleteReservationPage extends PageBase {
    By addGuestButtons;
    By saveButton;
    AddGuestPage addGuestPage;
    String recentReservationId;

    public CompleteReservationPage(WebDriver webDriver) {
        super(webDriver);
        addGuestPage = new AddGuestPage(webDriver);
        addGuestButtons = By.xpath(XPaths.getXPath("addGuestButtons"));
        saveButton = By.xpath(XPaths.getXPath("saveButton"));

    }

    public void addGuests() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(addGuestButtons));
        List<WebElement> addGuestButtonsList = webDriver.findElements(addGuestButtons);

        for (WebElement addGuestButton : addGuestButtonsList) {
            addGuestButton.click();
            addGuestPage.addGuest();
        }
    }

    public void clickSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        webDriver.findElement(saveButton).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath(XPaths.getXPath("reservationId")
                )));
        recentReservationId = PageBase.findFirstDisplayed(
                webDriver.findElements(
                        By.xpath(XPaths.getXPath("reservationId")
                        )
                )
        ).getText();
    }

    public String getRecentReservationId() {
        return recentReservationId;
    }
}
