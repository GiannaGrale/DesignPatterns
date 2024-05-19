package com.udemy.seleniumdesign.test.method;

import com.udemy.seleniumdesign.executearound.MainPage;
import com.udemy.seleniumdesign.test.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {
    private MainPage mainPage;

    @BeforeTest
    public void setMainPage(){
        this.mainPage = new MainPage(driver);
    }

    @Test
    public void  frameTest(){
        this.mainPage.goTo();
        this.mainPage.onFrameA(a -> {
            a.setFirstName("fn1");
            a.setMessage("Some message");
            a.setAddress("Some address");
        });
        this.mainPage.onFrameB(b -> {
            b.setFirstName("fn2");
            b.setAddress("Some address");
        });
        this.mainPage.onFrameC(c -> c.setFirstName("fn3"));
        this.mainPage.onFrameA(a -> a.setLastName("ln1"));
    }
}
