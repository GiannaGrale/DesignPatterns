package com.udemy.seleniumdesign.factory;

import com.google.common.base.Predicate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

 class GoogleArabicPage extends GoogleEnglishPage {
    @FindBy(css = "div#gws-output-pages-elements-homepage_additional_languages__als a")
    private WebElement language;

    @FindBy(css = "span.hOoLGe")
    private WebElement keyboardBtn;

    @FindBy(id = "kbd")
    private WebElement keyboard;

    public GoogleArabicPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.google.com.sa");
        this.language.click();
    }

    @Override
    public void search(String keyword) {
        this.wait.until((Predicate<WebDriver>) driver1 -> this.keyboardBtn.isDisplayed());
        this.keyboardBtn.click();
        this.wait.until((Predicate<WebDriver>) driver1 -> this.keyboard.isDisplayed());
        super.search(keyword);
    }
}
