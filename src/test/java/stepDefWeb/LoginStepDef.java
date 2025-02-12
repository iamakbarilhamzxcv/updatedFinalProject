package stepDefWeb;

import helperWeb.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Duration;
import pageWeb.LoginPage;

public class LoginStepDef extends BaseTest {
    LoginPage loginPage;

    public LoginStepDef() {
    }

    @Given("user go to the target web")
    public void userIsOnHomePage() {
        this.loginPage = new LoginPage(driver);
        this.loginPage.goToLoginPage();
    }

    @Then("user is on login page")
    public void userIsOnLoginPage() throws InterruptedException {
        Thread.sleep(Duration.ofMillis(4000L));
        this.loginPage.validateOnLoginPage();
    }

    @And("user click the log in menu")
    public void userClickTheLogInMenu() {
        this.loginPage.clickLoginMenu();
    }

    @And("user input username on text box with {string}")
    public void userInputUsernameOnTextBoxWith(String username) {
        this.loginPage.inputUsername(username);
    }

    @And("user input password on the text box  with {string}")
    public void userInputPasswordOnTheTextBoxWith(String password) {
        this.loginPage.inputPassword(password);
    }

    @When("user click log in button")
    public void userClickLogInButton() {
        this.loginPage.clickLoginButton();
    }

    @Then("user able to see alert error login")
    public void userAbleToSeeAlertErrorLogin() {
        this.loginPage.acceptAlertWrongPasswordLogin();
    }

    @Given("user already login with username {string} and password {string}")
    public void userAlreadyLoginWithUsernameAndPassword(String username, String password) {
        this.loginPage = new LoginPage(driver);
        this.loginPage.goToLoginPage();
        this.loginPage.validateOnLoginPage();
        this.loginPage.clickLoginMenu();
        this.loginPage.inputUsername(username);
        this.loginPage.inputPassword(password);
        this.loginPage.clickLoginButton();
    }
}
