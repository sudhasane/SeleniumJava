package com.SeleniumTest.Utils;


import com.SeleniumTest.Utils.PageRepository;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverHooks extends PageRepository {
    @Before
    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", "/Users/sudha/Documents/chromedriver");
        driver = new ChromeDriver();
        //driver.get("https://www.amazon.co.uk/");
        driver.get("https://www.direct.aviva.co.uk/quote/direct/motor?source=ZVC4");
    }

    @After
    public void closebrowser() {
        driver.quit();
    }
}
