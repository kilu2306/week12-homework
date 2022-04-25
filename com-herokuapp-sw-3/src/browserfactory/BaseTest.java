package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public void openingBrowser(String baseUrl){
        //set the property
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        //lounching browser
        driver=new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    public void closingBrowser(){
        driver.quit();
    }
}
