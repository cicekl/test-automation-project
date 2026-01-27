package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminLoginPage extends BasePage {
    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.xpath("//*[@id=\"doLogin\"]");
    private final By errorAlert = By.xpath("//*[@id=\"root-container\"]/div/div/div/div/div[2]/div/div[2]/div");

    public AdminLoginPage(WebDriver driver) {
        super(driver);
    }

    public AdminLoginPage enterUsername(String username) {
        WebElement field = driver.findElement(usernameField);
        wait(field);
        field.sendKeys(username);
        return this;
    }

    public AdminLoginPage enterPassword(String password) {
        WebElement field = driver.findElement(passwordField);
        wait(field);
        field.sendKeys(password);
        return this;
    }

    public AdminDashboardPage clickLoginButton() {
        WebElement button = driver.findElement(loginButton);
        wait(button);
        button.click();
        return new AdminDashboardPage(driver);
    }

    public boolean isErrorAlertDisplayed() {
        try {
            wait(driver.findElement(errorAlert));
            return true;
        }catch (Exception e) {
            return false;
        }
    }

}
