package com.netsparker.step_definitions;

import com.netsparker.pages.Locators;
import com.netsparker.utilities.BrowserUtils;
import com.netsparker.utilities.ConfigurationReader;
import com.netsparker.utilities.Driver;
import io.cucumber.java.en.Given;

public class TaskStepDefs extends Locators {

    @Given("Task")
    public void task() {
        Driver.get().get(ConfigurationReader.get("url"));
        productsButton.click();
        BrowserUtils.waitForPageToLoad(5);
        mensClothingButton.click();
        BrowserUtils.waitForPageToLoad(5);
        allTshirtsButton.click();
        BrowserUtils.waitForPageToLoad(5);
        requestedTshirt.click();
        BrowserUtils.waitForPageToLoad(5);
        blackColor.click();
        BrowserUtils.waitForPageToLoad(5);
        sizeLbutton.click();


    }


}
