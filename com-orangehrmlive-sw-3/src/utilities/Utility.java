package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Utility  extends BaseTest {
    String actualtext;
    public void clickOnElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }
    // this method is for getting text from element
    public String getTextfromElement(By by) {
        return driver.findElement(by).getText();
    }
    // this method is for sending key to element
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }
    // this method is  for verify text
    public void verifyText(By by, String expactedText, String actualtext) {
        this.actualtext = getTextfromElement(by);
        Assert.assertEquals("verify text:", expactedText, actualtext);
    }
}
