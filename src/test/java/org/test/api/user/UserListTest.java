package org.test.api.user;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import base.BaseTest;
import services.UserService;
import static org.hamcrest.Matchers.*;

public class UserListTest extends BaseTest {

    @Test
    public void deveListarUsuariosComSucesso() {
        Response response = UserService.getUsers();

        response.then()
                .statusCode(200)
                .body("users", not(empty()));

        System.out.println("Usuários listados com sucesso!");
    }
}
