package org.test.api.product;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import base.BaseTest;
import services.AuthService;
import services.ProductService;
import static org.hamcrest.Matchers.*;

public class ProductListAuthTest extends BaseTest {

    @Test
    public void deveListarProdutosComAutenticacao() {
        Response loginResponse = AuthService.login("emilys", "emilyspass");
        String token = loginResponse.path("token");

        Response response = ProductService.getAllProductsAuthenticated(token);

        response.then()
                .statusCode(200)
                .body("products", not(empty()))
                .body("total", greaterThan(0));

        System.out.println("Produtos listados com sucesso!");
    }
}
