package stepDefApi;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageApi.ApiPage;

public class apiStepDef {
    ApiPage apiPage = new ApiPage();

    public apiStepDef() {
    }

    @Given("prepare url valid for {string}")
    public void prepareUrlValidFor(String url) {
        this.apiPage.prepareUrlValidFor(url);
    }

    @And("hit api get list user")
    public void hitApiGetListUser() {
        this.apiPage.hitApiGetListUsers();
    }

    @Then("validation status code is equals to {int}")
    public void validationStatusCodeIsEqualsTo(int status_code) {
        this.apiPage.validationStatusCode(status_code);
    }

    @Then("validation response body get list users")
    public void validationResponseBodyGetListUsers() {
        this.apiPage.validationResponseBodyGetListUsers();
    }

    @Then("validation response json with JSONSchema {string}")
    public void validationResponseJsonWithJSONSchema(String filename) {
        this.apiPage.validationResponseJsonWithJSONSchema(filename);
    }

    @And("hit api post create new user")
    public void hitApiPostCreateNewUser() {
        this.apiPage.hitApiPostCreateNewUser();
    }

    @Then("validation response body post new user")
    public void validationResponseBodyPostNewUser() {
        this.apiPage.validateResponseBodyCreateUser();
    }

    @And("hit api delete new")
    public void hitapiDeleteNew() {
        this.apiPage.hitApiDeleteUser();
    }

    @And("hit api update data")
    public void hitApiUpdateData() {
        this.apiPage.hitApiUpdateUser();
    }

    @Then("validation response body update user")
    public void validationResponseBodyUpdateUser() {
        this.apiPage.validationResponseBodyUpdateUser();
    }
}
