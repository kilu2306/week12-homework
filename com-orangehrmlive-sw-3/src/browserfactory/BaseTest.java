package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    public void openingBrowser(String baseurl) {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseurl);
        //maximize screen
        driver.manage().window().maximize();
        //apply imoplicity wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    public void closingBrowser() {
        driver.quit();
    }
}
