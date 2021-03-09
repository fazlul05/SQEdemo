package com.sample.test.demo.tests;

import com.sample.test.demo.util.ElementActions;
import org.codehaus.plexus.interpolation.SimpleRecursionInterceptor;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.sample.test.demo.TestBase;

public class DemoTest extends TestBase {
    ElementActions elementActions = new ElementActions(driver);
    String pageTitle = "Pizza Order Form";
    String popUpModal = "Thank you for your order!";
    String userName="123456789";

    /*
    Locators
     */
    By pizza1 = By.id("pizza1Pizza");
    By pizza1Toppings1 = By.xpath("//div[@id='pizza1']//select[@class='toppings1']");
    By pizza1Toppings2 = By.xpath("//div[@id='pizza1']//select[@class='toppings2']");
    By pizza1Quantity = By.id("pizza1Qty");
    By pizza1Cost = By.id("pizza1Cost");
    By name = By.id("name");
    By email = By.id("email");
    By phone = By.id("phone");
    By radioCreditCard = By.id("ccpayment");
    By radioCash = By.id("cashpayment");
    By placeOrderButton = By.id("placeOrder");
    By resetButton = By.id("reset");
    By dialog = By.id("dialog");
    By dialogText = By.xpath("//div[@id='dialog']/p");

    @Test
    public void demoTest() {
        System.out.println("HELLO WORLD");
    }

    @Test
    public void PlaceOrderForPizza_WithCardPaymentHappyPath() {

        elementActions.selectByVisibleText(pizza1, "Small 6 Slices - no toppings");
        elementActions.selectByVisibleText(pizza1Toppings1, "Diced Mango");
        elementActions.selectByVisibleText(pizza1Toppings2, "Mushrooms");
        elementActions.doSendKeys(pizza1Quantity, "2");
        elementActions.doGetText(pizza1Cost);
        elementActions.doSendKeys(name, "Fazlul");
        elementActions.doSendKeys(email, "fazlul@gmail.com");
        elementActions.doSendKeys(phone, "1234567890");
        elementActions.doClick(radioCreditCard);
        elementActions.doClick(placeOrderButton);
        elementActions.doIsDisplayed(dialog);
        String text = elementActions.doGetText(dialogText);
        String title = driver.getTitle();
        Assert.assertEquals(title, pageTitle);
        Assert.assertEquals(text, popUpModal);
    }

    @Test
    public void PlaceOrderForPizza_WithCashPaymentHappyPath() {
    }

    @Test
    public void happyPathWithToppings1Only() {
    }

    @Test
    public void happyPathWithToppings2Only() {
    }

    @Test
    public void happyPathWithToppings1_andToppings2() {
    }

    @Test
    public void verifyQuantityShouldBeOnlyNumericData() {
    }

    @Test
    public void verifySumCostOf_2smallPizzaWithBothToppings() {
    }

    @Test
    public void verifyNamefieldAcceptOnlyStringData() {
    }

    @Test
    public void verifyPhoneNumberAcceptOnlyNumericData() {
    }

    @Test
    public void verifyBothPaymentOptionIsNotSelected() {
    }

    @Test
    public void verifyTheResetButtonAfterInsertingData() {
    }

    @Test
    public void verifyModalPopupAfterPlaceOrder() {
    }

    @Test
    public void errorWhilePassingStringValueInQuantity() {
    }

    //defect
    @Test
    public void nameCannotBeNumericData() {
        elementActions.selectByVisibleText(pizza1, "Small 6 Slices - no toppings");
        elementActions.selectByVisibleText(pizza1Toppings1, "Diced Mango");
        elementActions.selectByVisibleText(pizza1Toppings2, "Mushrooms");
        elementActions.doSendKeys(pizza1Quantity, "2");
        elementActions.doGetText(pizza1Cost);
        elementActions.doSendKeys(name, "userName");
        String title = driver.getTitle();
        Assert.assertEquals(title, pageTitle);
        String nameText=elementActions.doGetText(name);
        Assert.assertFalse(Boolean.parseBoolean(nameText));

    }
}
