package com.netsparker.pages;

import com.netsparker.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Locators {
    public Locators() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "(//a[contains(text(),'Product')])[1]")
    public WebElement productsButton;

    @FindBy (xpath = "(//span[text()='All shirts'])[2]")
    public WebElement allTshirtsButton;


    @FindBy(xpath = "(//span[@class='catalog_sidebar-menuitem_text'])[1]")
    public WebElement mensClothingButton;

    @FindBy(xpath = "//*[.='Unisex Staple T-Shirt | Bella + Canvas 3001']")
    public WebElement requestedTshirt;


    @FindBy(xpath = "//span[@style='background-color: rgb(12, 12, 12);']")
    public WebElement blackColor;

    @FindBy(xpath = "//a[@data-label='Size L']")
    public WebElement sizeLbutton;

    @FindBy(xpath = "(//div[@data-placement='bottom'])[1]")
    public WebElement chooseFile;

    //Iframe
    @FindBy(xpath = "//a[contains(text(),'To sample files')]")
    public WebElement toSampleFile;

    @FindBy(xpath = "(//div[@data-placement='bottom'])[2]")
    public WebElement addText;

    @FindBy(css = "div.pf-library-item__details.pf-p-12")
    public WebElement chosenPhoto;

    @FindBy(xpath = "(//a[contains(text(),'Select')])[1]")
    public WebElement clickOnPhoto;





}
