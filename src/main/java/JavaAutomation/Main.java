package JavaAutomation;

import java.time.Duration;
import java.util.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait a max 10 seconds

        // Set implicit wait to handle implicit waits for all elements
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String url = "https://www.demoblaze.com/index.html";
        driver.get(url);

        //Prints out Current URL
        System.out.println("Homepage URL is " + driver.getCurrentUrl());

//        //Top Nav Bar
        driver.findElement(By.xpath("//ul[@class='navbar-nav ml-auto']"));

//        //Clicking Home button from Nav Bar
        driver.findElement(By.xpath("(//a[@class='nav-link'])[1]")).click();

//        //Prints URL after clicking Home button
        System.out.println("Url after clicking Home button: " + driver.getCurrentUrl());

//        //Clicking Laptop from Categories Section
        driver.findElement(By.xpath("//a[3]")).click();


//        //Selecting MacBook Pro
        driver.findElement(By.xpath("(//a[normalize-space()='MacBook Pro'])[1]")).click();

//        //Add To Cart page
        System.out.println("Add to cart page: " + driver.getCurrentUrl());

//        //Clicking Add To Cart Button
        try {
            // Clicking Add To Cart Button
            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Add to cart'])[1]")));
            addToCartButton.click();

            // Wait for the alert and interact with it
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println(alert.getText());
            alert.accept();
        }
        catch (NoAlertPresentException e){
            System.out.println("No alert present");
        }
//        catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        driver.close();
        driver.quit();
    }
}
