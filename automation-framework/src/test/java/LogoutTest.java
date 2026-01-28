import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminDashboardPage;
import pages.AdminLoginPage;

public class LogoutTest extends BaseTest{
    private AdminLoginPage loginPage;
    private AdminDashboardPage dashboard;

    @BeforeMethod
    public void setup() {
        loginPage = new AdminLoginPage(driver);
        loginPage.navigateTo("https://automationintesting.online/admin");
    }

    @Test
    public void adminCanLoginAndLogout() {
        dashboard = loginPage.loginAsAdmin("admin","password");
        Assert.assertTrue(dashboard.isOnRoomsPage());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        dashboard.logout();
        Assert.assertTrue(dashboard.isLoggedOut());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
