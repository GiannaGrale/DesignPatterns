package com.udemy.seleniumdesign.test.decorator;

import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.seleniumdesign.decorator.PaymentScreenPage;
import com.udemy.seleniumdesign.test.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import static com.udemy.seleniumdesign.test.decorator.PaymentDecorators.*;

public class PaymentTest extends BaseTest {
    private PaymentScreenPage paymentScreenPage;

    @BeforeTest
    public void setPaymentScreenPage() {
        this.paymentScreenPage = new PaymentScreenPage(driver);
    }

    @Test(dataProvider = "getData")
    public void promocodeTest(Consumer<PaymentScreenPage> purchase) {
        this.paymentScreenPage.goTo();
        purchase.accept(paymentScreenPage);
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }


    @DataProvider
    private Object[][] getData() {
        return new Object[][]{
                {enterValidCreditCardDetails.andThen(clickBuy).andThen(successPurchase)},
                {enterDiscountPromocode.andThen(enterValidCreditCardDetails).andThen(clickBuy).andThen(successPurchase)},
                {enterFreePromocode.andThen(clickBuy).andThen(successPurchase)},
                {enterDiscountPromocode.andThen(enterInvalidCreditCardDetails).andThen(clickBuy).andThen(failedPurchase)},
                {enterInvalidCreditCardDetails.andThen(clickBuy).andThen(failedPurchase)},
                {clickBuy.andThen(failedPurchase)},
        };
    }
}
