package com.SeleniumTest.driver.element;

import com.SeleniumTest.Utils.PageRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitFor extends PageRepository {

    public void milliSeconds(long milliseconds) {

        Times.waitForMilliSeconds(milliseconds);
    }

    public void elementPresent(By locator) {

        elementPresent(locator, Times.TWENTY_SECOND_WAIT);
    }

    public void elementPresent(By locator, int waitTime) {
        wait(jsConditions.elementPresent(locator), waitTime);
    }

    private void wait(ExpectedCondition<?> expCondition, int waitTime) {

        for (int i = 1; i < 4; i++) {
            try {
                new WebDriverWait(driver, waitTime).until(jsConditions.refreshed(expCondition));
                return;
            }
            catch (TimeoutException | UnreachableBrowserException te) {
                throw te;
            }
            catch (WebDriverException wde) {
                //                logWarning("Caught WebDriverException " + i + " times");
                Times.waitForMilliSeconds(Times.TWENTY_SECOND_WAIT);
            }
        }
        throw new RuntimeException("Webdriver exception failed more than 3 times");
    }

    public void elementClickable(By locator, int waitTime) {

        wait(jsConditions.elementClickable(locator), waitTime);
    }

    public void elementClickable(By locator) {

        elementClickable(locator, Times.TWENTY_SECOND_WAIT);
    }
}
