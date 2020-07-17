package pages.detailPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.PageBase;
import properties.XPaths;

public class RegisteredGuestDetailsPage extends PageBase {
    By reservationDetaiLink;
    public RegisteredGuestDetailsPage(WebDriver webDriver) {
        super(webDriver);
        reservationDetaiLink=By.xpath(XPaths.getXPath("reservationDetailLink"));
    }


    public void clickReservationDetailLink(){
        wait.until(ExpectedConditions.elementToBeClickable(reservationDetaiLink));
        webDriver.findElement(reservationDetaiLink).click();
    }
}
