package com.netsparker.step_definitions;

import com.netsparker.pages.DemoArrangementPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class DemoArrangementStepDefs {


    @Then("user should be able to select date and time")
    public void user_should_be_able_to_select_date_and_time() {
        new DemoArrangementPage().selectDateAndTime();
    }

    @Then("user should go to schedule page")
    public void user_should_go_to_schedule_page() {
        Assert.assertTrue( new DemoArrangementPage().scheduleEventButton.isDisplayed());
    }

    @Then("unavailable days should not be selectable")
    public void unavailable_days_should_be_selectable() {
        Assert.assertTrue(new DemoArrangementPage().unSelectDate());
    }

    @Then("main title on the page should change from {string}")
    public void main_title_on_the_page_should_change_from(String expectedMainTitle) {
        String actualMainTitle = new DemoArrangementPage().getMainTitleOfPage();
        Assert.assertFalse(expectedMainTitle.equalsIgnoreCase(actualMainTitle));
    }



}
