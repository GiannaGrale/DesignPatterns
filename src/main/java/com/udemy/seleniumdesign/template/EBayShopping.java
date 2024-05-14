package com.udemy.seleniumdesign.template;

import com.google.common.base.Predicate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EBayShopping extends ShoppingTemplate {
    private String product;
    private WebDriverWait wait;
    private WebDriver driver;

    @FindBy(id = "gh-ac")
    private WebElement searchBox;

    @FindBy(id = "gh-btn")
    private WebElement searchBtn;

    @FindBy(css = "div.s-item__info a")
    private WebElement item;

    @FindBy(css = "div.x-price-primary span")
    private WebElement price;

    public EBayShopping(WebDriver driver, String product) {
        this.product = product;
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.ebay.com/");
    }

    @Override
    public void searchForProduct() {
        this.searchBox.sendKeys(this.product);
        this.searchBtn.click();
    }

    @Override
    public void selectProduct() {
        this.wait.until((Predicate<WebDriver>) (d) -> this.item.isDisplayed());
        this.item.click();
    }

    @Override
    public void buy() {
        this.wait.until((Predicate<WebDriver>) (d) -> this.price.isDisplayed());
        System.out.println(this.price.getText());
    }
}
