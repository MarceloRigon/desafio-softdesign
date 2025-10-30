package org.test.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthTest extends org.test.api.BaseTest {

    @Test
    public void buscarStatusDaAplicacao() {

        try {

            Response response = given()
                    .when()
                    .get("/test")
                    .then()
                    .statusCode(200)
                    .extract()
                    .response();

            String status = response.jsonPath().getString("status");
            assertEquals("ok", status, "O status da aplicação não é 'ok'!");

            System.out.println("Status da aplicação: " + status);
        } catch (AssertionError e) {
            throw new ApiTestException("Erro ao verificar o status da aplicação: " + e.getMessage());
        }
    }

    @Test
    public void criarTokenAutenticacao() {
        try {
            String token =
                    given()
                            .contentType(ContentType.JSON)
                            .body("{ \"username\": \"emilys\", \"password\": \"emilyspass\" }")
                            .when()
                            .post("/auth/login")
                            .then()
                            .statusCode(200)
                            .body("token", notNullValue())
                            .body("refreshToken", notNullValue())
                            .body("username", equalTo("emilys"))
                            .extract()
                            .path("token");

            System.out.println("Token gerado com sucesso: " + token);

        } catch (AssertionError e) {
            throw new ApiTestException("Erro ao criar token de autenticação: " + e.getMessage());
        }
    }
}

