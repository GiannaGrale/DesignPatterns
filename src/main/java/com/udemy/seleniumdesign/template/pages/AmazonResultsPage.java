package com.udemy.seleniumdesign.template.pages;

import com.google.common.base.Predicate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonResultsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "span.a-size-medium")
    private WebElement item;

    public AmazonResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void selectProduct() {
        this.wait.until((Predicate<WebDriver>) (d) -> this.item.isDisplayed());
        this.item.click();
    }
}
