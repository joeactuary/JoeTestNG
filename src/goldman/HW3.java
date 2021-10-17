package goldman;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HW3 {
    WebDriver driver;


    @BeforeClass(alwaysRun = true)
    public void openBrowser() {
        String url = "http://www.uitestpractice.com/";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver94.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
    }

    @Test(groups = {"HW"})
    public void dragTest() {
        String mainPageHandle = driver.getWindowHandle();
        WebElement toDrag = driver.findElement(By.cssSelector("div#draggable"));
        WebElement toDropIn = driver.findElement(By.cssSelector("div#droppable"));
        Actions action = new Actions(driver);
        action.dragAndDrop(toDrag, toDropIn).perform();

        WebElement dropMessage = toDropIn.findElement(By.xpath("p"));
        System.out.println(dropMessage.getText());

        String expectedMessage = "Dropped!";
        Assert.assertEquals(dropMessage.getText(), expectedMessage, "Was not dropped correctly");

    }

        @Test(groups = {"HW"})
        public void doubleClickTest() {

            WebElement doubleButton = driver.findElement(By.xpath("//button[@name='dblClick']"));
            Actions action = new Actions(driver);
            action.doubleClick(doubleButton).perform();
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            String expectedMessage = "Double Clicked !!";
            Assert.assertEquals(alert.getText(), expectedMessage, "Was not doubleclicked correctly");
            alert.accept();

        }

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



        driver.switchTo().defaultContent();

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


    @AfterClass(enabled = false,alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

}
