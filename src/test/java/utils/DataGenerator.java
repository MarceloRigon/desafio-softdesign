package utils;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

public class DataGenerator {

    private static final Random random = new Random();

    public static String randomFirstName() {
        return "User" + RandomStringUtils.randomAlphabetic(5);
    }

    public static String randomLastName() {
        return "Test" + RandomStringUtils.randomAlphabetic(4);
    }

    public static String randomEmail() {
        return "user" + RandomStringUtils.randomNumeric(4) + "@example.com";
    }

    public static int randomAge() {
        return 18 + random.nextInt(50);
    }

    public static String randomUsername() {
        return "user" + RandomStringUtils.randomAlphanumeric(6);
    }

    public static String randomPassword() {
        return RandomStringUtils.randomAlphanumeric(10);
    }
}
