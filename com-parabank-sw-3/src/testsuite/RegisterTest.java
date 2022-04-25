package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilties.Utility;

public class RegisterTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    //1.verifyThatSigningUpPageDisplay
    public void signingUpPageDisplay() {
        //click to register link
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        //Verify the text ‘Signing up is easy!’
        verifyText((By.xpath("//h1[text()='Signing up is easy!']")), "Signing up is easy!", getTextfromElement(By.xpath("//h1[text()='Signing up is easy!']")));
    }

    @Test
    public void userSholdRegisterAccountSuccessfully() {
        //click on the ‘Register’ link
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        //* send key to first name
        sendTextToElement(By.id("customer.firstName"), ("priya"));
        //* Enter Last name
        sendTextToElement(By.id("customer.lastName"), ("patel"));
        //Enter Address
        sendTextToElement(By.id("customer.address.street"), ("16 london road"));
        // enter city
        sendTextToElement(By.id("customer.address.city"), ("sheffild"));
        //Enter State
        sendTextToElement(By.id("customer.address.state"), ("southyourkshire"));
        //Enter Zip Code
        sendTextToElement(By.id("customer.address.zipCode"), ("s7 out"));
        // Enter Phone
        sendTextToElement(By.id("customer.phoneNumber"), ("7658937475"));
        //Enter SSN
        sendTextToElement(By.id("customer.ssn"), ("23456"));
        //Enter Username
        sendTextToElement(By.id("customer.username"), ("abha"));
        //* Enter Password
        sendTextToElement(By.id("customer.password"), ("12345"));
        //* Enter Confirm
        sendTextToElement(By.id("repeatedPassword"), ("12345"));
        //* Click on REGISTER button
        clickOnElement(By.xpath("//input[@value='Register']"));
        //verify the text 'Your account was created successfully. You are now logged in.’
        verifyText((By.xpath("//p[starts-with(text(),'Your account')]")),
                "Your account was created successfully. You are now logged in.",
                getTextfromElement(By.xpath("//p[starts-with(text(),'Your account')]")));
    }
    @After
    public void tearDown() {
        closingBrowser();
    }
}