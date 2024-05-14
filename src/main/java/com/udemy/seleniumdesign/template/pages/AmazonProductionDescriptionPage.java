package com.udemy.seleniumdesign.template.pages;

import com.google.common.base.Predicate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonProductionDescriptionPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "priceblock_ourprice")
    private WebElement price;

    public AmazonProductionDescriptionPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void buy() {
        this.wait.until((Predicate<WebDriver>) (d) -> this.price.isDisplayed());
        System.out.println(
                this.price.getText()
        );
    }
}
