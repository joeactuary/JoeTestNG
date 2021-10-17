package com.SyntaxPractice.testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver driver;

    public static void openUrl(String url) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver94.exe");
        driver = new ChromeDriver();
        driver.get(url);
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
    }

    public static void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
}
