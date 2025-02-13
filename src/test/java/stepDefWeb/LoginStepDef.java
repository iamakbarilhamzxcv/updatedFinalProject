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
        loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
    }

    @Then("user is on login page")
    public void userIsOnLoginPage() throws InterruptedException {
        Thread.sleep(Duration.ofMillis(4000));
        loginPage.validateOnLoginPage();
    }

    @And("user click the log in menu")
    public void userClickTheLogInMenu() {
        loginPage.clickLoginMenu();
    }

    @And("user input username on text box with {string}")
    public void userInputUsernameOnTextBoxWith(String username) {
        loginPage.inputUsername(username);
    }

    @And("user input password on the text box  with {string}")
    public void userInputPasswordOnTheTextBoxWith(String password) {
        loginPage.inputPassword(password);
    }

    @When("user click log in button")
    public void userClickLogInButton() {
        loginPage.clickLoginButton();
    }

    @Then("user able to see alert error login")
    public void userAbleToSeeAlertErrorLogin() throws InterruptedException {
        Thread.sleep(Duration.ofMillis(4000));
        loginPage.acceptAlertWrongPasswordLogin();
    }

    @Given("user already login with username {string} and password {string}")
    public void userAlreadyLoginWithUsernameAndPassword(String username, String password) {
        loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
        loginPage.validateOnLoginPage();
        loginPage.clickLoginMenu();
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();
    }
}
