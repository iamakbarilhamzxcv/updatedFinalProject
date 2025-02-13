package pageApi;

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

import static org.hamcrest.MatcherAssert.assertThat;

public class ApiPage {
    String setURL;
    String global_id;
    Response res;

    public ApiPage() {
    }

    public void prepareUrlValidFor(String url) {
        switch (url) {
            case "GET_LIST_USERS" -> setURL = "https://dummyapi.io/data/v1/user";
            case "CREATE_NEW_USERS" -> setURL = "https://dummyapi.io/data/v1/user";
            case "DELETE_USERS" -> setURL = "https://dummyapi.io/data/v1/user";
            default -> System.out.println("input right url");
        }

    }

    public void hitApiGetListUsers() {
        res = Models.getListUsers(setURL);
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
        res = Models.postCreateUser(setURL);
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
        res = Models.deleteUser(setURL, global_id);
        System.out.println(res.getBody().asString());
    }

    public void hitApiUpdateUser() {
        res = Models.updateUser(setURL, global_id);
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
        global_id = id;
    }
}
