package com.udemy.seleniumdesign.srp.result;

import com.udemy.seleniumdesign.srp.common.SearchSuggestion;
import com.udemy.seleniumdesign.srp.common.SearchWidget;
import org.openqa.selenium.WebDriver;

public class GoogleResultPage {
    private SearchWidget searchWidget;
    private SearchSuggestion searchSuggestion;
    private NavigationBar navigationBar;
    private ResultStat resultStat;

    public GoogleResultPage(WebDriver driver) {
        this.searchWidget = new SearchWidget(driver);
        this.searchSuggestion = new SearchSuggestion(driver);
        this.navigationBar = new NavigationBar(driver);
        this.resultStat = new ResultStat(driver);
    }

    public SearchWidget getSearchWidget() {
        return searchWidget;
    }

    public SearchSuggestion getSearchSuggestion() {
        return searchSuggestion;
    }

    public NavigationBar getNavigationBar() {
        return navigationBar;
    }

    public ResultStat getResultStat() {
        return resultStat;
    }
}
