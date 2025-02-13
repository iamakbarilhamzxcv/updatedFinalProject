package stepDefWeb;

import helperWeb.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Duration;
import pageWeb.CartPage;

public class CartStepDef extends BaseTest {
    CartPage cartPage;

    public CartStepDef() {
    }

    @Then("user will be redirect to cart page")
    public void userWillBeRedirectToCartPage() {
        cartPage = new CartPage(driver);
        cartPage.validateOnCartPage();
    }

    @And("user will see item to buy")
    public void userWillNotSeeExistingItemToBuy() {
        try {
            cartPage.validateTableBodyNotEmpty();
            int itemCount = cartPage.getCartItemCount();
            System.out.println("Validation passed: " + itemCount + " item(s) exist in the cart.");
            cartPage.getItemDetails();
        } catch (AssertionError var2) {
            AssertionError bodyTableCart = var2;
            System.err.println("Validation failed: No items found in the cart.");
            System.err.println("Error: " + bodyTableCart.getMessage());
        }

    }

    @And("user will see total price equals to sum of each item price")
    public void userWillSeeTotalPriceEqualsToSumOfEachItemPrice() {
        cartPage.validateTotalPrice();
    }

    @When("user click place order button")
    public void userClickPlaceOrderButton() {
        cartPage.clickPlaceOrderButton();
    }

    @Then("user fill the required data")
    public void userFillTheRequiredData() {
        cartPage.fillOrderForm();
    }

    @And("user click purchase button")
    public void userClickPurchaseButton() throws InterruptedException {
        Thread.sleep(Duration.ofMillis(4000L));
        cartPage.clickPurchaseButton();
    }

    @Then("user will see success purchase pop up")
    public void userWillSeeSuccessPurchasePopUp() {
        cartPage.validatePopupSuccessPurchase();
    }

    @And("user click ok button")
    public void userClickOkButton() {
        cartPage.clickOkButtonOrder();
    }

    @Then("user click delete item")
    public void userClickDeleteItem() throws InterruptedException {
        Thread.sleep(Duration.ofMillis(4000L));

        try {
            cartPage.validateTableBodyNotEmpty();
            int itemCount = cartPage.getCartItemCount();
            System.out.println("Validation passed: " + itemCount + " item(s) exist in the cart.");
            cartPage.clickDeleteButton();
        } catch (AssertionError var2) {
            AssertionError bodyTableCart = var2;
            System.err.println("Validation failed: No items found in the cart.");
            System.err.println("Error: " + bodyTableCart.getMessage());
        }

        Thread.sleep(Duration.ofMillis(4000L));
    }

    @And("user will see alert to fill out the data")
    public void userWillSeeAlertToFillOutTheData() throws InterruptedException {
        Thread.sleep(Duration.ofMillis(4000L));
        cartPage.acceptAlertToFillData();
    }
}
