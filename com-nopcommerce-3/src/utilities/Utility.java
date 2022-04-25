package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    String actualtext;
   //this method is for clicking on element
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
    //this method is for select class
    public void selectMethod(By by, String value) {
        WebElement dropdown= driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByVisibleText(value);

    }
}
