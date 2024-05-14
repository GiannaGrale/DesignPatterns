package com.udemy.seleniumdesign.test.strategy;

import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.seleniumdesign.strategy.*;
import com.udemy.seleniumdesign.test.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Maps;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PaymentScreenTest extends BaseTest {
    private PaymentScreen paymentScreen;

    @BeforeTest
    public void setPaymentScreen() {
        this.paymentScreen = new PaymentScreen(driver);
    }

    @Test(dataProvider = "getData")
    public void paymentTest(String option, Map<String, String> paymentDetails) {
        this.paymentScreen.goTo();
        this.paymentScreen.getUserInformation().enterDetails("Anne", "Grace", "udemy@gmail.com");
        this.paymentScreen.setPaymentOption(PaymentOptionFactory.get(option));
        this.paymentScreen.pay(paymentDetails);
        String orderNumber = this.paymentScreen.getOrder().placeOrder();

        System.out.println("Order number : " + orderNumber);
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }


    @DataProvider
    public Object[][] getData(){
        Map <String, String> cc = Maps.newHashMap();
        cc.put("cc", "173663823989");
        cc.put("year", "2028");
        cc.put("cvv", "123");

        Map <String, String> nb = Maps.newHashMap();
        nb.put("bank", "WELLS FARGO");
        nb.put("acc_number", "myaccount123");
        nb.put("pin", "123");

        Map <String, String> pp = Maps.newHashMap();
        pp.put("paypal_username", "aqa_user");
        pp.put("paypal_password", "password123");

        return new Object[][]{
                {"CC", cc},
                {"NB", nb},
                {"PP", pp},
        };
    }
}
