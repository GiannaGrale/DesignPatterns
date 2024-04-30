package com.udemy.seleniumdesign.srp.main;

import com.udemy.seleniumdesign.srp.common.SearchSuggestion;
import com.udemy.seleniumdesign.srp.common.SearchWidget;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleMainPage {
    private WebDriver driver;
    private SearchSuggestion searchSuggestion;
    private SearchWidget searchWidget;

    public GoogleMainPage(WebDriver driver) {
        this.driver = driver;
        this.searchSuggestion = PageFactory.initElements(driver, SearchSuggestion.class);
        this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);
    }

    public void goTo(){
        driver.get("https://www.google.co.uk/");
    }

    public SearchWidget getSearchWidget() {
        return searchWidget;
    }

    public SearchSuggestion getSearchSuggestion() {
        return searchSuggestion;
    }
}