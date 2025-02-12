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
        this.homePage = new HomePage(driver);
        this.homePage.validateOnHomePage();
    }

    @And("user click an item")
    public void userClickAnItem() {
        this.homePage.clickAnItem();
    }

    @And("user click laptops categories")
    public void userClickLaptopsCategories() {
        this.homePage.clickLaptopsCategories();
    }

    @And("user click another item")
    public void userClickAnotherItem() {
        this.scrollPageOnce();
        this.homePage.clickAnotherItem();
    }

    @When("user click cart menu")
    public void userClickCartMenu() {
        this.homePage.clickCartMenu();
    }

    @When("user click logout menu")
    public void userClickLogoutMenu() {
        this.homePage.clickLogoutMenu();
    }

    @When("user click contact menu")
    public void userClickContactMenu() {
        this.homePage.clickContactMenu();
    }

    @Then("user fill contact email and message")
    public void userFillContactEmailAndMessage() {
        this.homePage.fillDataMessage();
    }

    @And("user click send message button")
    public void userClickSendMessageButton() {
        this.homePage.clickSendMessage();
    }

    @And("user will see thanks pop up")
    public void userWillSeeThanksPopUp() throws InterruptedException {
        Thread.sleep(Duration.ofMillis(4000L));
        this.homePage.acceptAlertThanksMessage();
    }

    @When("user click about us menu")
    public void userClickAboutUsMenu() {
        this.homePage.clickAboutUsMenu();
    }

    @Then("user click video play button")
    public void userClickVideoPlayButton() throws InterruptedException {
        this.homePage.playVideo();
        Thread.sleep(Duration.ofMillis(10000L));
        this.homePage.validateVideoPlayed();
    }

    @And("user click close video button")
    public void userClickCloseVideoButton() {
        this.homePage.closeVideo();
    }
}
