package computer;

import homepage.TopMenuTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSuit extends TopMenuTest {
    String baseUrl = "https://demo.nopcommerce.com";

    @Before
    public void setUp() {
        openbrowser(baseUrl);
    }

    @Test
    public void name() throws InterruptedException {

//	1.1 Click on Computer Menu.
        selectMenu("Computers");
//            1.2 Click on Desktop
        selectMenu("Desktops");
        // Mouse hover on “Sort By” and select “Price low-high and getting pricelist  before filter
        List<WebElement> beforepricelists = driver.findElements(By.xpath("//div[@class='prices']"));
        //converting in double for price
        List<Double> beforFilterprodcutprice = new ArrayList<>();
        Thread.sleep(5000);
        //removing$ from price and storing in double datatype
        for (WebElement value : beforepricelists) {
            beforFilterprodcutprice.add(Double.valueOf(value.getText().replace("$", "")));
        }
        List<WebElement> beforepricelists1 = driver.findElements(By.xpath("//div[@class='prices']"));
        //converting in double for price
        List<Double> beforFilterprodcutprice1 = new ArrayList<>();
        Thread.sleep(5000);
        //removing$ from price and storing in double datatype
        for (WebElement value : beforepricelists1) {
            beforFilterprodcutprice.add(Double.valueOf(value.getText().replace(",", "")));
        }
        //clicking on high to low price filter
        clickOnElement(By.xpath("(By.xpath(\"//select[@id='products-orderby']\")"));
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Price: Low to High");
        // store the all product price
        Thread.sleep(5000);
        List<WebElement> afterpicelists = driver.findElements(By.xpath("//select[@id='products-orderby']"));
        //converting in double
        List<Double> afterFilterPriceList = new ArrayList<>();
        //removing $ and,from price
        for (WebElement value : afterpicelists) {
            afterFilterPriceList.add(Double.valueOf(value.getText().replace("$", "")));
        }
        List<WebElement> afterpicelists1 = driver.findElements(By.xpath("//select[@id='products-orderby']"));
        //converting in double
        List<Double> afterFilterPriceList1 = new ArrayList<>();
        //removing $ and,from price
        for (WebElement value : afterpicelists1) {
            afterFilterPriceList.add(Double.valueOf(value.getText().replace(",", "")));
        }
        //sorting data
        Collections.sort(beforFilterprodcutprice, Collections.reverseOrder());
        Thread.sleep(5000);
        // // Verify that the product’s price arrange low to high
        Assert.assertEquals("verify pricelist starting low to high ", beforFilterprodcutprice, afterFilterPriceList);

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Click on Computer Menu.
        selectMenu("Computers");
        //	2.2 Click on Desktop
        selectMenu("Desktops");
        //	2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: A to Z");
        //2.4 Click on "Add To Cart"
        actionMethod(By.xpath("//div[@class=\"picture\"]/descendant::img[@alt='Picture of Build your own computer']"),
                By.xpath("//div[@class=\"buttons\"]/child::button"));
        //	2.5 Verify the Text "Build your own computer"
        verifyText(By.linkText("Build your own computer"), "Build your own computer", getTextFromElement(By.linkText("Build your own computer")));
        //	2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_1']"),
                "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]");
        //	2.7.Select "8GB [+$60.00]" using Select class.
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_2']"), "8GB [+$60.00]");
        //	2.8 Select HDD radio "400 GB [+$100.00]"
        Thread.sleep(5000);
        clickOnElement(By.id("product_attribute_3_7"));
        //	2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.id("product_attribute_4_8"));
        //A2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        Thread.sleep(2000);
        clickOnElement(By.id("product_attribute_5_10"));
        clickOnElement(By.id("product_attribute_5_12"));
        Thread.sleep(3000);
        //	2.11 Verify the price "$1,475.00"
        verifyText(By.xpath("//span[@id='price-value-1']"), "$1,430.00", getTextFromElement(By.xpath("//span[@id='price-value-1']")));
        //2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));

        verifyText(By.xpath("//p[@class=\"content\"]"), "The product has been added to your shopping cart",
                getTextFromElement(By.xpath("//p[@class=\"content\"]")));
        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//p[@class=\"content\"]/following-sibling::span"));
        //	2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Thread.sleep(5000);
        actionMethod(By.xpath("//span[contains(text(),'Shopping cart')]"), By.xpath("//button[contains(text(),'Go to cart')]"));
        //	2.15 Verify the message "Shopping cart"
        verifyText(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart",
                getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]")));
       //	2.16 Change the Qty to "2" and Click on "Update shopping cart"
        Thread.sleep(5000);
        WebElement quantity = driver.findElement(By.xpath("//td[@class=\"quantity\"]/child::input"));
        quantity.clear();
        quantity.sendKeys("2");
        actionMethod(By.xpath("//tbody/tr[1]/td[4]"), By.xpath("//button[@id='updatecart']"));
        //	2.17 Verify the Total"$2,950.00"
        verifyText(By.xpath("//tr[@class=\"order-total\"]/child::td//following::td/child::span"), "$2,860.00",
                getTextFromElement(By.xpath("//tr[@class=\"order-total\"]/child::td//following::td/child::span")));
        //	2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id=\"termsofservice\"]"));

        //	2.19 Click on “CHECKOUT”
        actionMethod(By.xpath("//div[@class=\"checkout-buttons\"]"), By.xpath("//button[@id='checkout']"));

        //	2.20 Verify the Text “Welcome, Please Sign In!”
        verifyText(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "Welcome, Please Sign In!",
                getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]")));
       //	2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//strong[contains(text(),'Checkout as a guest or register')]"));
       //	2.22 Fill the all mandatory field
        actionMethod(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]"),
                By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        //        2.22 Fill the all mandatory field
        sendingKeyToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"kinjal");
        sendingKeyToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"patel");
        sendingKeyToElement(By.xpath("//input[@id='BillingNewAddress_Email']"),"prime367@gmail.com");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"United States");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"),"Alabama");
        sendingKeyToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"gujrat");
        sendingKeyToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"4, ramnagar");
        sendingKeyToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"5684");
        sendingKeyToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"3468992");
        sendingKeyToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"gujrat");

        //        2.23 Click on “CONTINUE”
        Thread.sleep(3000);
        clickOnElement(By.xpath("//button[@onclick=\"Billing.save()\"]"));
        //        2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));

       //       2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick=\"ShippingMethod.save()\"]"));
       //        2.26 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        Thread.sleep(5000);
        clickOnElement(By.xpath("//button[@onclick=\"PaymentMethod.save()\"]"));
        Thread.sleep(5000);
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"),"MasterCard");
        //        2.28 Fill all the details
        sendingKeyToElement(By.xpath("//input[@id='CardholderName']"),"kinjal");
        sendingKeyToElement(By.xpath("//input[@id='CardNumber']"),"555555576879556");
        sendingKeyToElement(By.xpath("//select[@id='ExpireMonth']"),"10");
        sendingKeyToElement(By.xpath("//select[@id='ExpireYear']"),"2067");
        sendingKeyToElement(By.xpath("//input[@id='CardCode']"),"678");

