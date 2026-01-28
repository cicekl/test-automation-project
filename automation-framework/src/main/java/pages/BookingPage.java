package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookingPage extends BasePage {

    private final By bookNowSuiteButton = By.xpath("/html/body/div[2]/div/div/section[2]/div/div[2]/div[3]/div/div[3]/a");
    private final By reserveNowButton1 = By.xpath("//*[@id=\"doReservation\"]");
    private final By bookingForm = By.xpath("//*[@id=\"root-container\"]/div/div[2]/div/div[2]/div/div");
    private final By checkinField = By.xpath("//*[@id=\"booking\"]/div/div/div/form/div/div[1]/div/div/input");
    private final By checkoutField = By.xpath("//*[@id=\"booking\"]/div/div/div/form/div/div[2]/div/div/input");
    private final By searchButton = By.xpath("//*[@id=\"booking\"]/div/div/div/form/div/div[4]/button");
    private final By roomColumns = By.xpath("//*[@id='rooms']//div[contains(@class,'col-md-6') and not(contains(@style,'display: none'))]");

    public BookingPage(WebDriver driver) {
        super(driver);
    }

    public BookingPage clickBookNowBtn() {
        WebElement button = driver.findElement(bookNowSuiteButton);
        scrollToElement(button);
        waitClickable(button);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        return this;
    }

    public BookingPage clickReserveNowBtn() {
        WebElement reserveButton1 = driver.findElement(reserveNowButton1);
        waitClickable(reserveButton1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", reserveButton1);
        return this;
    }

    public boolean isBookingFormDisplayed() {
        try {
            wait(driver.findElement(bookingForm));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public BookingPage setCheckinDate(String date) {
        driver.findElement(checkinField).clear();
        driver.findElement(checkinField).sendKeys(date);
        return this;
    }

    public BookingPage setCheckoutDate(String date) {
        driver.findElement(checkoutField).clear();
        driver.findElement(checkoutField).sendKeys(date);
        return this;
    }

    public BookingPage clickSearchAvailability() {
        WebElement button = driver.findElement(searchButton);
        wait(button);
        button.click();
        wait(driver.findElement(roomColumns));
        return this;
    }

    public int getAvailableRoomsCount() {
        return driver.findElements(roomColumns).size();
    }

    public boolean areExactlyThreeRoomsAvailable() {
        return getAvailableRoomsCount() == 3;
    }
}


