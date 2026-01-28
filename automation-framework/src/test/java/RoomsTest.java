import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminDashboardPage;
import pages.AdminLoginPage;

public class RoomsTest extends BaseTest{
    private AdminLoginPage loginPage;

    @BeforeMethod
    public void setup() {
        loginPage = new AdminLoginPage(driver);
        loginPage.navigateTo("https://automationintesting.online/admin");
    }

    @Test
    public void adminCanCreateNewRoom() {
        AdminDashboardPage dashboard = loginPage.loginAsAdmin("admin","password");

        boolean[] checkboxes = {true, true, false, true, false, false};

        String roomName = "62";

        dashboard.createRoom(roomName, "Family","true","300",checkboxes);

        Assert.assertTrue(dashboard.isRoomCreated(roomName));
    }
}
