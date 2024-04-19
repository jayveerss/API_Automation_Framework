package org.module.utils;

import io.restassured.response.Response;
import org.module.constants.FrameworkConstants;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.filter.log.LogDetail.ALL;

public abstract class BaseTest {

    public static RequestSpecification requestSpec;
    public static ResponseSpecification responseSpec;

    @BeforeSuite
    public void setBaseURI() {
       requestSpec = new RequestSpecBuilder().setBaseUri(FrameworkConstants.BASE_URI)
               .log(ALL).build();
    }

      @BeforeMethod
    public void beforeMethod() {
        responseSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType("application/json").log(ALL).build();
    }

    public static Response getCurrencyRates(String  path){
        Response response =  given().spec(requestSpec).when().get(path);
        response.then().spec(responseSpec);
        return response;
    }

}
