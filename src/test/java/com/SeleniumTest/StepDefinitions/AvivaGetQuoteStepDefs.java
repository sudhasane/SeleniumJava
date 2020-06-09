package com.SeleniumTest.StepDefinitions;

import com.SeleniumTest.Utils.PageRepository;
import com.SeleniumTest.pages.AvivaQuotePage;
import com.oracle.tools.packager.windows.WinServiceBundler;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AvivaGetQuoteStepDefs extends PageRepository {

    @Given("^I am on Aviav insurance quote page$")
    public void I_am_on_Aviav_insurance_quote_page() {
        quotePage.gotoAvivaQuotePage();
    }

    @And("^I fill following insurer personal details$")
    public void I_fill_following_personal_details(DataTable individualDetails) {
        Map<String, String> insurerDetails = individualDetails.asMap(String.class, String.class);
        find.element(quotePage.customerTitle(insurerDetails.get("Title"))).click();
        quotePage.enterPolicyHolderDetails("FirstName", insurerDetails.get("First name"));
        quotePage.enterPolicyHolderDetails("LastName", insurerDetails.get("Last name"));
        quotePage.enterPolicyHolderDetails("DateOfBirthDay", insurerDetails.get("DateOfBirthDay"));
        quotePage.enterPolicyHolderDetails("DateOfBirthMonth", insurerDetails.get("DateOfBirthMonth"));
        quotePage.enterPolicyHolderDetails("DateOfBirthYear", insurerDetails.get("DateOfBirthYear"));
        quotePage.enterPolicyHolderDetails("PostCode", insurerDetails.get("PostCode"));
        quotePage.selectAddress();
        quotePage.enterPolicyHolderDetails("EmailAddress", insurerDetails.get("EmailAddress"));
        quotePage.enterPolicyHolderDetails("TelephoneNumber", insurerDetails.get("TelephoneNumber"));
        quotePage.clickContine();
    }

    @And("^I click on continue button$")
    public void iClickOnContinueButton() {
        quotePage.clickContine();
    }

    @Then("^error message should be displayed$")
    public void errorMessageShouldBeDisplayed(DataTable mandatoryFieldsErrors) {
        List<List<String>> errorMessages = mandatoryFieldsErrors.raw();

    }

    @When("^I fill insurer personal details$")
    public void iFillInsurerPersonalDetails(DataTable insurerInfo) {
        List<List<String>> quoteDetails = insurerInfo.raw();
        for (int i = 0; i <= quoteDetails.size(); i++) {
            System.out.println("This is size " + quoteDetails.get(0));
        }
    }

    @Then("^I should see inputs with required filed labels$")
    public void iShouldSeeInputsWithRequiredFiledLabels(DataTable insurerQuoteDetails) {
        System.out.println("This is comarsion "+"apple".compareTo("banana"));
        List<String> insurerQuoteLabels = insurerQuoteDetails.asList(String.class);
        for ( String text: insurerQuoteLabels) {
            quotePage.verifyInputElementPresence(text);
        }
    }
}
