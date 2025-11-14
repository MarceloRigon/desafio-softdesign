package base;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTest {

    protected static String BASE_URL = "https://dummyjson.com";

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = BASE_URL;
    }
}
