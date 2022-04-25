package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    //public static WebDriver driver;
    String baseurl = "https://opensource-demo.orangehrmlive.com/";
    @Before
    public void setUp() {
        openingBrowser(baseurl);
    }
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        //find username field element and pass the value
        sendTextToElement(By.name("txtUsername"), ("Admin"));
        // find password field element and send key to field
        sendTextToElement(By.name("txtPassword"), ("admin123"));
        // click on submit button
        clickOnElement(By.id("btnLogin"));
        // Verify the ‘Welcome’ text is display
        verifyText((By.id("welcome")), "Welcome", getTextfromElement(By.id("welcome")).substring(0, 7));

    }
    @After
    public void closing() {
        closingBrowser();
    }
}
