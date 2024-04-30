package com.udemy.seleniumdesign.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

 class GoogleFrenchPage extends GoogleEnglishPage {
    @FindBy(css = "div#gws-output-pages-elements-homepage_additional_languages__als a")
    private WebElement language;

    public GoogleFrenchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.google.fr");
        this.language.click();
    }
}