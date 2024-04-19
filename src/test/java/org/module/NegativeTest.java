package org.module;

import io.restassured.response.Response;
import org.module.enums.Result;
import org.module.model.pojo.Root;
import org.module.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test for currency conversion rate API for invalid currency.
 */
public class NegativeTest extends BaseTest{

    @Test (testName="Invalid currency test")
    public void Invalid_Currency_Test() {
        Response response = getCurrencyRates("/v6/latest/xyz");
        Root root = response.as(Root.class);
        Assert.assertEquals(root.getResult(), Result.error.toString());
    }
}