package homepage;

import Utilities.Utility;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com";
    public void selectMenu(String menu) {
        clickOnElement(By.linkText(menu));
    }
    @Before
    public void setUp() {
        openbrowser(baseUrl);
    }
    @Test
    public void verifyPageNavigation() {
//	.use selectMenu method to select the Menu and
//	click on it and verify the page navigation.
        selectMenu("Electronics");
        Assert.assertEquals("verify text:", "Electronics",
                getTextFromElement(By.xpath("//h1[contains(text(),'Electronics')]")));
    }
}
