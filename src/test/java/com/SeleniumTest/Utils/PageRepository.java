package com.SeleniumTest.Utils;

import com.SeleniumTest.driver.element.DriverActions;
import com.SeleniumTest.driver.element.Times;
import com.SeleniumTest.driver.element.WaitFor;
import com.SeleniumTest.driver.element.Find;
import com.SeleniumTest.driver.javascript.JsConditions;
import com.SeleniumTest.pages.*;


import org.openqa.selenium.WebDriver;

public class PageRepository {

    public static WebDriver driver;
    public static DriverActions driverActions = new DriverActions();
    public static LoginPage loginPage = new LoginPage();
    public static AvivaQuotePage quotePage = new AvivaQuotePage();
    public static DriverHooks driverHooks=new DriverHooks();
    public static Times times = new Times();
    public static WaitFor waitFor = new WaitFor();
    public static JsConditions jsConditions = new JsConditions();
    public static Find find = new Find();

}
