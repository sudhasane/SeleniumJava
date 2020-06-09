package com.SeleniumTest.Utils;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by sudha on 03/10/2018.
 */

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin = {"html:target/cucumber-html-report"},
        features = {"./src/test/resources/features"},
        glue = {"com.SeleniumTest"}, tags = {"@smoke"})

public class CucumberTest {

}
