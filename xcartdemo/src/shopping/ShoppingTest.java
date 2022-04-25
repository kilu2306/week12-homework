package shopping;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilites.Utility;

import java.util.List;

public class ShoppingTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForOllieTheAppControlledRobot() throws InterruptedException {
        /**
         * 1.1 Mouse hover on the “Hot deals” link
         *         		1.2 Mouse hover on the “Bestsellers”  link and click
         */
        actionMethod(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/descendant::span[@class='primary-title']"), (By.xpath("//ul[@class='nav navbar-nav top-main-menu']/descendant::span[@class='primary-title']//following::ul/descendant::span[contains(text()," +
                "'Bestse')]")));
        //Verify the text "Bestsellers"
        verifyText(By.xpath("//h1[@id='page-title']"), "Bestsellers", getTextFromElement(By.xpath("//h1[@id='page-title']")));
        //1.4 Mouse hover on “Sort By” and select “Name A-Z”
        actionMethod(By.xpath("//span[contains(text(),'Sort by:')]"), (By.xpath("//a[@data-sort-by='translations.name' and @data-sort-order='asc']")));
        //1.5 Click on “Add to cart” button of the product “Astro A50 halo edition
        Thread.sleep(5000);
        actionMethod(By.xpath("//div[@class='product-photo']/descendant::img[contains(@alt,'Astro A50 Halo Edition')]"),
                By.xpath("//button[contains(@class,'productid-30')]"));
        //1.6 Verify the message “Product has been added to your cart” display in  green bar
        Assert.assertEquals("Product has been added to your cart", getTextFromElement(By.xpath("//li[contains(text(),'Product has been added to your cart')]")));
        clickOnElement(By.xpath("//div[@id='status-messages']/child::a[@class='close']"));
        //1.8 Click on “Your cart” icon and Click on “View cart” button
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        //switching to the window

        //actionMethod(By.xpath("//div[contains(@class,'internal-popup items-list full-cart')]"),By.xpath("//a[contains(@class,'regular-button cart')]"));
        Thread.sleep(10000);
        //clickOnElement(By.xpath("//a[contains(@class,'regular-button cart')]/child::span"));
        // //1.9 Verify the text “Your shopping cart - 1 item”
        driver.navigate().to("https://mobile.x-cart.com/?target=cart");
        getTextFromElement(By.xpath("//h1[contains(@id,'page-title')]"));
        Assert.assertEquals("verify cart item message:", "Your shopping cart - 1 item",
                getTextFromElement(By.xpath("//h1[contains(@id,'page-title')]")));

        //verify subtotal $299.99
        List<WebElement> actualPriceList = driver.findElements(By.xpath("//ul[@class='sums']/li[1]/child::span/descendant::span[@class='surcharge-cell']/child::span"));
        StringBuilder strbul = new StringBuilder();
        for (WebElement str : actualPriceList) { // append all the list in strbul
            strbul.append(str.getText());
        }
        String actualPrice = strbul.toString();
        Assert.assertEquals("total sum:", "$299.99", actualPrice);

        //1.11 Verify the total
        List<WebElement> totalPriceList = driver.findElements(By.xpath("//li[@class='total']/descendant::span[contains(@class,'surcharge-cell')]/child::span"));
        StringBuilder strbul1 = new StringBuilder();
        for (WebElement str : totalPriceList) { // append all the list in strbul
            strbul1.append(str.getText());
        }
        String totalSum = strbul1.toString();
        Assert.assertEquals("total totalsum:", "Place order: $312.04", totalSum);
        //1.12 Click on “Go to checkout” button
        clickOnElement(By.xpath("//li[contains(@class,'button main-button')]/descendant::span"));

        //1.13 Verify the text “Log in to your account”
        Assert.assertEquals("Log in to your account", getTextFromElement(By.xpath("//h3[contains(text(),'Log in to your account')]")));
        //1.14 Enter Email address
        sendingKeyToElement(By.xpath("//input[@id='email']"), "prime99@gmail.com");
        //1.15 Click on “Continue” Button
        clickOnElement(By.xpath("//button[contains(@class,'continue-button submit')]"));
        //1.16 Verify the text “Secure Checkout”
        Assert.assertEquals("verify secure  msg:", "Secure Checkout",
                getTextFromElement(By.xpath("//h1[contains(@class,'title')]")));
        //1.17 Fill all the mandatory fields
        sendingKeyToElement(By.xpath("//input[@id='shippingaddress-firstname']"), "dhyani");
        sendingKeyToElement(By.xpath("//input[@id='shippingaddress-lastname']"), "patel");
        sendingKeyToElement(By.xpath("//input[@id='shippingaddress-street']"), "34,ramnagar soc.");
        sendingKeyToElement(By.xpath("//input[@id='shippingaddress-city']"), "surat");
        sendingKeyToElement(By.xpath("//select[@id='shippingaddress-country-code']"), "india");
        sendingKeyToElement(By.xpath("//input[@id='shippingaddress-custom-state']"), "gujrat");
        sendingKeyToElement(By.xpath("//input[@id='shippingaddress-zipcode']"), "90877");
        //1.18 Check the check box “Create an account for later use”
        clickOnElement(By.id("create_profile"));
        //1.19 Enter the password
        sendingKeyToElement(By.id("password"), "12345");
        //1.20 Select the Delivery Method to “Local Shipping”
        clickOnElement(By.id("method128"));
        //1.21 Select Payment Method “COD”
        clickOnElement(By.id("pmethod6"));
        //1.22 Verify the total $312.14
        Thread.sleep(5000);
        Assert.assertEquals("total totalsum:", "$312.14",
                getTextFromElement(By.xpath("//button[contains(@type,'submit')]/child::span[contains(text(),' $312.04')]")));
        //1.23 Click on “Place Order” Button
        clickOnElement(By.xpath("By.xpath(\"//button[contains(@type,'submit')]/child::span[contains(text(),' $312.04')]\"))"));
        //1.24 Verify the text “Thank you for your order”
    }
        @Test
        public void verifyThatUserShouldClearShoppingCartSuccessfully () throws InterruptedException {
//        1.1 Mouse hover on the “Hot deals” link
//        1.2 Mouse hover on the “Bestseller”  link and click
            actionMethod(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/descendant::span[@class='primary-title']"), (By.xpath("//ul[@class='nav navbar-nav top-main-menu']/descendant::span[@class='primary-title']//following::ul/descendant::span[contains(text()," +
                    "'Bestse')]")));
