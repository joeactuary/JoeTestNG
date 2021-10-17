package goldman;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class garbage {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        String url = "http://www.uitestpractice.com/";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver94.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
        WebElement homeButton = driver.findElement(By.linkText("Home"));
        homeButton.click();


        WebElement createNewButton = driver.findElement(By.xpath("//button[@class='btn btn-info']"));
        createNewButton.click();
        driver.navigate().refresh();
        Thread.sleep(1000);
        createNewButton = driver.findElement(By.xpath("//button[@class='btn btn-info']"));
        createNewButton.click();

       // driver.switchTo().defaultContent();

//Alert alert = driver.switchTo().alert();
  //                alert.dismiss();
  //        Thread.sleep(5000);
  //          Alert alert2 = driver.switchTo().alert();
  //         alert2.dismiss();
//        WebElement firstNameBox = driver.findElement(By.cssSelector("input#FirstName"));
//        firstNameBox.sendKeys("Stephen");


    }
}



