package com.netsparker.step_definitions;

import com.netsparker.pages.QaTestingPage;
import com.netsparker.utilities.BrowserUtils;
import com.netsparker.utilities.ConfigurationReader;
import com.netsparker.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class QaTestingStepDefs {

    @Given("the user is on qa-testing website")
    public void the_user_is_on_qa_testing_website() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("user enters the following {string},{string},{string},{string},{string}")
    public void user_enters_the_following(String firstName,String lastName,String workEmail,String company,String phone) {
        new QaTestingPage().fillUserInfo(firstName,lastName,workEmail,company,phone);
    }

    @When("user clicks on get a demo button")
    public void user_clicks_on_get_a_demo_button() {
        new QaTestingPage().getDemoButton.click();
        BrowserUtils.waitForPageToLoad(5);
    }

    @Then("user should land on getting started page")
    public void user_should_land_on_getting_started_page() {
       String expectedUrl="https://www.netsparker.com/getting-started/";
        String actualUrl = Driver.get().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @Then("user should see a warning and stay on the same page")
    public void user_should_see_a_warning_and_stay_on_the_same_page() {
        int errorMessageCount = new QaTestingPage().getErrorMessageCount();
        String expectedUrl="https://www.netsparker.com/qa-testing/";
        String actualUrl = Driver.get().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        Assert.assertTrue("No Error Message is Detected", errorMessageCount>0);
    }


    @When("the user clicks on the flag button in telephone input")
    public void the_user_clicks_on_the_flag_button_in_telephone_input() {
        BrowserUtils.scrollByPixel(0,500);
        new QaTestingPage().phoneCodeFlagButton.click();
    }

    @Then("country phone code list dropdown should open")
    public void country_phone_code_list_dropdown_should_open() {
        Assert.assertFalse(new QaTestingPage().countryList.isEmpty());

    }
    @Then("preferred countries {string}, {string} should be on top of the list")
    public void preferred_countries_should_be_on_top_of_the_list(String preferredCountry1, String preferredCountry2) {
        String actualPreferredCountries = new QaTestingPage().preferredCountries();
        Assert.assertTrue(actualPreferredCountries.contains(preferredCountry1));
        Assert.assertTrue(actualPreferredCountries.contains(preferredCountry2));
    }

    @Then("all input boxes should have same size")
    public void all_input_boxes_should_have_same_size() {
       boolean verifyInputBoxSize = new QaTestingPage().verifyInputBoxSize();
       Assert.assertTrue("Difference in input box sizes has been detected",verifyInputBoxSize);
    }

    @Then("buttons for paragraphs should have the same color code")
    public void buttons_for_paragraphs_should_have_the_same_color_code() {
        boolean verifyColor = new QaTestingPage().verifyButtonColors();
        Assert.assertTrue("Difference in color codes has been detected",verifyColor);
    }

    @Then("user should see please use your work email warning and stay on the same page")
    public void user_should_see_please_use_your_work_email_warning_and_stay_on_the_same_page() {
        String expectedUrl="https://www.netsparker.com/qa-testing/";
        String actualUrl = Driver.get().getCurrentUrl();
        Assert.assertEquals("page URL has changed",expectedUrl,actualUrl);

        String expectedErrorMessage = "Please use your work email.";
        String actualErrorMessage = new QaTestingPage().getMailErrorMessage();
        Assert.assertEquals("Error message not seen or not as expected",expectedErrorMessage,actualErrorMessage);
    }






}
