package com.SeleniumTest.driver.element;

import com.SeleniumTest.Utils.PageRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Find extends PageRepository {
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

    public List<WebElement> elements(By locator) {

        for (int i = 0; i < 5; i++) {
            try {
                return driver.findElements(locator);
            }
            catch (UnhandledAlertException unhandledAlertException) {
                Times.waitForMilliSeconds(Times.SECOND_PAUSE);
            }
        }
        throw new RuntimeException("Common.findElements -> Tried 5 times to overcome unhandled alert exception before failing test");
    }

    Select select(By locator) {

        return new Select(element(locator));
    }


}
