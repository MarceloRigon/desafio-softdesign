package org.test.api;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UserTest extends org.test.api.BaseTest{

    @Test
    public void buscarUsuarios() {
        try {
            given()
                    .contentType(ContentType.JSON)
                    .when()
                    .get("/users")
                    .then()
                    .statusCode(200)
                    .body("users", not(empty()))
                    .body("users[0].username", notNullValue())
                    .body("users[0].password", notNullValue())
                    .log().all();
        } catch (AssertionError e) {
            throw new ApiTestException("Erro ao buscar usuários: " + e.getMessage());
        }
    }
}
