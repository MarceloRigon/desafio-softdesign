package org.test.api.auth;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import services.AuthService;
import base.BaseTest;

import static org.hamcrest.Matchers.*;

public class AuthInvalidTest extends BaseTest {

    @Test
    public void deveRetornarErroAoFazerLoginInvalido() {
        Response response = AuthService.login("usuarioInvalido", "senhaErrada");

        response.then()
                .statusCode(anyOf(is(400), is(401), is(403)))
                .body("message", notNullValue());

        System.out.println("Login inválido retornou mensagem: " + response.asPrettyString());
    }
}
