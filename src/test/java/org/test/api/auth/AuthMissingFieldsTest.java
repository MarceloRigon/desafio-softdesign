package org.test.api.auth;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import base.BaseTest;
import config.Endpoints;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class AuthMissingFieldsTest extends BaseTest {

    @Test
    public void deveRetornarErroAoFaltarCampos() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("{ \"username\": \"\" }")
                .when()
                .post(Endpoints.LOGIN);

        response.then()
                .statusCode(anyOf(is(400), is(401), is(422)))
                .body("message", notNullValue());

        System.out.println("Erro esperado ao faltar campos: " + response.asPrettyString());
    }
}
