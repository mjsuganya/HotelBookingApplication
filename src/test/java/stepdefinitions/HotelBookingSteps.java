package stepDefinitions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.*;
import pages.BookingPage;
import pages.HomePage;
import pages.SearchResultsPage;

public class HotelBookingSteps {
    WebDriver driver;
    HomePage homePage;
    SearchResultsPage searchResultsPage;
    BookingPage bookingPage;

    @Given("User opens the hotel booking application")
    public void openHotelBookingApplication() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.goindigo.in/hotels?linkNav=BookHotels%7C%7CHeader%20Menu");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        bookingPage = new BookingPage(driver);
    }

    @When("User searches for hotels in {string} from {string} to {string}")
    public void searchForHotels(String location, String checkInDate, String checkOutDate) {
        homePage.enterLocation(location);
        homePage.enterDates(checkInDate, checkOutDate);
    }

    @And("User selects the first hotel from the search results")
    public void selectFirstHotel() {
        searchResultsPage.selectFirstHotel();
        searchResultsPage.bookHotel();
    }

    @And("User applies the coupon code {string}")
    public void applyCouponCode(String couponCode) {
        bookingPage.applyCoupon(couponCode);
    }

    @Then("The discount should be applied correctly")
    public void verifyDiscountApplied() {
        String discount = bookingPage.getDiscountAmount();
        Assert.assertEquals(discount, "Expected Discount Value"); // Replace with the actual expected value
    }

    @And("proceeds to checkout page")
    public void proceedToCheckoutWithoutPayment() {
        bookingPage.proceedToCheckout();
        System.out.println("Proceeded to checkout. Test completed without payment.");
        driver.quit();
    }
}
