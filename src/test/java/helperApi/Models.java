package helperApi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

public class Models {
    private static RequestSpecification request;

    public Models() {
    }

    public static void setupHeaders() {
        request = RestAssured.given().headers("Content-Type", "application/json", new Object[0]).headers("Accept", "application/json", new Object[0]).headers("app-id", "63a804408eb0cb069b57e43a", new Object[0]);
    }

    public static Response getListUsers(String endpoint) {
        setupHeaders();
        return (Response)request.when().get(endpoint, new Object[0]);
    }

    public static Response postCreateUser(String endpoint) {
        String firstName = "akbar ilham";
        String lastName = "nurmagomedov";
        String email = Utility.generateRandomEmail();
        JSONObject payload = new JSONObject();
        payload.put("firstName", firstName);
        payload.put("lastName", lastName);
        payload.put("email", email);
        setupHeaders();
        String finalEndpoint = endpoint + "/create";
        System.out.println("Final Endpoint: " + finalEndpoint);
        return (Response)request.body(payload.toString()).when().post(finalEndpoint, new Object[0]);
    }

    public static Response deleteUser(String endpoint, String id) {
        setupHeaders();
        String finalEndpoint = endpoint + "/" + id;
        System.out.println("Final Endpoint: " + finalEndpoint);
        return (Response)request.when().delete(finalEndpoint, new Object[0]);
    }

    public static Response updateUser(String endpoint, String id) {
        setupHeaders();
        String firstName = "akbar mcgregor";
        String lastName = "nurmagomedov";
        String email = Utility.generateRandomEmail();
        JSONObject payload = new JSONObject();
        payload.put("firstName", firstName);
        payload.put("lastName", lastName);
        payload.put("email", email);
        String finalEndpoint = endpoint + "/" + id;
        System.out.println("Final Endpoint: " + finalEndpoint);
        return (Response)request.body(payload.toString()).when().put(finalEndpoint, new Object[0]);
    }
}
