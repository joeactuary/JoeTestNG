package com.syntax;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    WebDriver driver;


    @BeforeMethod(alwaysRun = true)
    public void openBrowser() throws InterruptedException {

        String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver94.exe");
        driver = new ChromeDriver();

        driver.get(url);
        driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
    }

    @Test (priority = 1)
    public void ValidLogin() {
        WebElement userName = driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");
        WebElement passWord = driver.findElement(By.id("txtPassword"));
        passWord.sendKeys("Hum@nhrm123");
        WebElement loginBtn = driver.findElement(By.id("btnLogin"));
        loginBtn.click();

        WebElement welcomeAttribute = driver.findElement(By.xpath("//*[@id='welcome']"));

        System.out.println((welcomeAttribute.isDisplayed()) ? "Test case is valid and passed" : "Test case is invalid and failed");
    }

    @Test (priority = 2, groups = {"smoke"})
    public void validationofTitle() {

        String actualTitle = driver.getTitle();
        String expectedTitle = "Human Management Jystem";
        Assert.assertEquals(actualTitle,expectedTitle, "Title is not correct");
        System.out.println("After Assertation");


    }

@AfterMethod (enabled = true,alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}