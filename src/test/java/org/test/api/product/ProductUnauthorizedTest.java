package org.test.api.product;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import base.BaseTest;
import services.ProductService;
import static org.hamcrest.Matchers.*;

public class ProductUnauthorizedTest extends BaseTest {

    @Test
    public void deveRetornarErroAoAcessarSemToken() {
        Response response = ProductService.getAllProductsAuthenticated("token");

        response.then()
                .statusCode(anyOf(is(401), is(403)))
                .body("message", notNullValue());

        System.out.println("Erro esperado sem autenticação: " + response.asPrettyString());
    }
}
