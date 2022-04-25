package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseurl = "https://www.saucedemo.com/";
    @Before
    public void setUp() {
        openingBrowser(baseurl);
    }
    @Test
    public void userSholdLoginSuccessfullyWithValid() {
        //find username element and  Enter “standard_user” username
        sendTextToElement(By.name("user-name"), ("standard_user"));
        //find password element and Enter “secret_sauce” password
        sendTextToElement(By.name("password"), ("secret_sauce"));
        // Click on ‘LOGIN’ button
        clickOnElement(By.name("login-button"));
        //verify text "PRODUCTS"
        verifyText((By.xpath("//span[@class='title']")), "PRODUCTS", getTextfromElement(By.xpath("//span[@class='title']")));

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //find username element and  Enter “standard_user” username
        sendTextToElement(By.name("user-name"), ("standard_user"));
        //find password element and Enter “secret_sauce” password
        sendTextToElement(By.name("password"), ("secret_sauce"));
        // Click on ‘LOGIN’ button
        clickOnElement(By.name("login-button"));
        //Verify that six products are displayed on page
        verifyText((By.className("inventory_item_name")), "6", listProdcutNumber(By.className("inventory_item_name")));
    }

    @After
    public void tearDown() {
        // closingBrowser();
    }
}

