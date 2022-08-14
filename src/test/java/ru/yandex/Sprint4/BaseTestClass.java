package ru.yandex.Sprint4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTestClass {
    WebDriver driver;

 //Google Chrome Test
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    //Firefox Test
//    @Before
//    public void setup() {
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
