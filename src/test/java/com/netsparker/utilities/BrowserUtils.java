package com.netsparker.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BrowserUtils {

    // This method waits for backgrounds processes on the browser to complete
    // It has one @param, which is total wait time timeOutInSeconds
    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }


    /*
    Scrolls down to an element using JavaScript
    Takes a WebElement as parameter
     */
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /*
    Scrolls horizontally or vertically by given pixel
    negative numbers can be used to scroll back
     */
    public static void scrollByPixel(int horizontal,int vertical){
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("window.scrollBy("+horizontal+","+vertical+")");
    }


}


