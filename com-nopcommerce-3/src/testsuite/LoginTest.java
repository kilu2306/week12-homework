package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateLoginPageSuccessfully() {
        // find log in link element and click on link
        clickOnElement(By.xpath("//a[contains(text(),'Log in')]"));
        //this is from requitement
        String expectedText = "Welcome, Please Sign In!";
        //validate actual and expected text
        verifyText((By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]")), "Welcome, Please Sign In!", getTextfromElement((By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"))));
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        clickOnElement(By.linkText("Log in"));
        // find emailfield element and send key
        sendTextToElement(By.name("Email"), "pkinju108@gmail.com");
        //find password field element and send key
        sendTextToElement(By.id("Password"), "123456");
        //find log in element and click on login button
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));
        //Verify the ‘Log out’ text is display
        verifyText((By.linkText("Log out")), "Log out", getTextfromElement((By.linkText("Log out"))));
    }

    @Test
    public void verifyTheErrorMessage() {
        clickOnElement(By.linkText("Log in"));
        //this is from requitement
        sendTextToElement(By.name("Email"), ("kinjal109@gmail.com"));
        sendTextToElement(By.id("Password"), ("Prime123"));
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));
        //verify text
        verifyText((By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]")),
                "Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found",
                getTextfromElement((By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]"))));
    }

    @After
    public void tearDown() {
//      closingBrowser();
    }

}
