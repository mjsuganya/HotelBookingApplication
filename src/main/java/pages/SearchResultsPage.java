package pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage {
    WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectFirstHotel() {
//        WebElement firstHotel = driver.findElement(By.xpath("(//p[@id='hlistpg_hotel_name'])[1]"));
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	WebElement firstHotel = driver.findElement(By.xpath("(//div[@class='SearchDetailWidget_inner-title-section__mKFBl']//h3)[1]"));
        firstHotel.click();
        String MainWindow = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        System.out.println("Child window handle is" + s1);
        Iterator<String> i1 = s1.iterator();
        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
             }
        }
        
    }
    
    public void bookHotel() {
    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
    	driver.findElement(By.xpath("(//button[text()='Reserve Now'])[1]")).click();
    }
}

