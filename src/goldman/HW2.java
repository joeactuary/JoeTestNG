package goldman;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HW2 {
    WebDriver driver;


    @BeforeMethod(alwaysRun = true)
    public void openBrowser() throws InterruptedException {

        String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver94.exe");
        driver = new ChromeDriver();

        driver.get(url);
        driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
    }

    @Test(groups = {"HW"})
    public void MissingPassword() {
        WebElement userName = driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");
       // WebElement passWord = driver.findElement(By.id("txtPassword"));
      //  passWord.sendKeys("Hum@nhrm123");
        WebElement loginBtn = driver.findElement(By.id("btnLogin"));
        loginBtn.click();

        WebElement spanMessage = driver.findElement(By.xpath("(//div[@id='divLoginButton'])/span"));
        String expectedSpanMessage = "Password cannot be empty";
        Assert.assertEquals(spanMessage.getText(),expectedSpanMessage, "Incorrect missing password message");

    }

    @Test(groups = {"HW"})
    public void BlankUserName() {
       // WebElement userName = driver.findElement(By.id("txtUsername"));
        //userName.sendKeys("Admin");
         WebElement passWord = driver.findElement(By.id("txtPassword"));
          passWord.sendKeys("Hum@nhrm123");
        WebElement loginBtn = driver.findElement(By.id("btnLogin"));
        loginBtn.click();

        WebElement spanMessage = driver.findElement(By.xpath("(//div[@id='divLoginButton'])/span"));
        String expectedSpanMessage = "Username cannot be empty";
        Assert.assertEquals(spanMessage.getText(),expectedSpanMessage, "Incorrect missing password message");

    }

    @Test(groups = {"HW"})
    public void IncorrectPassword() {
         WebElement userName = driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");
        WebElement passWord = driver.findElement(By.id("txtPassword"));
        passWord.sendKeys("garbage");
        WebElement loginBtn = driver.findElement(By.id("btnLogin"));
        loginBtn.click();

        WebElement spanMessage = driver.findElement(By.xpath("(//div[@id='divLoginButton'])/span"));
        String expectedSpanMessage = "Invalid credentials";
        Assert.assertEquals(spanMessage.getText(),expectedSpanMessage, "Invalid credentials message not coming up");

    }

    @AfterMethod(enabled = true,alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
