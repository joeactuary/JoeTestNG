package com.uitespractice.pages;

import com.uitespractice.utils.CommonMethods2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestingControlsPage extends CommonMethods2 {

    private String pageJoe = "https://syntaxprojects.com/drag-drop-range-sliders-demo.php";

    @FindBy(css = "div#draggable")
    public WebElement toDrag;

    @FindBy(css = "div#droppable")
    public WebElement toDropIn;

    @FindBy(xpath = "//div[@id='droppable']/p")
    public WebElement dropMessage;

    @FindBy(xpath = "//button[@name='dblClick']")
    public WebElement doubleButton;

    @FindBy(xpath = "//label[text()='Enter your name:']/following-sibling::input")
    public WebElement enterYourName;

      public TestingControlsPage() {
        PageFactory.initElements(driver, this);

    }
}
