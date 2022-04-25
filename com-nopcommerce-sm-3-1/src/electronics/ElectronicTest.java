package electronics;

import Utilities.Utility;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElectronicTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com";

    @Before
    public void setUp() {
        openbrowser(baseUrl);
    }

    @Test
    public void textVerifiedMethod() {

//        1.1 Mouse Hover on “Electronics”T
//        1.2 Mouse Hover on “Cell phones” and click
        actionMethod(By.linkText("Electronics"),
                By.xpath("//ul[@class=\"top-menu notmobile\"]/li[2]/child::ul//child::li[2]//child::a"));
//        1.3 Verify the text “Cell phones”
        verifyText(By.xpath("//h1[contains(text(),'Cell phones')]"), "Cell phones",
                getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]")));
    }

    @Test

    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
//            2.1 Mouse Hover on “Electronics”Tab
//            2.2 Mouse Hover on “Cell phones” and click
        actionMethod(By.linkText("Electronics"),
                By.xpath("//ul[@class=\"top-menu notmobile\"]/li[2]/child::ul//child::li[2]//child::a"));

//            2.3 Verify the text “Cell phones”
        verifyText(By.xpath("//h1[contains(text(),'Cell phones')]"), "Cell phones",
                getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]")));
//                2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
//            2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(3000);
        clickOnElement(By.xpath("//a[contains(text(),'Nokia Lumia 1020')]"));
//            2.6 Verify the text “Nokia Lumia 1020”
        verifyText(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"), "Nokia Lumia 1020",
                getTextFromElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]")));
//            2.7 Verify the price “$349.00”
        verifyText(By.xpath("//span[@id='price-value-20']"), "$349.00",
                getTextFromElement(By.xpath("//span[@id='price-value-20']")));
//               2.8 Change quantity to 2

        WebElement element = driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']"));
        element.clear();
        element.sendKeys("2");
        Thread.sleep(3000);
//            2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));
//    2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        verifyText(By.xpath("//div[@class=\"bar-notification success\"]/child::p"), "The product has been added to your shopping cart",
                getTextFromElement(By.xpath("//div[@id='bar-notification']/div[1]/p[1]")));
//            After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//div[@class=\"bar-notification success\"]/descendant::span"));
        Thread.sleep(3000);
//            2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        actionMethod(By.xpath("//li[@id='topcartlink']"), By.xpath("//button[contains(text(),'Go to cart')]"));
//        2.12 Verify the message "Shopping cart"
        verifyText(By.xpath("//h1[contains(text(),'Shopping cart')]"),"Shopping cart",
                getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]")));
//        2.13 Verify the quantity is
       String totalPrice=getTextFromElement(By.xpath("//span[@class=\"product-subtotal\"]"));
       Double totalprice1=Double.valueOf(totalPrice.replace("$",""));
       System.out.println(totalprice1);
       String eachPrice =getTextFromElement(By.xpath("//span[@class=\"product-unit-price\"]"));
       Double eachprice1=Double.valueOf(eachPrice.replace("$",""));
        System.out.println(eachprice1);
        double quantity;
        if(totalprice1/eachprice1==2){
              quantity =totalprice1/eachprice1;
        String quantity1= String.valueOf(quantity);
        Assert.assertEquals("verify quantiy :","2.0",quantity1);}
//        2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
//        2.16 Click on checkout
        clickOnElement(By.xpath("//button[@id='checkout']"));

//“2.17 Verify the Text “Welcome, Please Sign In!”
        verifyText(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"),"Welcome, Please Sign In!",getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]")));
//        2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
//        2.19 Verify the text “Register”
        verifyText(By.xpath("//h1[contains(text(),'Register')]"),"Register",getTextFromElement(By.xpath("//h1[contains(text(),'Register')]")));

//        2.20 Fill the mandatory fields
        sendingKeyToElement(By.xpath("//input[@id='FirstName']"),"kinjal");
        sendingKeyToElement(By.xpath("//input[@id='LastName']"),"patel");
        sendingKeyToElement(By.xpath("//input[@id='Email']"),"prime2323@gmail.com");
        sendingKeyToElement(By.xpath("//input[@id='Password']"),"1233456");
        sendingKeyToElement(By.xpath("//input[@id='ConfirmPassword']"),"1233456");
         Thread.sleep(3000);
//        2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));
//        2.22 Verify the message “Your registration completed”
        verifyText(By.xpath("//div[contains(text(),'Your registration completed')]"),"Your registration completed",getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]")));
//        2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
//        2.24 Verify the text “Shopping cart”
        verifyText(By.xpath("//h1[contains(text(),'Shopping cart')]"),"Shopping cart",getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]")));
//        2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id=\"termsofservice\"]"));
//        2.26 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
//        2.27 Fill the Mandatory fields
        sendingKeyToElement(By.id("BillingNewAddress_FirstName"),"kinjal");
        sendingKeyToElement(By.id("BillingNewAddress_LastName"),"patel");
        sendingKeyToElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"india");
        sendingKeyToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"gujrat");
        sendingKeyToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"6, coniston road");
        sendingKeyToElement(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"),"maharastra");
       sendingKeyToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"2345");
       sendingKeyToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"098677892");
//        2.28 Click on “CONTINUE”
        Thread.sleep(5000);
        clickOnElement(By.xpath("//button[@class=\"button-1 new-address-next-step-button\" and @name=\"save\"]"));
//        2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_2']"));
//        2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//div[@id=\"shipping-method-buttons-container\"]/descendant::button"));
//        2.31 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//div[@id='payment-method-buttons-container']/descendant::button"));

//        2.32 Select “Visa” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"),"Visa");
//        2.33 Fill all the details
        sendingKeyToElement(By.xpath("//input[@id='CardholderName']"),"kinjal");
        sendingKeyToElement(By.xpath("//input[@id='CardNumber']"),"4111111111111111");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"),"06");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"),"2025");
        sendingKeyToElement(By.xpath("//input[@id='CardCode']"),"2344");

//        2.34 Click on “CONTINUE”CHECKOUT”
        clickOnElement(By.xpath("//div[@id=\"payment-info-buttons-container\"]/descendant::button"));
//        2.35 Verify “Payment Method” is “Credit Card”
        verifyText(By.xpath("//span[contains(text(),'Credit Card')]"),"Credit Card",getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]")));
//        2.36 Verify “Shipping Method” is “2nd Day Air”
        verifyText(By.xpath("//span[contains(text(),'Shipping Method:')]"),"Shipping Method:",getTextFromElement(By.xpath("//span[contains(text(),'Shipping Method:')]")));
//        2.37 Verify Total is “$698.00”
        verifyText(By.xpath("//tr[@class=\"order-total\"]//span[@class=\"value-summary\"]"),"$698.00",
                getTextFromElement(By.xpath("//tr[@class=\"order-total\"]//span[@class=\"value-summary\"]")));
//        2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
//        2.39 Verify the Text “Thank You”
        verifyText(By.xpath("//h1[contains(text(),'Thank you')]"),"Thank you",getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]")));
//        2.40 Verify the message “Your order has been successfully processed!”
        verifyText(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"),"Your order has been successfully processed!",
                getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]")));
//        2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
//        2.42 Verify the text “Welcome to our store”
        verifyText(By.xpath("//h2[contains(text(),'Welcome to our store')]"),"Welcome to our store",
                getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]")));
//        2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[@class=\"ico-logout\"]"));

//        2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String url=driver.getCurrentUrl();
        Assert.assertEquals("verify url:","https://demo.nopcommerce.com/",url);
//

//
//
//

    }
}





