package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ForgotPasswordTest extends Utility {
    String baseurl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openingBrowser(baseurl);
    }
    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully() {
        //fing element for forgot password link and click
        clickOnElement(By.linkText("Forgot your password?"));
        //to verify text
        verifyText((By.xpath("//h1[contains(text(),'Forgot Your Password?')]")), "Forgot Your Password?", getTextfromElement((By.xpath("//h1[contains(text(),'Forgot Your Password?')]"))));
    }
    @After
    public void closing() {
        closingBrowser();
    }

}

