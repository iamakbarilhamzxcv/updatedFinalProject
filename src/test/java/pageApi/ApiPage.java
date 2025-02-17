package pageApi;

import helperApi.Endpoint;
import helperApi.Models;
import helperApi.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import java.io.File;
import java.util.List;
import org.assertj.core.api.AssertionsForClassTypes;
import org.hamcrest.Matcher;

import static helperApi.Models.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ApiPage {
    String setURL;
    String global_id;
    Response res;

    public ApiPage() {
    }

    public void prepareUrlValidFor(String url) {
        switch (url){
            case "GET_LIST_USERS":
                setURL = Endpoint.GET_LIST_USERS;
                break;
            case "CREATE_NEW_USERS":
                setURL = Endpoint.CREATE_NEW_USERS;
                break;
            case "DELETE_USERS":
                setURL = Endpoint.DELETE_USERS;
                break;
            default: System.out.println("input right url");;

        }
    }

    public void hitApiGetListUsers() {
        res = getListUsers(setURL);
    }

    public void validationStatusCode(int status_code) {
        AssertionsForClassTypes.assertThat(res.statusCode()).isEqualTo(status_code);
    }

    public void validationResponseBodyGetListUsers() {
        List<Object> id = res.jsonPath().getList("data.id");
        List<Object> title = res.jsonPath().getList("data.title");
        List<Object> firstName = res.jsonPath().getList("data.firstName");
        List<Object> lastName = res.jsonPath().getList("data.lastName");
        List<Object> picture = res.jsonPath().getList("data.picture");

        AssertionsForClassTypes.assertThat(id.get(0)).isNotNull();
        AssertionsForClassTypes.assertThat(title.get(0)).isIn(new Object[]{"ms", "miss", "mrs", "mr", "dr", ""});
        AssertionsForClassTypes.assertThat(firstName.get(0)).isNotNull();
        AssertionsForClassTypes.assertThat(lastName.get(0)).isNotNull();
        AssertionsForClassTypes.assertThat(picture).isNotNull();
    }

    public void validationResponseJsonWithJSONSchema(String filename) {
        File JSONFile = Utility.getJSONSchemaFile(filename);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }

    public void hitApiPostCreateNewUser() {
        res = postCreateUser(setURL);
        System.out.println(res.getBody().asString());
    }

    public void validateResponseBodyCreateUser() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        String id = jsonPathEvaluator.get("id");
        String firstName = jsonPathEvaluator.get("firstName");
        String lastName = jsonPathEvaluator.get("lastName");
        String email = jsonPathEvaluator.get("email");
        AssertionsForClassTypes.assertThat(id).isNotNull();
        AssertionsForClassTypes.assertThat(firstName).isNotNull();
        AssertionsForClassTypes.assertThat(lastName).isNotNull();
        AssertionsForClassTypes.assertThat(email).isNotNull();
        global_id = id;
    }

    public void hitApiDeleteUser() {
        res = deleteUser(setURL, global_id);
        System.out.println(res.getBody().asString());
    }

    public void hitApiUpdateUser() {
        res = updateUser(setURL, global_id);
        System.out.println(res.getBody().asString());
    }

    public void validationResponseBodyUpdateUser() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        String id = jsonPathEvaluator.get("id");
        String firstName = jsonPathEvaluator.get("firstName");
        String lastName = jsonPathEvaluator.get("lastName");
        String email = jsonPathEvaluator.get("email");
        AssertionsForClassTypes.assertThat(id).isNotNull();
        AssertionsForClassTypes.assertThat(firstName).isNotNull();
        AssertionsForClassTypes.assertThat(lastName).isNotNull();
        AssertionsForClassTypes.assertThat(email).isNotNull();
    }

    public void hitApiPostCreateNewUserWithInvalidPayload(){
        res = postCreateUserInvalidPayload(setURL);
        System.out.println(res.getBody().asString());
    }

    public void validationResponseErrorMessage(){
        // Menggunakan JsonPath untuk parsing response
        JsonPath jsonPathEvaluator = res.jsonPath();

        // Validasi bahwa field "error" memiliki nilai "BODY_NOT_VALID"
        String actualError = jsonPathEvaluator.getString("error");
        AssertionsForClassTypes.assertThat(actualError)
                .as("Error message in response")
                .isEqualTo("BODY_NOT_VALID");

        // Pastikan "data" tidak null sebelum validasi
        Object dataObject = jsonPathEvaluator.get("data");
        AssertionsForClassTypes.assertThat(dataObject)
                .as("Data field in response")
                .isNotNull();

        // Validasi bahwa "data" memiliki key yang diharapkan dengan mengecek nullability
        AssertionsForClassTypes.assertThat(jsonPathEvaluator.getString("data.lastName"))
                .as("Error message for lastName")
                .isNotNull()
                .isEqualTo("Path `lastName` is required.");

        AssertionsForClassTypes.assertThat(jsonPathEvaluator.getString("data.firstName"))
                .as("Error message for firstName")
                .isNotNull()
                .isEqualTo("Path `firstName` is required.");

        AssertionsForClassTypes.assertThat(jsonPathEvaluator.getString("data.email"))
                .as("Error message for email")
                .isNotNull()
                .isEqualTo("Path `email` is required.");
    }
}
