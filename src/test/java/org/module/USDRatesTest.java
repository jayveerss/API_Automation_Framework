package org.module;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.module.enums.Result;
import org.module.model.pojo.Root;
import org.module.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Map;

import static org.module.constants.FrameworkConstants.*;


/**
 * Test for currency conversion rate API for USD.
 */
public class USDRatesTest extends BaseTest {

    @Test (testName="USD exchange rate test")
    public void USD_Rate_Test(){
        Response response =  getCurrencyRates("/v6/latest/USD");
        Root root = response.as(Root.class);
        Assert.assertEquals(root.getResult(), Result.success.toString());
        Assert.assertEquals(root.getBaseCode(), "USD");
        Assert.assertTrue(USD_TO_AED_MIN_RANGE <= root.getRates().getAed() && root.getRates().getAed() <= USD_TO_AED_MAX_RANGE,"AED rate is out of expected range");
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Double> map = objectMapper.convertValue(root.getRates(), Map.class);
        Assert.assertEquals(TOTAL_CURRENCY_COUNT,map.size(),"Mismatch in total supported currency count");
        }
}
