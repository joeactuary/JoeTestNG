package com.uitespractice.test;

import com.uitespractice.pages.TestingControlsPage;
import com.uitespractice.testbase.BaseClass;
import com.uitespractice.utils.CommonMethods2;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class UitesTest {

    @BeforeMethod(enabled = true,alwaysRun = true)
    public void openBrowser() {
        CommonMethods2.openUrl("http://www.uitestpractice.com/");
    }

    @Test(groups = {"Uites"})
    public void dragTest() {
        TestingControlsPage testingControlsPage = new TestingControlsPage();
        CommonMethods2.dragAndDrop(testingControlsPage.toDrag, testingControlsPage.toDropIn);
        System.out.println(testingControlsPage.dropMessage.getText());
        String expectedMessage = "Dropped!";
        Assert.assertEquals(testingControlsPage.dropMessage.getText(), expectedMessage, "Did not drop correctly");
        CommonMethods2.takeScreenshot("current/dragTest.png");
    }

    @Test(groups = {"Uites"})
    public void doubleClickTest() {
        TestingControlsPage testingControlsPage = new TestingControlsPage();

        CommonMethods2.doubleClick(testingControlsPage.doubleButton);

        String alertMessage = CommonMethods2.acceptAlert();
        System.out.println(alertMessage);
        String expectedMessage = "Double Clicked !!";
        Assert.assertEquals(alertMessage, expectedMessage, "Was not doubleclicked correctly");

        CommonMethods2.takeScreenshot("current/doubleClickTest.png");
    }

    @Test(groups = {"Uites"})
    public void frameTest() {
        TestingControlsPage testingControlsPage = new TestingControlsPage();
        BaseClass.driver.switchTo().frame("iframe_a");
        testingControlsPage.enterYourName.sendKeys("Joseph",Keys.TAB);
        BaseClass.driver.switchTo().defaultContent();
        CommonMethods2.takeScreenshot("current/frameTest.png");
    }




    @AfterMethod(enabled = true,alwaysRun = true)
    public void teardown() {
  BaseClass.tearDown();



       /* @Test(groups = {"HW"})



        @Test(groups = {"HW"})
        public void frameTest() {

            driver.switchTo().frame("iframe_a");
            WebElement enterYourName = driver.findElement(By.xpath("//label[text()='Enter your name:']/following-sibling::input"));
            enterYourName.sendKeys("Joseph", Keys.TAB);
            driver.switchTo().defaultContent();
        }

        @Test(groups = {"newjoe"})
        public void zreateUserTest() throws InterruptedException {

            WebElement homeButton = driver.findElement(By.linkText("Home"));
            homeButton.click();

            WebElement createNewButton = driver.findElement(By.xpath("//button[@class='btn btn-info']"));
            createNewButton.click();



            driver.switchTo().defaultContent();*/

//Alert alert = driver.switchTo().alert();
            //          alert.dismiss();





            //  Thread.sleep(5000);
            //    Alert alert = driver.switchTo().alert();
            //   alert.dismiss();
//        WebElement firstNameBox = driver.findElement(By.cssSelector("input#FirstName"));
//        firstNameBox.sendKeys("Stephen");
//        WebElement lastNameBox = driver.findElement(By.cssSelector("input#lastName"));
//        lastNameBox.sendKeys("Stephen");
//        WebElement enrollmentDateBox = driver.findElement(By.cssSelector("input#EnrollmentDate"));
//        enrollmentDateBox.sendKeys("05/25/2021");
//        WebElement createButton = driver.findElement(By.cssSelector("input[value='Create']"));
//        createButton.click();






}
}