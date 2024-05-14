package com.udemy.seleniumdesign.proxy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class PaymentScreen {
    private WebDriver webDriver;
    private UserInformation userInformation;
    private OrderComponent orderComponent;
    private PaymentOption paymentOption;

    public PaymentScreen (WebDriver webDriver){
        this.webDriver = webDriver;
        this.userInformation = new UserInformation(webDriver);
        this.orderComponent = new OrderComponentProxy(webDriver);
    }

    public void goTo(){
        this.webDriver.get("https://vins-udemy.s3.amazonaws.com/ds/strategy.html");
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public OrderComponent getOrder() {
        return orderComponent;
    }

    public void setPaymentOption(PaymentOption paymentOption) {
        this.paymentOption = paymentOption;
        PageFactory.initElements(webDriver, this.paymentOption);
    }

    public void pay(Map<String, String> paymentDetails) {
        this.paymentOption.enterPaymentInformation(paymentDetails);
    }
}
