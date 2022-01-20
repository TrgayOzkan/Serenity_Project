package com.fortna.rest;

import com.fortna.pojo.Customer;
import com.fortna.utility.FruitShopTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.rest.Ensure;
import net.serenitybdd.rest.SerenityRest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.hamcrest.Matchers.is;

@ExtendWith(SerenityJUnit5Extension.class)
public class FruitShopTest extends FruitShopTestBase {

    @Tag("Smoke")
    @DisplayName("GET /customers id")
    @Test
    public void testCustomers(){

        SerenityRest.given()
                .log().all()
                .contentType(ContentType.JSON).
          when()
                .get("/customers/").
          then().log().all();

        Ensure.that("status code 200",c->c.statusCode(200));

    }
    @Tag("Smoke")
    @DisplayName("POST /customers new customer")
    @Test
    public void testPostCustomer(){

        Customer cs = new Customer("Turgay","Ozkan");

       SerenityRest.given()
                .log().body()
                .contentType(ContentType.JSON)
                .body(cs)
            .when()
                .post("/customers/")
            .then()
                .statusCode(201)
                .log().all().extract();

        SerenityRest.given().contentType(ContentType.JSON)
                    .pathParam("id",364).
                when()
                .get("/customers/{id}").
                then().statusCode(200);

        Ensure.that("status code is ",c ->c.statusCode(201)).
                andThat("First name of the new customer",
                        c->c.body("customers.firstname",is(cs.getFirstName()))).
                andThat("Last name of the new customer",
                        c->c.body("customers.lastname",is(cs.getLastName())));
    }
    @DisplayName("GET /customers newly created customer")
    @Test
    public void testGetCustomer(){

        Response rp = SerenityRest.given()
                .log().body()
                .contentType(ContentType.JSON)
                .pathParam("id",358).
            when()
                .get("/customers/{id}");

        rp.then().statusCode(200).log().all();


    }
    @DisplayName("DELETE /customers newly created customer")
    @Test
    public void testDeleteCustomer(){

        Response rp = SerenityRest.given()
                .log().body()
                .contentType(ContentType.JSON)
                .pathParam("id",359).
                when()
                .delete("/customers/{id}");

        rp.then().statusCode(200).log().all();

        SerenityRest.given()
                .log().body()
                .contentType(ContentType.JSON)
                .pathParam("id",358).
                when()
                .get("/customers/{id}");

        Ensure.that("Deleted customer status code is",d -> d.statusCode(404));


    }
}
