package com.netsparker.pages;

import com.netsparker.utilities.BrowserUtils;
import com.netsparker.utilities.Driver;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DemoArrangementPage {

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

    public void selectDateAndTime() {
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

    public void chooseHourAndConfirm() {
        Random random=new Random();
        int index= random.nextInt(timeButton.size());
        timeButton.get(index).click();
        confirmButton.get(index).click();
    }

    public boolean unSelectDate(){
        List<WebElement> unAvailableDays=new ArrayList<>();
        Driver.get().switchTo().frame(0);
        for (WebElement day : days) {
            if (!day.isEnabled()) {
                unAvailableDays.add(day);
            }
        }
        Random random = new Random();
        int index = random.nextInt(unAvailableDays.size());
        try{
            unAvailableDays.get(index).click();
            return false;
        }catch (Exception e){
            return true;
        }
    }

    public String getMainTitleOfPage () {
        Driver.get().switchTo().defaultContent();
        return mainTitleOfPage.getText();
    }
}
