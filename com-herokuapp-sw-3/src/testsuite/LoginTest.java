package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openingBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        //find email eleemnt and enter  “tomsmith” username
        sendTextToElement(By.id("username"), ("tomsmith"));
        //find password element and Enter “SuperSecretPassword!” password
        sendTextToElement(By.id("password"), ("SuperSecretPassword!"));
        //click on log in button
        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        //Verify the error message "Secure Area"
        verifyText(By.xpath("//div[@class=\"example\"]/child::h2"), "Secure Area", getTextfromElement(By.xpath("//div[@class=\"example\"]/child::h2")));
    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        //find email eleemnt and  Enter “tomsmith” username
        sendTextToElement(By.id("username"), ("tomsmith1"));
        //find password element and Enter “SuperSecretPassword” password
        sendTextToElement(By.id("password"), ("SuperSecretPassword!"));
        //click on log in button
        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        //* Verify the error message “Your password is invalid!”
        verifyText((By.id("flash")), "Your username is invalid!", getTextfromElement(By.id("flash")));
    }

    @Test
    public void verifyThePasswordErrorMessag() {
        //find email eleemnt and  Enter “tomsmith” username
        sendTextToElement(By.id("username"), ("tomsmith"));
        //find password element and Enter “SuperSecretPassword” password
        sendTextToElement(By.id("password"), ("SuperSecretPassword"));
        //click on log in button
        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        //* Verify the error message “Your password is invalid!”
        verifyText((By.xpath("//div[@id='flash']")), "Your password is invalid!", getTextfromElement(By.xpath("//div[@id='flash']")));
    }

    @After
    public void tearDown() {
        closingBrowser();
    }


}
