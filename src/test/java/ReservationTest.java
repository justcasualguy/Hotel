import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

public class ReservationTest extends TestBase{
    UserHomePage userHomePage;
    ReceptionDeskPage receptionDeskPage;
    CompleteReservationPage completeReservationPage;
    ReservationsPage reservationsPage;
    ReservationDetailsPage reservationDetailsPage;
    @BeforeClass
    public void setup(){
        userHomePage = new UserHomePage(webDriver);
        receptionDeskPage = new ReceptionDeskPage(webDriver);
        completeReservationPage = new CompleteReservationPage(webDriver);
        reservationsPage = new ReservationsPage(webDriver);
        reservationDetailsPage = new ReservationDetailsPage(webDriver);
    }
   @Test(invocationCount = 1)
  //  @Test
    public void reservationTest(){

        userHomePage.clickReceptionDeskButton();
        receptionDeskPage.enterReservationDate();
        receptionDeskPage.clickCheckAvailability();
        receptionDeskPage.selectFirstHotelWithPrice();
        receptionDeskPage.clickMakeReservation();
        completeReservationPage.addGuests();
        completeReservationPage.clickSaveButton();
        userHomePage.clickReservationsButton();

        boolean reservationExists = reservationsPage.findReservation(completeReservationPage.getRecentReservationId());
        if(reservationExists==false)
            System.out.println("");
        Assert.assertTrue(reservationExists);
    }
    @AfterMethod
    public void cleanup(){
        reservationsPage.clickReservation(completeReservationPage.getRecentReservationId());
        reservationDetailsPage.clickDeleteButton();
        reservationDetailsPage.clickConfirmDeleteButton();

    }
}
