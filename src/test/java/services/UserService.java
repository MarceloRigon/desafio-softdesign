package services;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import config.Endpoints;
import utils.DataGenerator;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserService {

    public static Response createUser() {
        Map<String, Object> user = new HashMap<>();
        user.put("firstName", DataGenerator.randomFirstName());
        user.put("lastName", DataGenerator.randomLastName());
        user.put("age", DataGenerator.randomAge());
        user.put("email", DataGenerator.randomEmail());

        return given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(Endpoints.ADD_USER);
    }

    public static Response getUsers() {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get(Endpoints.USERS);
    }

    public static Response getUserById(int id) {
        return given()
                .contentType(ContentType.JSON)
                .pathParam("id", id)
                .when()
                .get(Endpoints.USER_BY_ID);
    }
}
