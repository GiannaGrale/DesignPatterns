package com.udemy.seleniumdesign.srp.common;

import com.google.common.base.Function;
import com.udemy.seleniumdesign.srp.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchSuggestion extends AbstractComponent {
    @FindBy(css = "li.sbct")
    private List<WebElement> suggestions;

    public SearchSuggestion(WebDriver driver) {
        super(driver);
    }

    public void  clickSuggestionByIndex(int index){
        this.suggestions.get(index - 1).click();
    }
    @Override
    public boolean isDisplayed() {
        return this.wait.until((Function<? super WebDriver, Boolean>) (d) -> this.suggestions.size() > 5);
    }
}
