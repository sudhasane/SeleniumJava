package com.SeleniumTest.driver.element;


import com.SeleniumTest.Utils.PageRepository;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class DriverActions extends PageRepository {
    private final static Logger LOGGER = LoggerFactory.getLogger(DriverActions.class);


    public void clickElement(By element) {
        driver.findElement(element).click();
    }

    public void clickElements(By element, int index) {
        driver.findElements(element).get(index).click();
    }

    public void sendElement(By element, String keysToSend) {
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(keysToSend);
        Select select = new Select(driver.findElement(By.xpath("")));
        select.deselectByIndex(1);
    }

    public boolean isElementPresent(By element) {
        int elementSize = driver.findElements(element).size();
        if (elementSize >= 1) {
            return true;
        }
        return false;
    }

    public void selectOption(By locator, String visibleText) {

        //waitFor.elementPresent(locator);
        driverActions.select(locator).selectByVisibleText(visibleText);
    }

    public void selectOptionByIndex(By locator, int index) {
        find.select(locator).selectByIndex(index);
    }
    public void selectOptionByText(By locator, String text) {
        find.select(locator).selectByVisibleText(text);
    }

    Select select(By locator) {

        return new Select(element(locator));
    }

    public WebElement element(By locator) {

        for (int i = 0; i < 5; i++) {
            try {
                return driver.findElement(locator);
            }
            catch (UnhandledAlertException unhandledAlertException) {
                Times.waitForMilliSeconds(Times.SECOND_PAUSE);
            }
        }
        throw new RuntimeException("Common.findElement -> Tried 5 times to overcome unhandled alert exception before failing test");
    }


    public void refreshPage() {
        driver.navigate().refresh();
    }

    public String getElementText(By element) {
        return driver.findElement(element).getText();
    }

    public String getElementAttribute(By element) {
        return driver.findElement(element).getAttribute("text");
    }


    public void mouseOverClick(By element){
        Actions action = new Actions(driver);
        action.moveToElement(find.element(element)).perform();
    }

    public void clickElement(By locator, int index) {

        try {
            find.elements(locator).get(index).click();
        } catch (Exception e) {
            LOGGER.info("Caught " + e.getMessage() + ". Trying again.");
            waitFor.milliSeconds(Times.THREE_SECOND_PAUSE);
            waitFor.elementClickable(locator);
            find.elements(locator).get(index).click();
        }
    }

    public void scrollToBottomOfPage() {

        ((JavascriptExecutor) driver).executeScript("scroll(0,500);");
        waitFor.milliSeconds(500);
    }

    public void scrollElementIntoView(By locator) {
        waitFor.elementPresent(locator);
        scrollElementIntoView(find.element(locator));
    }

    public void scrollElementIntoView(WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", webElement);
        waitFor.milliSeconds(500);
    }

    public By customerTitle(String fieldName) {
        return By.xpath("//span[contains(text(), '" +fieldName+ "')]");
    }

    public By customerDetails(String fieldName) {
        return By.cssSelector("#PrincipalPolicyHolder_"+fieldName);
    }

}
