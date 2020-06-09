$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("AvivaPersonalDetails.feature");
formatter.feature({
  "line": 1,
  "name": "Car Insurance Quote details Test",
  "description": "",
  "id": "car-insurance-quote-details-test",
  "keyword": "Feature"
});
formatter.before({
  "duration": 10722589191,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Aviva Insurer quote fields",
  "description": "",
  "id": "car-insurance-quote-details-test;aviva-insurer-quote-fields",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 16,
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "line": 18,
  "name": "I am on Aviav insurance quote page",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "I should see inputs with required filed labels",
  "rows": [
    {
      "cells": [
        "First name",
        "Last name",
        "Date of birth",
        "What is your postcode?",
        "Email address",
        "Preferred telephone number"
      ],
      "line": 20
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "AvivaGetQuoteStepDefs.I_am_on_Aviav_insurance_quote_page()"
});
formatter.result({
  "duration": 5200148928,
  "status": "passed"
});
formatter.match({
  "location": "AvivaGetQuoteStepDefs.iShouldSeeInputsWithRequiredFiledLabels(DataTable)"
});
formatter.result({
  "duration": 183215357,
  "status": "passed"
});
formatter.after({
  "duration": 265174914,
  "status": "passed"
});
});