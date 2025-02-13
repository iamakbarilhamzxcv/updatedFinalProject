package stepDefWeb;

import helperWeb.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Duration;
import pageWeb.ProductPage;

public class ProductStepDef extends BaseTest {
    ProductPage productPage;

    public ProductStepDef() {
    }

    @Then("user will be redirect to product page")
    public void userWillBeRedirectToProductPage() {
        productPage = new ProductPage(driver);
        productPage.validateProductPictureExist();
        productPage.validateProductDescriptionExist();
    }

    @When("user click add to cart button")
    public void userClickAddToCartButton() {
        productPage.clickAddToCart();
    }

    @Then("user able to see alert product added")
    public void userAbleToSeeAlertProductAdded() throws InterruptedException {
        Thread.sleep(Duration.ofMillis(4000L));
        productPage.acceptAlertProductAdded();
    }

    @When("user click home menu")
    public void userClickHomeMenu() {
        productPage.clickHomeMenu();
    }
}
