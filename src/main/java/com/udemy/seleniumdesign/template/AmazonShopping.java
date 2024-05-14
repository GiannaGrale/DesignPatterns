package com.udemy.seleniumdesign.template;

import com.udemy.seleniumdesign.template.pages.AmazonProductionDescriptionPage;
import com.udemy.seleniumdesign.template.pages.AmazonResultsPage;
import com.udemy.seleniumdesign.template.pages.AmazonSearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonShopping extends ShoppingTemplate {
    private String product;
    private WebDriverWait wait;
    private WebDriver driver;

    private AmazonSearchPage amazonSearchPage;
    private AmazonResultsPage amazonResultsPage;
    private AmazonProductionDescriptionPage amazonProductionDescriptionPage;

    public AmazonShopping(WebDriver driver, String product) {
        this.product = product;
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        this.amazonSearchPage = PageFactory.initElements(driver, AmazonSearchPage.class);
        this.amazonResultsPage = PageFactory.initElements(driver, AmazonResultsPage.class);
        this.amazonProductionDescriptionPage = PageFactory.initElements(driver, AmazonProductionDescriptionPage.class);
    }

    @Override
    public void launchSite() {
        this.amazonSearchPage.goTo();
    }

    @Override
    public void searchForProduct() {
        this.amazonSearchPage.search(this.product);
    }

    @Override
    public void selectProduct() {
        this.amazonResultsPage.selectProduct();
    }

    @Override
    public void buy() {
        this.amazonProductionDescriptionPage.buy();
    }
}
