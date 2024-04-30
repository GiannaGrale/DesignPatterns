package com.udemy.seleniumdesign.srp.common;

import com.google.common.base.Function;
import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.seleniumdesign.srp.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class SearchWidget extends AbstractComponent {
    @FindBy(name = "q")
    private WebElement searchBox;

    public SearchWidget(WebDriver driver) {
        super(driver);
    }

    public void enter(String keyword) {
        this.searchBox.clear();
        for (char ch : keyword.toCharArray()) {
            Uninterruptibles.sleepUninterruptibly(20, TimeUnit.MILLISECONDS);
            this.searchBox.sendKeys(ch + "");
        }
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((Function<? super WebDriver, Boolean>) (d) -> this.searchBox.isDisplayed());
    }
}
