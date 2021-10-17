package com.SyntaxPractice.test;

import com.SyntaxPractice.pages.RangeSliderPage;
import com.SyntaxPractice.utils.CommonMethods2;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SliderTest {

    @BeforeMethod
    public void openBrowser() {
        CommonMethods2.openUrl("https://syntaxprojects.com/drag-drop-range-sliders-demo.php");
    }

    @Test
    public void firstTest() {
        RangeSliderPage rangeSliderPage = new RangeSliderPage();
        CommonMethods2.SlideHorizontal(rangeSliderPage.rangeSlider1, 25);
        System.out.println(rangeSliderPage.rangeSliderOutput.getText());
        String expectedMessage = "57";
        Assert.assertEquals(rangeSliderPage.rangeSliderOutput.getText(), expectedMessage, "Did not slide correctly");

        CommonMethods2.takeScreenshot("current/page.png");
    }

    @AfterMethod
    public void teardown() {
//  BaseClass.tearDown();
    }
}