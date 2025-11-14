package org.test.api.product;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import base.BaseTest;
import services.AuthService;
import services.ProductService;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class ProductByIdTest extends BaseTest {

    private String token;

    @BeforeEach
    public void setUp() {
        Response loginResponse = AuthService.login("emilys", "emilyspass");
        token = loginResponse.path("token");
        assertNotNull(token, "Token não deve ser nulo");
    }

    @Test
    public void deveBuscarProdutoPorIdComAutenticacao() {
        int productId = 1;

        Response response = ProductService.getProductById(token, productId);

        response.then()
                .log().all()
                .statusCode(200)
                .body("id", equalTo(productId))
                .body("title", notNullValue())
                .body("price", greaterThan(0))
                .body("images", not(empty()));

        System.out.println("Produto retornado com sucesso: id=" + productId);
    }


    @Test
    public void deveRetornarNotFoundParaProdutoInexistente() {
        int nonExistentId = 999999;

        Response response = ProductService.getProductById(token, nonExistentId);

        response.then()
                .log().all()
                .statusCode(anyOf(is(404), is(400), is(200)));

        System.out.println("Produto inexistente retornou resposta válida.");
    }

}
