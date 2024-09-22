package tests;

import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;
public class CRUDAPI {

    @Test
    public void getRequestTest() {
        baseURI = "https://reqres.in/api";
        given().
            get("/users?page=2").
        then().
            assertThat().
            body(matchesJsonSchemaInClasspath("schema.json")).  // Ensure this path is correct
            statusCode(200);
    }

    @Test
    public void postRequestTest() {
        baseURI = "https://reqres.in/api";
        given().
            header("Content-Type", "application/json").
            body("{ \"name\": \"morpheus\", \"job\": \"leader\" }").
        when().
            post("/users").
        then().
            assertThat().
            statusCode(201).
            body("name", equalTo("morpheus")).
            body("job", equalTo("leader"));
    }

    @Test
    public void patchRequestTest() {
        baseURI = "https://reqres.in/api";
        given().
            header("Content-Type", "application/json").
            body("{ \"name\": \"morpheus\", \"job\": \"zion resident\" }").
        when().
            patch("/users/2").
        then().
            assertThat().
            statusCode(200).
            body("job", equalTo("zion resident"));
    }

    @Test
    public void deleteRequestTest() {
        baseURI = "https://reqres.in/api";
        when().
            delete("/users/2").
        then().
            assertThat().
            statusCode(204);
    }
}
