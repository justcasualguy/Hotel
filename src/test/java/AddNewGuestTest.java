import models.Guest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.detailPages.GuestDetailsPage;
import pages.GuestsPage;
import pages.detailPages.RegisteredGuestDetailsPage;
import pages.detailPages.ReservationDetailsPage;
import pages.formPages.NewGuestFormPage;
import pages.UserHomePage;
import pages.formPages.NewRegisteredGuestFormPage;
import pages.formPages.NewReservationFormPage;
import properties.GlobalProperties;

public class AddNewGuestTest extends TestBase {
    Guest guest;
    UserHomePage userHomePage;
    GuestsPage guestsPage;
    GuestDetailsPage guestDetailsPage;
    NewGuestFormPage newGuestFormPage;
    NewRegisteredGuestFormPage newRegisteredGuestFormPage;
    NewReservationFormPage newReservationFormPage;
    ReservationDetailsPage reservationDetailsPage;
    RegisteredGuestDetailsPage registeredGuestDetailsPage;

    @BeforeClass
    public void setup() {
        guest = new Guest("Adam", "Badam", "xyz123456");

        userHomePage = new UserHomePage(webDriver);
        guestsPage = new GuestsPage(webDriver);
        newGuestFormPage = new NewGuestFormPage(webDriver);
        guestDetailsPage = new GuestDetailsPage(webDriver);
        newRegisteredGuestFormPage = new NewRegisteredGuestFormPage(webDriver);
        newReservationFormPage = new NewReservationFormPage(webDriver);
        reservationDetailsPage = new ReservationDetailsPage(webDriver);
        registeredGuestDetailsPage = new RegisteredGuestDetailsPage(webDriver);
    }

    @Test
    public void addNewGuest() {
        int registeredGuestsCount;
        webDriver.navigate().to(GlobalProperties.getProperty("guestsUrl"));
        guestsPage.clickNewGuestButton();
        newGuestFormPage.addGuest(guest);
        guestDetailsPage.clickRelatedTab();
        registeredGuestsCount = guestDetailsPage.getRegisteredGuestsListSize();
        guestDetailsPage.clickNewRegisteredGuestButton();
        newRegisteredGuestFormPage.clickSearchReservationBar();
        newRegisteredGuestFormPage.clickNewReservationButton();
        newReservationFormPage.enterReservationDate();
        newReservationFormPage.clickSaveButton();
        newRegisteredGuestFormPage.clickSaveButton();

        Assert.assertNotEquals(guestDetailsPage.getRegisteredGuestsListSize(),
                registeredGuestsCount);
    }

    @AfterMethod
    public void cleanup() {
        guestDetailsPage.clickRegisteredGuest();
        registeredGuestDetailsPage.clickReservationDetailLink();
        reservationDetailsPage.deleteReservation();
        userHomePage.clickGuestsButton();
        guestsPage.clickGuestDetailsLink(guest.getFirstName());
        guestDetailsPage.deleteGuest();

    }
}
