import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BookingPage;

public class BookingTest extends BaseTest{

    private BookingPage bookingPage;

    @BeforeMethod
    public void setup() {
        bookingPage = new BookingPage(driver);
        bookingPage.navigateTo("https://automationintesting.online/");
    }

    @Test(priority = 1)
    public void guestCanBookRoom() {
        bookingPage.clickBookNowBtn().
                clickReserveNowBtn();
        try { Thread.sleep(1000); } catch (Exception e) {}
        Assert.assertTrue(bookingPage.isBookingFormDisplayed());
    }

    @Test
    public void searchAvailabilityShows3Rooms() {
        bookingPage.setCheckinDate("13/02/2026")
                .setCheckoutDate("26/02/2026")
                .clickSearchAvailability();

        Assert.assertTrue(bookingPage.areExactlyThreeRoomsAvailable());
    }

}
