import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class ExistingGuetReservationTest extends TestBase {
    UserHomePage userHomePage;
    ReceptionDeskPage receptionDeskPage;
    CompleteReservationPage completeReservationPage;
    ReservationsPage reservationsPage;
    ReservationDetailsPage reservationDetailsPage;

    @BeforeClass
    public void setup() {
        userHomePage = new UserHomePage(webDriver);
        receptionDeskPage = new ReceptionDeskPage(webDriver);
        completeReservationPage = new CompleteReservationPage(webDriver);
        reservationsPage = new ReservationsPage(webDriver);
        reservationDetailsPage = new ReservationDetailsPage(webDriver);
    }

    @Test(invocationCount = 3)
   // @Test
    public void reservationTest() {
        //webDriver.navigate().to(GlobalProperties.getProperty("homePageUrl"));
        userHomePage.clickReceptionDeskButton();
        receptionDeskPage.enterReservationDate();
        receptionDeskPage.clickCheckAvailability();
        receptionDeskPage.selectFirstHotelWithPrice();
        receptionDeskPage.clickMakeReservation();
        completeReservationPage.addExistingGuest("abc123457");
        completeReservationPage.clickSaveButton();
        userHomePage.clickReservationsButton();

        boolean reservationExists = reservationsPage.findReservation(completeReservationPage.getRecentReservationId());

        Assert.assertEquals(reservationExists, true);
    }

    @AfterMethod
    public void cleanup() {
        reservationsPage.clickReservation(completeReservationPage.getRecentReservationId());
        reservationDetailsPage.clickDeleteButton();
        reservationDetailsPage.clickConfirmDeleteButton();
    }
}
