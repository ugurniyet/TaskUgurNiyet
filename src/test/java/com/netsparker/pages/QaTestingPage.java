package com.netsparker.pages;

import com.netsparker.utilities.BrowserUtils;
import com.netsparker.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;


public class QaTestingPage {

    //Page factory class used the implicitly create the located elements with annotations
    public QaTestingPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy (xpath = "(//*[@id='ContactName'])[1]")
    public WebElement firstNameButton;

    @FindBy (xpath = "(//*[@id='ContactLastName'])[1]")
    public WebElement lastNameButton;

    @FindBy (css = "#Email")
    public WebElement emailButton;

    @FindBy (css = "#CompanyName")
    public WebElement companyName;

    @FindBy (css = "#Phone")
    public WebElement phoneButton;

    @FindBy (css = ".page-button.submit-button.btn")
    public WebElement getDemoButton;

    @FindBy (xpath = "//span[contains(.,'field is required.')]")
    public List<WebElement> allVisibleErrorMessages;

    @FindBy(xpath = "//span[@class='fas-li']")
    public List<WebElement> paragraphButtons;

    @FindBy(xpath = "//form[@id='form-pardot']//input[contains(@class,'form-control')]")
    public List<WebElement> firstInputTable;

    @FindBy(xpath = "//form[@id='form-pardot1']//input[contains(@class,'form-control')]")
    public List<WebElement> secondInputTable;

    @FindBy(id = "Email-error")
    public WebElement mailRejectedMessage;

    @FindBy(xpath = "//div[@class='selected-dial-code'][1]")
    public WebElement phoneCodeFlagButton;

    @FindBy(xpath = "//ul[@class='country-list']/li")
    public List<WebElement> countryList;


    //This method gets the number of warning messages received in input boxes.
    //Using seperate methods, locators for each warning message would lead to a crowded code
    //So that all warning messages are collected into a single list by using their common text as locator
    public int getErrorMessageCount () {
        return allVisibleErrorMessages.size();
    }

    //This method receives user information and fills the demo request form
    public void fillUserInfo(String firstName,String lastName,String workEmail,String company,String phone){
        firstNameButton.sendKeys(firstName);
        lastNameButton.sendKeys(lastName);
        emailButton.sendKeys(workEmail);
        companyName.sendKeys(company);
        phoneButton.sendKeys(phone);
    }

    //This method locates all buttons (nears paragraphs) and compares their Css color codes
    //First element was used as expected value due to absence of requirement document
    public boolean verifyButtonColors() {
        BrowserUtils.scrollToElement(paragraphButtons.get(7));
        BrowserUtils.scrollToElement(paragraphButtons.get(0));
        boolean elementColorsAreSame = true;
        String firstColor = paragraphButtons.get(0).getCssValue("background-color");
        for (WebElement paragraphButton : paragraphButtons) {
            if(!paragraphButton.getCssValue("background-color").equals(firstColor)) {
                elementColorsAreSame = false;
                break;
            }
        }
        return elementColorsAreSame;
    }

    //this method groups input boxes for 2 forms and compares box size for visual control
    //First element was used as expected value due to absence of requirement document
    public boolean verifyInputBoxSize() {
        boolean boxSizeIsSame = true;
        int firstDefaultWidth = firstInputTable.get(0).getSize().width;
        int firstDefaultHeight = firstInputTable.get(0).getSize().height;
        int secondDefaultWidth = secondInputTable.get(0).getSize().width;
        int secondDefaultHeight = secondInputTable.get(0).getSize().height;

        for (int i=0; i<firstInputTable.size(); i++ ) {
            if (firstInputTable.get(i).getSize().width!=firstDefaultWidth || firstInputTable.get(i).getSize().height!=firstDefaultHeight ||
                secondInputTable.get(i).getSize().width!=secondDefaultWidth || secondInputTable.get(i).getSize().height!=secondDefaultHeight)
            {
                boxSizeIsSame = false;
                return boxSizeIsSame;
            }
        }
      return boxSizeIsSame;
    }

    //This method returns the warning message after log attempt with common mails ie. gmail, hotmail etc.
    public String getMailErrorMessage () {
        String message = "";
        if(mailRejectedMessage.isDisplayed()) {
            message = mailRejectedMessage.getText();
        }
        return message;
    }

    //It was seen that US & UK appreared on top of countries phone codes list.
    //this method gets these preferred countries and returns them as string
    public String preferredCountries() {
        String countries = "";
        countries += countryList.get(0).getText();
        countries += countryList.get(1).getText();
        return countries;
    }


}