//        1.3 Verify the text “Bestsellers”
            verifyText(By.xpath("//h1[@id='page-title']"), "Bestsellers", getTextFromElement(By.xpath("//h1[@id='page-title']")));
            //1.4 Mouse hover on “Sort By” and select “Name A-Z”
            actionMethod(By.xpath("//span[contains(text(),'Sort by:')]"), (By.xpath("//a[@data-sort-by='translations.name' and @data-sort-order='asc']")));
//        1.5 Click on “Add to cart” button of the product “apple watch "
            actionMethod(By.xpath("//img[contains(@alt,'Apple Watch Sport')]"), By.xpath("//button[contains(@class,' product-add2cart productid-39')]"));
            //1.6 Verify the message “Product has been added to your cart” display in  green bar
            Assert.assertEquals("verify msg:", "Product has been added to your cart", getTextFromElement(By.xpath("//li[contains(text(),'Product has been added to your cart')]")));
            //1.8 Click on “Your cart” icon and Click on “View cart” button
            clickOnElement(By.xpath("//div[contains(@title,'Your cart')]"));
            Thread.sleep(5000);
            clickOnElement(By.xpath("//a[@class='regular-button cart']/child::span"));
            //1.9 Verify the text “Your shopping cart - 1 item”
            Assert.assertEquals("verify text:", "Your shopping cart - 1 item", getTextFromElement(By.xpath("//h1[@id='page-title']")));
            //1.10 Click on “Empty your cart” link
            clickOnElement(By.xpath("//a[contains(text(),'Empty your cart')]"));
            //1.11 Verify the text “Are you sure you want to clear your cart?” on alert
            Alert alert = driver.switchTo().alert();
            alert.accept();
            //1.13 Verify the message “Item(s) deleted from your cart”
            Assert.assertEquals("verify text ", "Item(s) deleted from your cart", getTextFromElement(By.xpath("//li[contains(text(),'Item(s) deleted from your cart')]")));
            //1.15 Verify the text “Your cart is empty”
            Thread.sleep(5000);
            Assert.assertEquals("verify text:", "Your cart is empty", getTextFromElement(By.xpath("//h1[contains(text(),'Your cart is empty')")));
        }

    }