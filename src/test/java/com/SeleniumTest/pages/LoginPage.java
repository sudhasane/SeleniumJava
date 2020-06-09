package com.SeleniumTest.pages;

import com.SeleniumTest.Utils.PageRepository;
import org.openqa.selenium.By;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by sudha on 03/10/2018.
 */
public class LoginPage extends PageRepository {
    private static final By LOGINEMAIL = By.cssSelector("#email");
    private static final By LOGINPASSWORD = By.cssSelector("#pass");
    private static final By LOGINBUTTON = By.cssSelector("#loginbutton");
    private static final By AMAZON_ALL_OPTION = By.cssSelector("#searchDropdownBox");
    private static final By AMAZON_MENU = By.cssSelector("#nav-hamburger-menu");
    private static final By BOOKS = By.xpath("//a[@data-menu-id='11']");
    private static final By SELECT_BOOKS = By.cssSelector(".hmenu.hmenu-visible.hmenu-translateX  li:nth-child(3) ");
    private static final By BOOKS_TYPE = By.cssSelector(".a-section.octopus-pc-category-card-v2 .a-list-item:nth-child(1)");
    private static final By BOOK_NAME = By.cssSelector(".a-section.octopus-pc-category-card-v2-subcategory-title:nth-child(1)");
    private static final By BOOK_SUB_TYPE = By.cssSelector(".a-section.octopus-pc-category-card-v2-shield");
    private static final By BOOK = By.cssSelector(".octopus-pc-item-hue-shield.octopus-pc-item-image-background-v3");
    private static final By ADD_TO_BASKET_BTN = By.cssSelector("#add-to-cart-button");
    private static final By PROCEED_TO_CHECKOUT_BTN = By.cssSelector("#hlb-ptc-btn-native");




    public void gotoHomePage() throws InterruptedException {
        Thread.sleep(2000);
        assertThat("Page is not landed in home page", driver.getTitle().equalsIgnoreCase("Amazon.co.uk: Low Prices in Electronics, Books, Sports Equipment & more"));
        //driverActions.clickElement(AMAZON_ALL_OPTION);
        //driverActions.selectOption(AMAZON_ALL_OPTION, "Baby");
        driverActions.clickElement(AMAZON_MENU);
        waitFor.milliSeconds(2000);
        driverActions.clickElement(BOOKS);
        waitFor.milliSeconds(2000);
        driverActions.clickElement(SELECT_BOOKS);
        waitFor.milliSeconds(3000);
        driverActions.mouseOverClick(BOOKS_TYPE);
        waitFor.milliSeconds(3000);
        driverActions.clickElement(BOOK_NAME);
        waitFor.milliSeconds(3000);
        driverActions.clickElement(BOOK_SUB_TYPE, 0);
        waitFor.milliSeconds(1000);
        driverActions.clickElement(BOOK, 0);
        waitFor.milliSeconds(1000);
        driverActions.clickElement(ADD_TO_BASKET_BTN);
        waitFor.milliSeconds(1000);
        driverActions.clickElement(PROCEED_TO_CHECKOUT_BTN);
        waitFor.milliSeconds(4000);

    }
}
