package com.syntax;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AaCalandar {

    WebDriver driver;


    @BeforeMethod(alwaysRun = true)
    public void openBrowser() throws InterruptedException {
        String url = "https://www.aa.com/homePage.do";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver94.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
    }

    @Test(groups = {"AaTest"})
    public void selectFlight() {

        //click on departure calender
        WebElement departDatebox = driver.findElement(By.xpath("//label[@for='aa-leavingOn']/following-sibling::button"));
        departDatebox.click();

        //select the month
        WebElement monthTitle = driver.findElement(By.xpath("(//div[@id='ui-datepicker-div']/div/div/div/span)[1]"));
        String monthText = monthTitle.getText();


//in loop find the wanted mont for departure==

        while (!monthText.equals("January")) {


            WebElement nextButton = driver.findElement(By.xpath("//a[@data-handler='next']"));
            nextButton.click();         //if it s not January click

            monthTitle = driver.findElement(By.xpath("(//div[@id='ui-datepicker-div']/div/div/div/span)[1]"));
            monthText = monthTitle.getText();

        }

        List<WebElement> depDates = driver.findElements(By.xpath("(//div[@id='ui-datepicker-div']/div/table)[1]/tbody/tr/td"));

        for (WebElement depDate : depDates) {

            if (depDate.getText().equals("2")) { //loop through till find day 2
                depDate.click();
                break;
            }
        }

        //arriving callender button;

        WebElement arrMonth = driver.findElement(By.xpath("//div[@id='flightSearchFormSubmitButton']/preceding-sibling::div[2]/div/button"));
        arrMonth.click();

        //arriving month title
        WebElement arrMonthTitle = driver.findElement(By.xpath("(//div[@id='ui-datepicker-div']/div/div/div/span)[1]"));
        String getArr = arrMonthTitle.getText();

        while (!getArr.equalsIgnoreCase("March")) {
            WebElement nextButton = driver.findElement(By.xpath("//a[@data-handler='next']"));
            nextButton.click();         //if it s not March click
            arrMonthTitle = driver.findElement(By.xpath("(//div[@id='ui-datepicker-div']/div/div/div/span)[1]"));
            getArr = arrMonthTitle.getText();


        }
        List<WebElement> arrDates = driver.findElements(By.xpath("(//div[@id='ui-datepicker-div']/div/table)[1]/tbody/tr/td"));
        for (WebElement arrDate : arrDates) {
            if (arrDate.getText().equals("14")) {
                arrDate.click();
                break;

            }
        }

        WebElement destinationSearchButton = driver.findElement(By.xpath("(//a[@class='widget aaAirportLookup'])[2]"));
        destinationSearchButton.click();

        WebElement selectCountry = driver.findElement(By.cssSelector("select#countryCode"));
        Select select = new Select(selectCountry);
        select.selectByVisibleText("United States");


        WebElement selectState = driver.findElement(By.cssSelector("select#stateCode"));
        select = new Select(selectState);
        select.selectByVisibleText("Georgia");
        List<WebElement> airportCodes = driver.findElements(By.xpath("//table[@id='airportsSection']/tbody/tr/td[3]/a/span[1]"));
        for (WebElement airport : airportCodes) {
            if (airport.getText().equals("ATL")) {
                airport.click();
                break;
            }

        }

        WebElement searchButton = driver.findElement(By.id("flightSearchForm.button.reSubmit"));
        searchButton.click();
        //   WebElement searchButton = driver.findElement(By.xpath("//input[@id='flightSearchForm.button.reSubmit']"));
        //   searchButton.click();
    }

    @AfterMethod(enabled = false, alwaysRun = false)
    public void tearDown() {
        driver.quit();
    }
}