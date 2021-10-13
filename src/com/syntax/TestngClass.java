package com.syntax;

import org.testng.annotations.*;

public class TestngClass {
    @Test()
    public void zfirstGTest(){
        System.out.println("This is my first Method");
    }

    @Test()
    public void secondTest(){
        System.out.println("This is my second Method");
    }

    @Test
    public void thirdTest(){
        System.out.println("This is my third and final Method");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("This is my Before Method - I run before each and every Test!!!");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("This is my After Method - I run after each and every Test!!!");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("This is my Before Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("This is my After Class");
    }


}
