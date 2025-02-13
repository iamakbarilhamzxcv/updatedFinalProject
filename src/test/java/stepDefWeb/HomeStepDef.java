package stepDefWeb;

import helperWeb.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Duration;
import pageWeb.HomePage;

public class HomeStepDef extends BaseTest {
    HomePage homePage;

    public HomeStepDef() {
    }

    @Then("user will be redirect to home page")
    public void userWillBeRedirectToHomePage() throws InterruptedException {
        Thread.sleep(Duration.ofMillis(6000L));
        homePage = new HomePage(driver);
        homePage.validateOnHomePage();
    }

    @And("user click an item")
    public void userClickAnItem() {
        homePage.clickAnItem();
    }

    @And("user click laptops categories")
    public void userClickLaptopsCategories() {
        homePage.clickLaptopsCategories();
    }

    @And("user click another item")
    public void userClickAnotherItem() {
        scrollPageOnce();
        homePage.clickAnotherItem();
    }

    @When("user click cart menu")
    public void userClickCartMenu() {
        homePage.clickCartMenu();
    }

    @When("user click logout menu")
    public void userClickLogoutMenu() {
        homePage.clickLogoutMenu();
    }

    @When("user click contact menu")
    public void userClickContactMenu() {
        homePage.clickContactMenu();
    }

    @Then("user fill contact email and message")
    public void userFillContactEmailAndMessage() {
        homePage.fillDataMessage();
    }

    @And("user click send message button")
    public void userClickSendMessageButton() {
        homePage.clickSendMessage();
    }

    @And("user will see thanks pop up")
    public void userWillSeeThanksPopUp() throws InterruptedException {
        Thread.sleep(Duration.ofMillis(4000L));
        homePage.acceptAlertThanksMessage();
    }

    @When("user click about us menu")
    public void userClickAboutUsMenu() {
        homePage.clickAboutUsMenu();
    }

    @Then("user click video play button")
    public void userClickVideoPlayButton() throws InterruptedException {
        homePage.playVideo();
        Thread.sleep(Duration.ofMillis(10000L));
        homePage.validateVideoPlayed();
    }

    @And("user click close video button")
    public void userClickCloseVideoButton() {
        homePage.closeVideo();
    }
}
