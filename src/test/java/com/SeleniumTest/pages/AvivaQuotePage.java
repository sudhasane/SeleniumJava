package com.SeleniumTest.pages;

import com.SeleniumTest.Utils.PageRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;

public class AvivaQuotePage extends PageRepository {
    private static final By QUOTEPAGE = By.cssSelector(".a-heading.a-heading--1");
    private static final By FIND_ADDRESS = By.cssSelector("#addressLookup");
    private static final By ADDRESS_DROPDOWN = By.xpath("//select[@class='a-dropdown__select selectMultiplePostCode']");
    private static final By CONTINUE_BTN = By.cssSelector("#continueButton");
    private static final By FIRSTNAME_LABEL = By.xpath("//label[@for='PrincipalPolicyHolder_FirstName']");
    private static final By FIRSTNAME_INPUT = By.cssSelector("#PrincipalPolicyHolder_FirstName");

    public By customerTitle(String fieldName) {
        return By.xpath("//span[contains(text(), '" + fieldName + "')]");
    }

    public By customerDetails(String fieldName) {
        return By.cssSelector("#PrincipalPolicyHolder_" + fieldName);
    }

    public void gotoAvivaQuotePage() {
        waitFor.milliSeconds(5000);
        assertThat("Driver is not landed on getQuotePage", find.element(QUOTEPAGE).getText().equalsIgnoreCase("Your details"));
    }

    public void enterPolicyHolderDetails(String fieldName, String inputValue) {
        driverActions.scrollElementIntoView(customerDetails(fieldName));
        driverActions.sendElement(customerDetails(fieldName), inputValue);
    }

    public void selectAddress(){
        waitFor.milliSeconds(2000);
        driverActions.clickElement(FIND_ADDRESS);
        waitFor.milliSeconds(2000);
        driverActions.selectOptionByIndex(ADDRESS_DROPDOWN, 1);
        waitFor.milliSeconds(2000);
    }

    public void clickContine(){
        driverActions.clickElement(CONTINUE_BTN);
    }

    public void fillInsurerDetails(String fieldName, String value){
        if(fieldName.equals("First name")){
            enterPolicyHolderDetails("First name", value);
        }
    }

    public void  verifyInputElementPresence(String fieldName){
        assertThat("Input field "+fieldName +" did not match",driverActions.getElementText(By.xpath("//label[contains(text(), '" + fieldName + "')]")).equalsIgnoreCase(fieldName));

    }

}