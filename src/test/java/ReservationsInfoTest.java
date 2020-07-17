import models.Guest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.PageBase;
import pages.ReservationsPage;
import pages.UserHomePage;
import pages.detailPages.ReservationDetailsPage;
import properties.GlobalProperties;

import java.util.List;

public class ReservationsInfoTest extends TestBase {
    UserHomePage userHomePage;
    ReservationsPage reservationsPage;
    ReservationDetailsPage reservationDetailsPage;
    List<String> allReservationsLinks;
    List<Guest> guests;

    @BeforeClass
    public void setup() {
        userHomePage = new UserHomePage(webDriver);
        reservationsPage = new ReservationsPage(webDriver);
        reservationDetailsPage = new ReservationDetailsPage(webDriver);

    }

    @Test
    public void reservationsInfoTest() {
        webDriver.navigate().to(GlobalProperties.getProperty("reservationsUrl"));


        for (String reservationUrl : reservationsPage.getAllReservationsLinks()) {
            webDriver.navigate().to(reservationUrl);
            System.out.println("========================");
            System.out.println("Reservation: " + reservationDetailsPage.getReservationId());
            System.out.println("========================");
            guests = reservationDetailsPage.getGuests();
            if (guests == null)
                System.out.println("No guests");
            else {
                for (Guest guest : guests)
                    System.out.println(guest.getFullName());
            }
            System.out.println("========================");
        }
    }


}
