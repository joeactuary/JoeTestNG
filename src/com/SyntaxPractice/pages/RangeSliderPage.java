package com.SyntaxPractice.pages;

import com.SyntaxPractice.utils.CommonMethods2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RangeSliderPage extends CommonMethods2 {

    private String pageJoe = "https://syntaxprojects.com/drag-drop-range-sliders-demo.php";

    @FindBy(xpath = "(//input[@type='range' and @name='range'])[1]")
    public WebElement rangeSlider1;

    @FindBy(css = "output#range")
    public WebElement rangeSliderOutput;


     public RangeSliderPage() {
        PageFactory.initElements(driver, this);


    }
}


