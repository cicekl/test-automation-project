import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminDashboardPage;
import pages.AdminLoginPage;

import java.time.Duration;

public class LoginTest extends BaseTest {
    private AdminLoginPage loginPage;

    @BeforeMethod
    public void setup() {
    loginPage = new AdminLoginPage(driver);
    loginPage.navigateTo("https://automationintesting.online/admin");
    }

    @Test(priority = 2)
    public void validAdminLogin() {
        AdminDashboardPage dashboard = loginPage.loginAsAdmin("admin","password");
        boolean isValid = dashboard.isOnRoomsPage();
        Assert.assertTrue(isValid);
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
    }

    @Test
    public void invalidUsernameLogin() {
        loginPage.loginAsAdmin("Admin","password");
    Assert.assertTrue(loginPage.isErrorAlertDisplayed(), "Invalid credentials");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 1)
    public void invalidPasswordLogin() {
        loginPage.loginAsAdmin("admin","password123");
        Assert.assertTrue(loginPage.isErrorAlertDisplayed(), "Invalid credentials");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
