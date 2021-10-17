package goldman;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class HW1 {
    WebDriver driver;


    @BeforeMethod(alwaysRun = true)
    public void openBrowser() {
        String url = "https://www.aa.com/homePage.do";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver94.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
    }

    @Test(groups = {"HW0"})
    public void NewTab() {
        String mainPageHandle = driver.getWindowHandle();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.open();");
        ArrayList<String> allWindownHandles = new ArrayList<String> (driver.getWindowHandles());
        System.out.println(allWindownHandles.size());
        driver.switchTo().window(allWindownHandles.get(1));
        String url = "https://www.nytimes.com";
        driver.get(url);

    }

    @AfterMethod(enabled = true,alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

}
