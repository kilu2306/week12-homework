package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        // * click on the ‘Sign In’ link
        clickOnElement(By.linkText("Sign In"));
        //Verify the text ‘Welcome Back!’
        verifyText(By.xpath("//h1[@class='page__heading']"), "Welcome Back!", getTextfromElement(By.xpath("//h1[@class='page__heading']")));
    }

    @Test
    public void verifyTheErrorMessage() {
        // * click on the ‘Sign In’ link
        clickOnElement(By.linkText("Sign In"));
        //Enter invalid username
        sendTextToElement(By.id("user[email]"), ("kinju111@gmail.com"));
        // Enter invalid password
        sendTextToElement(By.id("user[password]"), ("12345"));
        clickOnElement(By.xpath("//input[@type='submit']"));
        //Verify the error message ‘Invalid email or password.
        String actualtext = driver.findElement(By.xpath("//li[@class='form-error__list-item' or role='alert']")).getText();
        String expectedText = "Invalid email or password.";
        verifyText(By.xpath("//li[@class='form-error__list-item' or role='alert']"),
                "Invalid email or password.",
                getTextfromElement(By.xpath("//li[@class='form-error__list-item' or role='alert']")));
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
