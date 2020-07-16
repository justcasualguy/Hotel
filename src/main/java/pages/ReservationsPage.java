package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import properties.XPaths;

import java.util.List;

public class ReservationsPage extends PageBase {
    By reservationsTable;
    By reservationsRow;
    public ReservationsPage(WebDriver webDriver) {
        super(webDriver);
        reservationsTable = By.xpath(XPaths.getXPath("reservationsTable"));
        reservationsRow = By.xpath(XPaths.getXPath("reservationsRow"));
    }

   public boolean findReservation(String id) {
       try {
           wait.until(ExpectedConditions.presenceOfElementLocated(reservationsTable));
           wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(reservationsRow));
       }
       catch (StaleElementReferenceException e) {
           System.out.println("Find reservation stale");
       }
        String reservationXPath= PageBase.putStringInXPath(
                XPaths.getXPath("reservationById"), id
        );
        By reservation = By.xpath(reservationXPath);
        List<WebElement> elements = webDriver.findElements(reservation);
        return webDriver.findElements(reservation).size()>0;
    }
    public void clickReservation(String id){
        String reservationXPath= PageBase.putStringInXPath(
                XPaths.getXPath("reservationById"), id
        );
        By reservation = By.xpath(reservationXPath);
        webDriver.findElement(reservation).click();
    }
}
