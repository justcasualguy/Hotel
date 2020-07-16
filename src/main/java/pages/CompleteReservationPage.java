package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
        saveButton = By.xpath(XPaths.getXPath("saveReservationButton"));

    }

    public void addGuests() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(addGuestButtons));
        List<WebElement> addGuestButtonsList = webDriver.findElements(addGuestButtons);

        for (WebElement addGuestButton : addGuestButtonsList) {
            addGuestButton.click();
            addGuestPage.addGuest();
        }

    }

    public void addExistingGuest(String id) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(addGuestButtons));
        List<WebElement> addGuestButtonsList = webDriver.findElements(addGuestButtons);

        for (WebElement addGuestButton : addGuestButtonsList) {
            addGuestButton.click();
            addGuestPage.addExistingGuest(id);
        }
        PageBase.fluentWaitForElement(webDriver, saveButton,
                ExpectedConditions.elementToBeClickable(
                        webDriver.findElement(saveButton)
                ));
    }

    public void clickSaveButton() {

        try {
            PageBase.fluentWaitForElement(webDriver, saveButton,
                    ExpectedConditions.elementToBeClickable(
                            webDriver.findElement(saveButton)
                    ));
            webDriver.findElement(saveButton).click();
        }catch (StaleElementReferenceException e){
            System.out.println("Caught save button");
            webDriver.findElement(saveButton).click();
        }

        setRecentReservationId();

    }

    public void setRecentReservationId() {
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
