package com.udemy.seleniumdesign.test.decorator;

import com.udemy.seleniumdesign.decorator.PaymentScreenPage;
import org.testng.Assert;

import java.util.function.Consumer;

public class PaymentDecorators {

    private static void shouldSuccess(String actualStatus){
      Assert.assertEquals(actualStatus, "PASS");
    }

    private static void shouldFail(String actualStatus){
        Assert.assertEquals(actualStatus, "FAIL");
    }

    public static final Consumer<PaymentScreenPage> enterFreePromocode = (p) -> p.applyPromocode("FREEUDEMY");
    public static final Consumer<PaymentScreenPage> enterDiscountPromocode = (p) -> p.applyPromocode("PARTIALUDEMY");
    public static final Consumer<PaymentScreenPage> enterValidCreditCardDetails = (p) -> p.enterCreditCard("4111111111111111", "2024", "123");
    public static final Consumer<PaymentScreenPage> enterInvalidCreditCardDetails = (p) -> p.enterCreditCard("1111111111111111", "2024", "123");
    public static final Consumer<PaymentScreenPage> clickBuy = (p) -> p.buy();

    public static final Consumer<PaymentScreenPage> successPurchase = (p) -> shouldSuccess(p.getStatus());
    public static final Consumer<PaymentScreenPage> failedPurchase = (p) -> shouldFail(p.getStatus());
}
