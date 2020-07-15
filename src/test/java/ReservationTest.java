import org.checkerframework.checker.units.qual.C;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class ReservationTest extends TestBase{
    LoginPage loginPage;
    UserHomePage userHomePage;
    ReceptionDeskPage receptionDeskPage;
    CompleteReservationPage completeReservationPage;
    ReservationsPage reservationsPage;
    ReservationPage reservationPage;
    @BeforeClass
    public void setup(){

        loginPage = new LoginPage(webDriver);
        userHomePage = new UserHomePage(webDriver);
        receptionDeskPage = new ReceptionDeskPage(webDriver);
        completeReservationPage = new CompleteReservationPage(webDriver);
        reservationsPage = new ReservationsPage(webDriver);
        reservationPage = new ReservationPage(webDriver);
    }
    @Test
    public void reservationTest(){
        loginPage.enterCredentials();
        userHomePage.clickReceptionDeskButton();
        receptionDeskPage.enterReservationDate();
        receptionDeskPage.clickCheckAvailability();
        receptionDeskPage.selectFirstHotelWithPrice();
        receptionDeskPage.clickMakeReservation();
        completeReservationPage.addGuests();
        completeReservationPage.clickSaveButton();
        userHomePage.clickReservationsButton();

        boolean reservationExists = reservationsPage.findReservation(completeReservationPage.getRecentReservationId());

        Assert.assertEquals(reservationExists,true);
    }
    @AfterClass
    public void cleanup(){
        reservationsPage.clickReservation(completeReservationPage.getRecentReservationId());
        reservationPage.clickDeleteButton();
        reservationPage.clickConfirmDeleteButton();
    }
}
