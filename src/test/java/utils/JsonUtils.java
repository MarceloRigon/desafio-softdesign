package utils;
import com.google.gson.Gson;
import java.util.Map;

public class JsonUtils {

    private static final Gson gson = new Gson();

    public static String toJson(Map<String, Object> data) {
        return gson.toJson(data);
    }
}
