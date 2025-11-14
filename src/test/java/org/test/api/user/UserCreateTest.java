package org.test.api.user;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import base.BaseTest;
import services.UserService;
import static org.hamcrest.Matchers.*;

public class UserCreateTest extends BaseTest {

    @Test
    public void deveCriarUsuarioComDadosRandomicos() {
        Response response = UserService.createUser();

        response.then()
                .statusCode(anyOf(is(200), is(201)))
                .body("id", notNullValue())
                .body("firstName", notNullValue())
                .body("email", notNullValue())
                .log().all();

        System.out.println("Usuário criado com sucesso!");
    }
}
