package com.udemy.seleniumdesign.command;

import com.google.common.base.Predicate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class HomePage {
    private final WebDriverWait wait;
    private final WebDriver driver;

    //buttons
    @FindBy(css = "div.button-box button.btn-info")
    private WebElement infoBtn;
    @FindBy(css = "div.button-box button.btn-warning")
    private WebElement warnBtn;
    @FindBy(css = "div.button-box button.btn-success")
    private WebElement successBtn;
    @FindBy(css = "div.button-box button.btn-danger")
    private WebElement dangerBtn;

    //notifications
    @FindBy(css = "div.jq-icon-info")
    private WebElement infoAlert;
    @FindBy(css = "div.jq-icon-warning")
    private WebElement warnAlert;
    @FindBy(css = "div.jq-icon-success")
    private WebElement successAlert;
    @FindBy(css = "div.jq-icon-error")
    private WebElement dangerAlert;

    //dismissal alert
    @FindBy(css = "#main-wrapper > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div.alert-info")
    private WebElement dismissalInfoAlert;
    @FindBy(css = "#main-wrapper > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div.alert-success")
    private WebElement dismissalSuccessAlert;
    @FindBy(css = "#main-wrapper > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div.alert-danger")
    private WebElement dismissalDangerAlert;
    @FindBy(css = "#main-wrapper > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div.alert-warning")
    private WebElement dismissalWarnAlert;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 3);
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/admin-template/admin-template.html");
        this.wait.until((Predicate<WebDriver>) (d) -> this.infoBtn.isDisplayed());
    }

    public List<ElementValidator> getElementValidators(){
        return Arrays.asList(
                new NotificationValidator(infoBtn, infoAlert),
                new NotificationValidator(successBtn, successAlert),
                new NotificationValidator(warnBtn, warnAlert),
                new NotificationValidator(dangerBtn, dangerAlert),

                new DismissalAlertValidator(dismissalInfoAlert),
                new DismissalAlertValidator(dismissalSuccessAlert),
                new DismissalAlertValidator(dismissalWarnAlert),
                new DismissalAlertValidator(dismissalDangerAlert)
        );
    }
}
