package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTes extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {
        //find computer element and click on computer
        clickOnElement(By.linkText("Computers"));
        // Verify the text ‘Computers
        verifyText((By.linkText("Computers")), "Computers", getTextfromElement((By.linkText("Computers"))));
    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {
        //find electronics element and click
        clickOnElement(By.linkText("Electronics"));
        verifyText((By.linkText("Electronics")), "Electronics", getTextfromElement((By.linkText("Electronics"))));
    }
    @Test
    public void userShouldNavigateToApparelPageSuccessfully() {
        //find appearel element and click
        clickOnElement(By.linkText("Apparel"));
        //  Verify the text ‘Apparel’
       verifyText((By.linkText("Apparel")), "Apparel", getTextfromElement((By.linkText("Apparel"))));
    }
    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully(){
        //find element and click on the ‘Digital downloads’ Tab
        clickOnElement(By.linkText("Digital downloads"));
        // Verify the text ‘Digital downloads’
        verifyText((By.linkText("Digital downloads")),"Digital downloads",getTextfromElement((By.linkText("Digital downloads"))));
    }
    @Test
    public void userShouldNavigateToBooksPageSuccessfully(){
        //click on the ‘Books’ Tab
       clickOnElement(By.linkText("Books"));
        // Verify the text ‘Books’
        verifyText((By.linkText("Books")),"Books",getTextfromElement((By.linkText("Books"))));
    }
    @Test
    public void userShouldNavigateToJewelryPageSuccessfully(){
        // click on the ‘Jewelry’ Tab
       clickOnElement(By.linkText("Jewelry"));
        // Verify the text ‘Jewelry’
        verifyText((By.linkText("Jewelry")),"Jewelry",getTextfromElement((By.linkText("Jewelry"))));
    }
    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully(){
        // click on the ‘Gift Cards’ Tab
       clickOnElement(By.linkText("Gift Cards"));
        // Verify the text ‘Gift Cards’
       verifyText((By.linkText("Gift Cards")),"Gift Cards",getTextfromElement(By.linkText("Gift Cards")));
    }
    @After
    public void tearDown(){
        closingBrowser();
    }
}





