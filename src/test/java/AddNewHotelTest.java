import models.Hotel;
import models.Room;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class AddNewHotelTest extends TestBase {
    Hotel hotel;
    UserHomePage userHomePage;
    HotelsPage hotelsPage;
    NewHotelFormPage newHotelFormPage;
    HotelDetailsPage hotelDetailsPage;
    NewRoomFormPage newRoomFormPage;
    @BeforeClass
    public void setup() {
        hotel = new Hotel(
                "Hotel Transylvania",
                "Transylvania",
                "Bloody",
                "666"
                );
        hotel.addRoom(new Room(1,100));
        hotel.addRoom(new Room(2,200));
        userHomePage = new UserHomePage(webDriver);
        hotelsPage = new HotelsPage(webDriver);
        newHotelFormPage = new NewHotelFormPage(webDriver);
        hotelDetailsPage = new HotelDetailsPage(webDriver);
        newRoomFormPage = new NewRoomFormPage(webDriver);
    }

    @Test
    public void addHotelTest() {
        userHomePage.clickHotelsButton();
        hotelsPage.clickNewButton();
        newHotelFormPage.addHotel(hotel);
        hotelDetailsPage.addRooms(hotel.getRooms());
        Hotel createdHotel = new Hotel(
                hotelDetailsPage.getHotelName(),
                hotelDetailsPage.getCity(),
                hotelDetailsPage.getStreet(),
                hotelDetailsPage.getZipCode()
        );


        Assert.assertEquals(
                hotelDetailsPage.getRoomsCount(),hotel.getRooms().size(),"Rooms assert"
        );
    }

    @AfterMethod
    public void cleanup() {
        hotelDetailsPage.clickDeleteButton();
        hotelDetailsPage.clickConfrimDeleteButton();
    }
}
