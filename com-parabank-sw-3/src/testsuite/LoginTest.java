package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilties.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    //.userShouldLoginSuccessfullyWithValidCredentials
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter valid username
        sendTextToElement(By.name("username"), ("abha"));
        //Enter valid password
        sendTextToElement(By.name("password"), ("12345"));
        //Click on ‘LOGIN’ button
        clickOnElement(By.cssSelector("[value='Log In']"));
        //to verify account view text is disolayed
        verifyText((By.xpath("//h1[contains(text(),'Accounts Overview')]")), "Accounts Overview", getTextfromElement((By.xpath("//h1[contains(text(),'Accounts Overview')]"))));
    }

    @Test
    //verifyTheErrorMessage
    public void verifyTheErrorMessage() {
        //enter invalid user name and password
        sendTextToElement(By.name("username"), ("abha23"));
        //Enter invalid password
        sendTextToElement(By.name("password"), ("12345678"));
        //Click on ‘LOGIN’ button
        clickOnElement(By.cssSelector("[value='Log In']"));
        //find the error msg and verify text
        verifyText((By.xpath("//p[starts-with(text(),'An internal error')]")),
                "The username and password could not be verified.",
                getTextfromElement(By.xpath("//p[starts-with(text(),'An internal error')]")));
    }

    @Test
    //.userShouldLogOutSuccessfully
    public void userShouldLogOutSuccessfully() {
        //Enter valid username
        sendTextToElement(By.name("username"), ("abha"));
        //Enter valid password
        sendTextToElement(By.name("password"), ("12345"));
        //Click on ‘LOGIN’ button
        clickOnElement(By.cssSelector("[value='Log In']"));
        //click on log out
        clickOnElement(By.xpath("//a[starts-with(text(),'Log Out')]"));
        //verify text customer log in
        verifyText((By.xpath("//h2[contains(text(),'Customer Login')]")),
                "Customer Login", getTextfromElement(By.xpath("//h2[contains(text(),'Customer Login')]")));
    }

    @After
    public void tearDown() {
        //   closingBrowser();
    }
}
