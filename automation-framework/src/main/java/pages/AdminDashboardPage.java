package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminDashboardPage extends BasePage {

    private final By roomsTable =By.xpath("//*[@id=\"root-container\"]/div/div");

    public AdminDashboardPage(WebDriver driver) {
        super(driver);
    }
    public boolean isOnRoomsPage() {
        try {
            wait(driver.findElement(roomsTable));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
