package com.uitespractice.utils;

import com.uitespractice.testbase.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;

public class CommonMethods2 extends BaseClass {

    /**
     * this method sends text to a given webelement
     *
     * @param element //
     * @param text    //
     */
    public static void sendText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    /**
     * this method will switch to frame by index
     *
     * @param index //
     */
    public static void switchToFrame(int index) {
        try {
            driver.switchTo().frame(index);
        } catch (NoSuchFrameException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method prints a screenshot of the driver
     *
     * @param fileName //
     */

    public static void takeScreenshot(String fileName) {
        TakesScreenshot ts = (TakesScreenshot) BaseClass.driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sourceFile, new File("screenshots/" + fileName));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public static void slideHorizontal(WebElement webElement, Integer slideOffset) {
        Actions action = new Actions(BaseClass.driver);
        action.clickAndHold(webElement).moveByOffset(slideOffset, 0).release().build().perform();
    }


    public static void dragAndDrop(WebElement toDrag, WebElement toDropIn) {
        Actions action = new Actions(BaseClass.driver);
        action.dragAndDrop(toDrag, toDropIn).perform();
    }

    public static void doubleClick(WebElement toDoubleClick) {
        Actions action = new Actions(BaseClass.driver);
        action.doubleClick(toDoubleClick).perform();
    }

public static String acceptAlert() {

    Alert alert = BaseClass.driver.switchTo().alert();
    String alertMessage =alert.getText();
    alert.accept();
    return alertMessage;


}




}
