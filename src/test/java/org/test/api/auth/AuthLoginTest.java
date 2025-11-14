package org.test.api.auth;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import base.BaseTest;
import services.AuthService;

import static org.hamcrest.Matchers.*;

public class AuthLoginTest extends BaseTest {

    @Test
    public void deveGerarTokenComSucesso() {
        Response response = AuthService.login("emilys", "emilyspass");

        response.then()
                .statusCode(200)
                .body("token", notNullValue())
                .body("refreshToken", notNullValue())
                .body("username", equalTo("emilys"));

        System.out.println("Token gerado com sucesso: " + response.path("token"));
    }
}
