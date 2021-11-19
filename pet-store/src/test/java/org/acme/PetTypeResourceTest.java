package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;

@QuarkusTest
class PetTypeResourceTest {
    @Test
    public void testGet(){
        given()
                .when().get("/pet-type")
                .then().statusCode(200);
    }

    @Test
    public void testPost(){
        given()
                .body("{\"type\":\"Mammal\"}")
                .header("Content-type",MediaType.APPLICATION_JSON)
                .when().post("/pet-type")
                .then().statusCode(201);
    }

    @Test
    public void testPut(){
        given()
                .body("{\"id\":1,\"type\":\"Not Mammal\"}")
                .header("Content-type",MediaType.APPLICATION_JSON)
                .when().put("/pet-type")
                .then().statusCode(200);
    }

    @Test
    public void testDelete(){
        given()
                .param("id",1)
                .when().delete("/pet-type")
                .then().statusCode(200);
    }


}