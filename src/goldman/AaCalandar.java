package goldman;

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
    public void openBrowser() {
        String url = "https://www.aa.com/homePage.do";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver94.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
    }

    @Test(groups = {"AaTest"})
    public void selectFlight() {

        //**************  Puts Departure Date    ************************************

       WebElement expandCalendar = driver.findElement(By.xpath("(//button[@class='ui-datepicker-trigger'])[1]"));
        expandCalendar.click();

        WebElement monthTitle = driver.findElement(By.xpath("(//div[@id='ui-datepicker-div']/div/div/div/span)[1]"));

        while (! monthTitle.getText().equals("January")) {
            WebElement nextMonthButton = driver.findElement(By.xpath("//a[@data-handler='next']"));
            nextMonthButton.click();
            monthTitle = driver.findElement(By.xpath("(//div[@id='ui-datepicker-div']/div/div/div/span)[1]"));
        }

        List<WebElement> depDates = driver.findElements(By.xpath("(//div[@id='ui-datepicker-div']/div/table)[1]/tbody/tr/td"));

        for (WebElement depDate : depDates) {

            if (depDate.getText().equals("12")) {
                depDate.click();
                break;
            }
        }


        //**************  Puts Arrival Date    ************************************
        expandCalendar = driver.findElement(By.xpath("(//button[@class='ui-datepicker-trigger'])[2]"));
        expandCalendar.click();

        monthTitle = driver.findElement(By.xpath("(//div[@id='ui-datepicker-div']/div/div/div/span)[2]"));

        while (! monthTitle.getText().equals("February")) {
            WebElement nextMonthButton = driver.findElement(By.xpath("//a[@data-handler='next']"));
            nextMonthButton.click();
            monthTitle = driver.findElement(By.xpath("(//div[@id='ui-datepicker-div']/div/div/div/span)[1]"));
        }

        depDates = driver.findElements(By.xpath("(//div[@id='ui-datepicker-div']/div/table)[2]/tbody/tr/td"));

        for (WebElement depDate : depDates) {

            if (depDate.getText().equals("23")) {
                depDate.click();
                break;
            }
        }

//**************  Puts Destination    ************************************
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
        //**************************     Final Selection to show search results    ***************************
        WebElement searchButton = driver.findElement(By.id("flightSearchForm.button.reSubmit"));
        searchButton.click();

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws InterruptedException {
        Thread.sleep(15000);   //To see results
        driver.quit();
    }
}