package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AdminDashboardPage extends BasePage {

    private final By roomsTable = By.xpath("//*[@id=\"root-container\"]/div/div");
    private final By createRoomButton = By.id("createRoom");
    private final By roomNameField = By.id("roomName");
    private final By roomTypeField = By.id("type");
    private final By isRoomAccessibleField = By.id("accessible");
    private final By roomPriceField = By.id("roomPrice");
    private final By wifiCheckbox = By.xpath("//*[@id=\"wifiCheckbox\"]");
    private final By tvCheckbox = By.xpath("//*[@id=\"tvCheckbox\"]");
    private final By radioCheckbox = By.xpath("//*[@id=\"radioCheckbox\"]");
    private final By refreshCheckbox = By.xpath("//*[@id=\"refreshCheckbox\"]");
    private final By safeCheckbox = By.xpath("//*[@id=\"safeCheckbox\"]");
    private final By viewsCheckbox = By.xpath("//*[@id=\"viewsCheckbox\"]");
    private final By logoutButton = By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[2]/li[2]/button");

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

    private void setCheckbox(By locator, boolean enabled) {
        WebElement checkbox = driver.findElement(locator);
        wait(checkbox);
        if (checkbox.isSelected() != enabled) {
            checkbox.click();
        }
    }

    public AdminDashboardPage createRoom(String roomName, String roomType, String isAccessible, String roomPrice, boolean checkboxes[]) {
        WebElement nameField = driver.findElement(roomNameField);
        wait(nameField);
        nameField.sendKeys(roomName);

        WebElement typeField = driver.findElement(roomTypeField);
        wait(typeField);
        Select typeSelect = new Select(typeField);
        typeSelect.selectByValue(roomType);

        WebElement accessibleField = driver.findElement(isRoomAccessibleField);
        wait(accessibleField);
        Select accessibleSelect = new Select(accessibleField);
        accessibleSelect.selectByValue(isAccessible);

        WebElement priceField = driver.findElement(roomPriceField);
        wait(priceField);
        priceField.sendKeys(roomPrice);

        setCheckbox(wifiCheckbox, checkboxes[0]);
        setCheckbox(tvCheckbox, checkboxes[1]);
        setCheckbox(radioCheckbox, checkboxes[2]);
        setCheckbox(refreshCheckbox, checkboxes[3]);
        setCheckbox(safeCheckbox, checkboxes[4]);
        setCheckbox(viewsCheckbox, checkboxes[5]);

        WebElement button = driver.findElement(createRoomButton);
        wait(button);
        button.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return this;
    }

    public boolean isRoomCreated(String roomName) {
        List<WebElement> roomRows = driver.findElements(
                By.xpath("//*[contains(@class, 'row') or @data-testid='room-listing']//*[contains(text(), '" + roomName + "')]")
        );

        return !roomRows.isEmpty();
    }

    public AdminDashboardPage logout() {
        WebElement logoutBtn = driver.findElement(logoutButton);
        wait(logoutBtn);
        logoutBtn.click();
        return this;
    }

    public boolean isLoggedOut() {
        try {
            wait(driver.findElement(logoutButton));
            return true;
        }catch (Exception e) {
            return false;
        }
    }

}