package com.udemy.seleniumdesign.proxy;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OrderComponentProxy implements OrderComponent {
    private static final List<String> EXCLUDED = Arrays.asList("PROD", "STAGING");
    private OrderComponent orderComponent;

    public OrderComponentProxy(WebDriver webDriver) {
        String currentEnv = System.getProperty("env"); //QA, DEV, STAGING, PROD
        if (!EXCLUDED.contains(currentEnv)) {
            this.orderComponent = new OrderComponentReal(webDriver);
        }
    }

    @Override
    public String placeOrder() {
        if (Objects.nonNull(this.orderComponent)) {
            return this.orderComponent.placeOrder();
        } else {
            return "SKIPPED";
        }
    }
}
