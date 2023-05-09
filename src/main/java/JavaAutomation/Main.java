package JavaAutomation;

import java.time.Duration;
import java.util.*;
import java.io.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        String url = "https://www.demoblaze.com/index.html";
        driver.get(url);

        //Prints out Current URL
        System.out.println("Homepage URL is " + driver.getCurrentUrl());
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Top Nav Bar
        driver.findElement(By.xpath("//ul[@class='navbar-nav ml-auto']"));

        //Clicking Home button from Nav Bar
        driver.findElement(By.xpath("(//a[@class='nav-link'])[1]")).click();

        //Prints URL after clicking Home button
        System.out.println("Url after clicking Home button: " + driver.getCurrentUrl());

        //Clicking Laptop from Categories Section
        driver.findElement(By.xpath("//a[3]")).click();

        //Waiting 5 seconds for Element to be displayed
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Selecting MacBook Pro
        driver.findElement(By.xpath("(//a[normalize-space()='MacBook Pro'])[1]")).click();

        //Add To Cart page
        System.out.println("Add to cart page: " + driver.getCurrentUrl());

        //Clicking Add To Cart Button
        driver.findElement(By.xpath("(//a[normalize-space()='Add to cart'])[1]")).click();
        Thread.sleep(1000);

        //Accepting And Clicking OK For Product Added Alert PopUp
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        driver.close();
    }
}
