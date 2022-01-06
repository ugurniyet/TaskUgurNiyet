package com.netsparker.pages;

import com.netsparker.utilities.BrowserUtils;
import com.netsparker.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DemoArrangementPage {

    //Page factory class used the implicitly create the located elements with annotations
    public DemoArrangementPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "td>button")
    public List<WebElement> days;

    @FindBy(xpath = "//button[@data-container='time-button']")
    public List<WebElement> timeButton;

    @FindBy(xpath = "//button[@data-container='confirm-button']")
    public List<WebElement> confirmButton;

    @FindBy(xpath = "(//form//button)[2]")
    public WebElement scheduleEventButton;

    @FindBy(xpath = "//h1[.='Now select a time on the calendar below:']")
    public WebElement mainTitleOfPage;

    //This is method to select date and time of the demo meeting.
    //All days (available or not) are taken into a list. Then the available days are saved in a list
    //Random method is used to click on a random day. Same principles are also applied for hours.
    public void chooseDateAndTime() {
        List<WebElement> availableDays=new ArrayList<>();
        Driver.get().switchTo().frame(0);
        for (WebElement day : days) {
            if (day.isEnabled()) {
                availableDays.add(day);
            }
        }
        Random random=new Random();
        int index= random.nextInt(availableDays.size());
        availableDays.get(index).click();
        BrowserUtils.waitForPageToLoad(5);
       chooseHourAndConfirm();
        BrowserUtils.waitForPageToLoad(5);
    }

    //same logic as choose date
    public void chooseHourAndConfirm() {
        Random random=new Random();
        int index= random.nextInt(timeButton.size());
        timeButton.get(index).click();
        BrowserUtils.waitForPageToLoad(3);
        confirmButton.get(index).click();
    }

    /*
     In this method, unavailable days are collected into a list
     A random unavailable day is clicked. This will/should create an exception.
     Then the exception is handled with try catch block. If there is no exception, case will fail.
     */
    public boolean unavailableDates(){
        List<WebElement> unavailableDays=new ArrayList<>();
        Driver.get().switchTo().frame(0);
        for (WebElement day : days) {
            if (!day.isEnabled()) {
                unavailableDays.add(day);
            }
        }
        Random random = new Random();
        int index = random.nextInt(unavailableDays.size());
        try{
            unavailableDays.get(index).click();
            return false;
        }catch (Exception e){
            return true;
        }
    }

    //This method is used to get the largest title in the page.
    public String getMainTitleOfPage () {
        Driver.get().switchTo().defaultContent();
        return mainTitleOfPage.getText();
    }
}
