package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;

@QuarkusTest
class PetResourceTest {

    @Test
    void get() {
        given()
                .when().get("/pets")
                .then().statusCode(200);
    }

    @Test
    void getByColumn() {
        given()
                .param("column","age")
                .param("age","3")
                .when().get("/pets/query")
                .then().statusCode(200);
    }

    @Test
    void post() {
        given()
                .body("{\"name\":\"Puss In Boots\",\n" +
                        "\"age\":3,\n" +
                        " \"description\":\"A good kitty\"}")
                .header("Content-type",MediaType.APPLICATION_JSON)
                .when().post("/pets")
                .then().statusCode(201);
    }

    @Test
    void put() {
        given()
                .body("{\"id\":1,\n" +
                        "\"name\":\"Puss In Boots\",\n" +
                        "\"age\":4,\n" +
                        "\"description\":\"A Bad kitty\"}")
                .header("Content-type",MediaType.APPLICATION_JSON)
                .when().put("/pets")
                .then().statusCode(200);
    }

    @Test
    void delete() {
        given()
                .param("id",1)
                .when().delete("/pets")
                .then().statusCode(500);
    }
}