package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class RegisterTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        //  click on the register link
        clickOnElement(By.linkText("Register"));
        //Verify the text ‘Register
        verifyText((By.linkText("Register")), "Register", getTextfromElement((By.linkText("Register"))));
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //click on the ‘Register’ link
        clickOnElement(By.linkText("Register"));
        //Select gender radio button
        clickOnElement(By.id("gender-female"));
        // find element and send key in first name field
        sendTextToElement(By.id("FirstName"), ("kinjal"));
        // send key to last name field
        sendTextToElement(By.id("LastName"), ("savani"));
        //Select Day Month and Year
        selectMethod((By.name("DateOfBirthDay")), "10");
        selectMethod((By.name("DateOfBirthMonth")), "April");
        selectMethod((By.name("DateOfBirthYear")), "1988");
        // Enter Email address
        sendTextToElement(By.id("Email"), ("pkinju888@gmail.com"));
        //enter password
        sendTextToElement(By.id("Password"), ("123456"));
        //confirm password
        sendTextToElement(By.id("ConfirmPassword"), ("123456"));
        // Click on REGISTER button
        clickOnElement(By.id("register-button"));
        //* Verify the text 'Your registration completed
        verifyText((By.xpath("//div[@class='result']")), "Your registration completed", getTextfromElement((By.xpath("//div[@class='result']"))));

    }

    @After
    public void tearDown() {
//        closingBrowser();
    }
}
