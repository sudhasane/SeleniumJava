package com.SeleniumTest.driver.javascript;

import org.jruby.javasupport.Java;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JsConditions {

    public static ExpectedCondition<WebElement> elementPresent(final By locator) {

        return ExpectedConditions.presenceOfElementLocated(locator);
    }

    public static <T> ExpectedCondition<T> refreshed(final ExpectedCondition<T> condition) {

        return new ExpectedCondition<T>() {
            @Override
            public T apply(WebDriver driver) {

                try {
                    return condition.apply(driver);
                }
                catch (StaleElementReferenceException e) {
                    return null;
                }
                catch (UnhandledAlertException unhandledAlertException) {
                    return null;
                }
            }

            @Override
            public String toString() {

                return String.format("%s", condition);
            }
        };
    }

    public ExpectedCondition<WebElement> elementClickable(By locator) {

        return ExpectedConditions.elementToBeClickable(locator);
    }

    public static ExpectedCondition<WebElement> elementVisible(final By locator) {
        return ExpectedConditions.visibilityOfElementLocated(locator);
    }
}
