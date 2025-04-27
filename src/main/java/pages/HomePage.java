package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterLocation(String location) {
//    	driver.findElement(By.id("city")).click();
    	WebElement Location =  driver.findElement(By.id("search-flyout-mobile-input"));
    	Location.click();
    	Location.sendKeys(location);
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	List<WebElement> options = driver.findElements(By.xpath("//li[@class='sc-dhKdcB eawgMc']//li"));
		for (WebElement option : options) {
           if (option.getText().contains("New York")) {  
           option.click();
           break;  
           }
       }
    }

    public void enterDates(String checkInDate, String checkOutDate) {
    	driver.findElement(By.xpath("//label[text()='Check-in Date']")).click();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	 driver.findElement(By.xpath("(//div[@class='vms_DateRangeCalendar_Date_Container']//div[contains(@value,'Apr 30 2025 ')])[1]")).click();
         driver.findElement(By.xpath("(//div[@class='vms_DateRangeCalendar_Date_Container']//div[contains(@value,'May 06 2025 ')])[1]")).click();
     	driver.findElement(By.xpath("//button[text()='Done']")).click();
    }

    public void searchHotels() {
    	
        driver.findElement(By.xpath("//button[text()='Search']")).click();
    }
}

