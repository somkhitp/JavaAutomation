package JavaAutomation;

import java.time.Duration;
import java.util.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
            driver.findElement(By.xpath("(//a[normalize-space()='Add to cart'])[1]")).click();

            //Accepting And Clicking OK For Product Added Alert PopUp
            Alert alert = driver.switchTo().alert();
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
