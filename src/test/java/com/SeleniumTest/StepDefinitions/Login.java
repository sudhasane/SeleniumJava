package com.SeleniumTest.StepDefinitions;


import com.SeleniumTest.Utils.PageRepository;
import cucumber.api.java.en.Given;

/**
 * Created by sudha on 03/10/2018.
 */
public class Login extends PageRepository {


    @Given("^I am on google home page$")
    public void i_am_on_google_home_page() throws Throwable {
        loginPage.gotoHomePage();
    }
}
