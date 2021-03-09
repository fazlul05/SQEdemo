package com.sample.test.demo.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import java.util.List;

public class ElementActions {

    WebDriver driver;
    Actions action;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElement(By locator) {
        WebElement element = null;
        try {
            element = driver.findElement(locator);
        } catch (Exception e) {
            System.out.println("some exception occurred while creating the webelement : " + locator);
        }
        return element;
    }

    public void doClick(By locator) {
        getElement(locator).click();
    }

    public void doActionsClick(By locator) {
        action.click(getElement(locator)).build().perform();
    }

    public void doSendKeys(By locator, String value) {
        getElement(locator).sendKeys(value);
    }

    public boolean doIsDisplayed(By locator) {
        return getElement(locator).isDisplayed();
    }

    public String doGetText(By locator) {
        return getElement(locator).getText();
    }

    public void waitForElementVisible(By locator) {
        WebElement ele = getElement(locator);
    }

    public void selectByVisibleText(By locator, String value) {
        WebElement ele = getElement(locator);
        Select select = new Select(ele);
        List<WebElement> pizzaOptions = select.getOptions();
        for (int i = 0; i < pizzaOptions.size(); i++) {
            pizzaOptions.get(i).click();
        }
        select.selectByVisibleText(value);
    }

}