package com.udemy.seleniumdesign.factory;

import com.google.common.base.Predicate;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

 class GoogleEnglishPage extends GooglePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public GoogleEnglishPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private WebElement searchBtn;

    @FindBy(css = "div.q0vns")
    private List<WebElement> results;

    @Override
    public void launchSite() {
        this.driver.get("https://www.google.com");
    }

    @Override
    public void search(String keyword) {
        for (char ch : keyword.toCharArray()) {
            Uninterruptibles.sleepUninterruptibly(20, TimeUnit.MILLISECONDS);
            this.searchBox.sendKeys(ch + "");
        }
        this.wait.until((Predicate<WebDriver>) (d)-> this.searchBtn.isDisplayed());
        this.searchBtn.click();
    }

    @Override
    public int getResultsCount() {
        this.wait.until((Predicate<WebDriver>) (d)-> this.results.size() >1);
        return this.results.size();
    }
}
