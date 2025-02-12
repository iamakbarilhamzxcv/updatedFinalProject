package helperApi;

import java.io.File;
import org.apache.commons.lang3.RandomStringUtils;

public class Utility {
    public Utility() {
    }

    public static File getJSONSchemaFile(String JSONFile) {
        return new File("src/test/java/helperApi/JSONSchemaData/" + JSONFile);
    }

    public static String generateRandomEmail() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz1234567890_-.";
        String email = "";
        String temp = RandomStringUtils.randomAlphanumeric(10);
        email = temp + "@yuhuu.com";
        return email;
    }
}
