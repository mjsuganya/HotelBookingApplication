package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingPage {
    WebDriver driver;

    public BookingPage(WebDriver driver) {
        this.driver = driver;
    }
    

    public void applyCoupon(String couponCode) {
    	driver.findElement(By.xpath("//input[@placeholder='Enter promo code']")).sendKeys(couponCode);
    	 driver.findElement(By.cssSelector(".apply-btn ")).click();
    }

    public String getDiscountAmount() {
        return driver.findElement(By.xpath("//div[@class='CheckoutPage_payable-amt-value__YRiq3']")).getText();
    }

    public void proceedToCheckout() {
        driver.findElement(By.cssSelector(".vms_button")).click();
    }
}
