# Selenium Test Automation Framework

## Project Overview
This project is an automated UI testing framework for the demo web application  
https://automationintesting.online/.
The goal of the project is to verify core functionalities of the application
using Selenium WebDriver and TestNG.

## Tools & Technologies
- Java – programming language used for writing test scripts
- Selenium WebDriver – for browser automation and UI testing
- TestNG – testing framework for test execution, assertions and test management
- Maven – build and dependency management tool
- WebDriverManager – for automatic management of browser drivers
- Page Object Model (POM) – design pattern used for better test structure and maintainability

## Test Description
### Booking Tests
- **guestCanBookRoom**  
  Verifies that a guest user can start the room booking process by clicking
  "Book Now" and "Reserve Now" buttons and that the booking form is displayed.

- **searchAvailabilityShows3Rooms**  
  Verifies that searching room availability for selected check-in and check-out
  dates displays exactly three available rooms.

### Login Tests
- **validAdminLogin**  
  Verifies that an admin user can successfully log in with valid credentials
  and is redirected to the rooms dashboard page.

- **invalidUsernameLogin**  
  Verifies that an error message is displayed when an invalid username is used.

- **invalidPasswordLogin**  
  Verifies that an error message is displayed when an invalid password is used.

### Logout Tests
- **adminCanLoginAndLogout**  
  Verifies that an admin user can successfully log in and log out of the
  application.

### Room Management Tests
- **adminCanCreateNewRoom**  
  Verifies that an admin user can create a new room with selected room type,
  price and amenities, and that the newly created room is visible in the rooms list.

## Cross-Browser Testing

The automated tests are configured to run on multiple browsers in order to
ensure cross-browser compatibility.

Supported browsers:
- Google Chrome
- Mozilla Firefox
- Microsoft Edge

## Screenshots
<img width="1106" height="358" alt="{FDFB2019-733C-4A2B-AE0B-F0D2CF41AACC}" src="https://github.com/user-attachments/assets/f1469802-44ba-4b7b-bb1d-b4729efa1523" />
