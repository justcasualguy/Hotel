import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import pages.detailPages.ReservationDetailsPage;
import properties.GlobalProperties;

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
       webDriver.navigate().to(GlobalProperties.getProperty("receptionDeskUrl"));

        receptionDeskPage.enterReservationDate();
        receptionDeskPage.clickCheckAvailability();
        receptionDeskPage.selectFirstHotelWithPrice();
        receptionDeskPage.clickMakeReservation();
        completeReservationPage.addGuests();
        completeReservationPage.clickSaveButton();
       webDriver.navigate().to(GlobalProperties.getProperty("reservationsUrl"));

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
