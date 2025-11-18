package org.test.api.product;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import services.ProductService;
import base.BaseTest;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class ProductListWithoutAuthTest extends BaseTest {

    @Test
    public void deveListarTodosProdutosSemAutenticacao() {
        Response response = ProductService.getAllProducts();

        response.then()
                .log().all()
                .statusCode(200)
                .body("products", not(empty()))
                .body("total", greaterThan(0))
                .body("products[0].id", notNullValue())
                .body("products[0].title", notNullValue())
                .body("products[0].price", greaterThan(0))
                .body("products[0].images", not(empty()));

        int total = response.path("total");
        assertTrue(total > 0, "O total de produtos deve ser maior que zero.");
    }
}

