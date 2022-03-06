import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest {
    @Test
    public void demoTest(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1295,730));

        driver.navigate().to("https://google.pl");
        //WebElement agreeField = driver.findElement(By.xpath(//*[@id="L2AGLb"]/div));
        driver.findElement(new By.ByXPath("/html/body/div[2]/div[2]/div[3]/span/div/div/div/div[3]/button[2]/div")).click();
        WebElement searchField = driver.findElement(By.cssSelector("[title='Szukaj']"));
        String searchEntry = "wszechświaty równoległe";
        String title = "Wieloświat – Wikipedia, wolna encyklopedia";
        searchField.sendKeys(searchEntry);
        searchField.submit();
        //driver.findElement(By.xpath(".//*[text()='" +title + "']")).click();
        driver.findElement(By.xpath("/html/body/div[7]/div/div[10]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[1]/div/a/h3")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.titleIs(title));

        String entryURL = "https://pl.wikipedia.org/wiki/Wielo%C5%9Bwiat";
        Assertions.assertEquals(entryURL, driver.getCurrentUrl(), "URL is not correct.");
        driver.quit();
    }

}