//        2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick=\"ShippingMethod.save()\"]"));

//        2.30 Verify “Payment Method” is “Credit Card”
        verifyText(By.xpath("//span[contains(text(),'Credit Card')]"),"Payment Method: Credit Card",getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]")));
//        2.32 Verify “Shipping Method” is “Next Day Air”
        verifyText(By.xpath("//span[contains(text(),'Shipping Method:')]"),"Shipping Method:Next Day Air",getTextFromElement(By.xpath("//span[contains(text(),'Shipping Method:')]")));
//        2.33 Verify Total is “$2,950.00”
        verifyText(By.xpath("//span[@class=\"value-summary\"]/child::strong"),"$2,950.00",getTextFromElement(By.xpath("//span[@class=\"value-summary\"]/child::strong")));
//        2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
//        2.35 Verify the Text “Thank You”
        verifyText(By.xpath("//h1[contains(text(),'Thank you')]"), "Thank you",getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]")));
//        2.36 Verify the message “Your order has been successfully processed!”
        verifyText(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"),
              "Your order has been successfully processed!'",getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]")));
//        2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
//        2.37 Verify the text “Welcome to our store”
        verifyText(By.xpath("//h2[contains(text(),'Welcome to our store')]"),"Welcome to our store",getTextFromElement(By.xpath("Welcome to our store")));


    }

}