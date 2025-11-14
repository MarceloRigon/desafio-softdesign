package services;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import config.Endpoints;
import static io.restassured.RestAssured.given;

public class AuthService {

    public static Response login(String username, String password) {
        return given()
                .contentType(ContentType.JSON)
                .body("{ \"username\": \"" + username + "\", \"password\": \"" + password + "\" }")
                .when()
                .post(Endpoints.LOGIN);
    }

    public static Response getProducts(String token) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .when()
                .get(Endpoints.AUTH_PRODUCTS);
    }
}
