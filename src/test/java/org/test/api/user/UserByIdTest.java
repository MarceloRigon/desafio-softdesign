package org.test.api.user;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import base.BaseTest;
import services.UserService;
import static org.hamcrest.Matchers.*;

public class UserByIdTest extends BaseTest {

    private int userId;

    @BeforeEach
    public void buscarIDAleatorio() {
        // Gera um ID aleatório entre 1 e 30
        userId = (int) (Math.random() * 30) + 1;
        System.out.println("🔹 ID aleatório selecionado para teste: " + userId);
    }

    @Test
    public void deveListarUsuarioPorIdComSucesso() {
        Response response = UserService.getUserById(userId);

        response.then()
                .statusCode(200)
                .body("id", equalTo(userId))
                .body("firstName", notNullValue())
                .body("email", notNullValue())
                .log().all();

        System.out.println("Usuário retornado com sucesso! ID: " + userId);
    }
}
