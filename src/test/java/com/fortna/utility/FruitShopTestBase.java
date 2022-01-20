package com.fortna.utility;

import io.restassured.RestAssured;
import net.serenitybdd.rest.SerenityRest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class FruitShopTestBase {

    @BeforeAll
    public static void setUp(){

        RestAssured.baseURI = "https://api.predic8.de:443";
        RestAssured.basePath = "/shop";

    }
    @AfterAll
    public static void tearDown(){

        RestAssured.reset();
        SerenityRest.reset();

    }

}
