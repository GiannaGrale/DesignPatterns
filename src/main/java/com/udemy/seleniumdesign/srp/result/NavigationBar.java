package com.udemy.seleniumdesign.srp.result;

import com.google.common.base.Function;
import com.udemy.seleniumdesign.srp.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends AbstractComponent {
    @FindBy(id = "hdtb")
    private WebElement bar;

    @FindBy(linkText = "Новости")
    private WebElement news;

    @FindBy(linkText = "Картинки")
    private WebElement images;

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public void goToImages(){
        this.images.click();
    }

    public void goToNews(){
        this.news.click();
    }
    @Override
    public boolean isDisplayed() {
        return this.wait.until((Function<? super WebDriver, Boolean>) driver -> this.bar.isDisplayed());
    }
}
