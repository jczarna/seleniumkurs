package DriverMethods;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;

public class Zadanie1 {

    WebDriver driver;

    @BeforeEach
    public void driverSetup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1280,720));
    }

    @AfterEach
    public void closeAndQuit(){
        driver.close();
        driver.quit();
    }

    @Test
    public void zadanie(){
        driver.navigate().to("http://wikipedia.pl");
        driver.navigate().to("https://nasa.gov");
        driver.navigate().back();
        String wikiTitle = "Wikipedia, wolna encyklopedia";
        Assertions.assertEquals(wikiTitle, driver.getTitle(), "The title of the page is not " + wikiTitle);
        driver.navigate().forward();
        String nasaTitle = "NASA";
        Assertions.assertEquals(nasaTitle, driver.getTitle(), "The title of the page is not " + nasaTitle);

    }
}
