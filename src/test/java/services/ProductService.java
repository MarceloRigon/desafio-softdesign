package services;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import config.Endpoints;
import static io.restassured.RestAssured.given;

public class ProductService {

    public static Response getAllProducts() {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get(Endpoints.PRODUCTS);
    }

    public static Response getAllProductsAuthenticated(String token) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .when()
                .get(Endpoints.AUTH_PRODUCTS);
    }

    public static Response getProductById(String token, int id) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .pathParam("id", id)
                .when()
                .get(Endpoints.PRODUCT_BY_ID);
    }
}
