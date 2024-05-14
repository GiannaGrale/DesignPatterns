package com.udemy.seleniumdesign.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserInformation {
    @FindBy(id = "fn")
    private WebElement firstname;
    @FindBy(id = "ln")
    private WebElement lastname;
    @FindBy(id = "email")
    private WebElement email;

    public UserInformation(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

    public void enterDetails(String fn, String ln, String email){
        this.firstname.sendKeys(fn);
        this.lastname.sendKeys(ln);
        this.email.sendKeys(email);
    }

}
