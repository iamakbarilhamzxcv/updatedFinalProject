package pageWeb;

import java.util.Iterator;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    WebDriver driver;
    By tableBody = By.id("tbodyid");
    By totalPriceElement = By.id("totalp");
    By placeOrderButton = By.cssSelector("#page-wrapper > div > div.col-lg-1 > button");
    By inputName = By.id("name");
    By inputCountry = By.id("country");
    By inputCity = By.id("city");
    By inputCreditCard = By.id("card");
    By inputMonth = By.id("month");
    By inputYear = By.id("year");
    By purchaseButton = By.cssSelector("#orderModal > div > div > div.modal-footer > button.btn.btn-primary");
    By greetingText = By.cssSelector("div.sweet-alert.showSweetAlert.visible > h2");
    By checklistImage = By.cssSelector("body > div.sweet-alert.showSweetAlert.visible > div.sa-icon.sa-success.animate");
    By orderDetails = By.xpath("/html/body/div[10]/p");
    By okButtonOrder = By.cssSelector("body > div.sweet-alert.showSweetAlert.visible > div.sa-button-container > div > button");
    By deleteButtonItem = By.cssSelector("#tbodyid > tr:nth-child(1) > td:nth-child(4) > a");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void validateOnCartPage() {
        String expectedUrl = "https://www.demoblaze.com/cart.html";
        String actualUrl = this.driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    public int getCartItemCount() {
        WebElement tbodyCartElement = this.driver.findElement(this.tableBody);
        List<WebElement> rows = tbodyCartElement.findElements(By.tagName("tr"));
        return rows.size();
    }

    public void validateTableBodyNotEmpty() {
        WebElement tbodyCartElement = this.driver.findElement(this.tableBody);
        List<WebElement> rows = tbodyCartElement.findElements(By.tagName("tr"));
        Assert.assertFalse(rows.isEmpty());
    }

    public void getItemDetails() {
        WebElement tbodyCartElement = this.driver.findElement(this.tableBody);
        List<WebElement> rows = tbodyCartElement.findElements(By.tagName("tr"));
        Iterator var3 = rows.iterator();

        while(var3.hasNext()) {
            WebElement row = (WebElement)var3.next();
            String title = row.findElement(By.xpath(".//td[2]")).getText();
            String price = row.findElement(By.xpath(".//td[3]")).getText();
            System.out.println("Item Title: " + title + ", Price: " + price);
        }

    }

    public void validateTotalPrice() {
        WebElement tbodyCartElement = this.driver.findElement(this.tableBody);
        List<WebElement> rows = tbodyCartElement.findElements(By.tagName("tr"));
        double calculatedTotal = 0.0;

        double price;
        for(Iterator var5 = rows.iterator(); var5.hasNext(); calculatedTotal += price) {
            WebElement row = (WebElement)var5.next();
            String priceText = row.findElement(By.xpath(".//td[3]")).getText().replace("$", "").trim();
            price = Double.parseDouble(priceText);
        }

        String totalText = this.driver.findElement(this.totalPriceElement).getText().replace("$", "").trim();
        double displayedTotal = Double.parseDouble(totalText);
        Assert.assertEquals("Total price does not match the sum of item prices.", calculatedTotal, displayedTotal, 0.01);
    }

    public void clickPlaceOrderButton() {
        this.driver.findElement(this.placeOrderButton).click();
    }

    public void fillOrderForm() {
        this.driver.findElement(this.inputName).sendKeys(new CharSequence[]{"Akbar Ilham"});
        this.driver.findElement(this.inputCountry).sendKeys(new CharSequence[]{"Indonesia"});
        this.driver.findElement(this.inputCity).sendKeys(new CharSequence[]{"Jakarta"});
        this.driver.findElement(this.inputCreditCard).sendKeys(new CharSequence[]{"112233"});
        this.driver.findElement(this.inputMonth).sendKeys(new CharSequence[]{"03"});
        this.driver.findElement(this.inputYear).sendKeys(new CharSequence[]{"2027"});
    }

    public void clickPurchaseButton() {
        this.driver.findElement(this.purchaseButton).click();
    }

    public void validatePopupSuccessPurchase() {
        WebElement greetingElement = this.driver.findElement(this.greetingText);
        String actualText = greetingElement.getText();
        String expectedText = "Thank you for your purchase!";
        Assert.assertEquals("Popup text tidak sesuai!", expectedText, actualText);
        WebElement checklistElement = this.driver.findElement(this.checklistImage);
        Assert.assertTrue("Checklist image tidak muncul!", checklistElement.isDisplayed());
        WebElement orderElement = this.driver.findElement(this.orderDetails);
        String orderText = orderElement.getText();
        String[] lines = orderText.split("\n");
        String idOrder = lines[0].split(": ")[1].trim();
        String amountOrder = lines[1].split(": ")[1].trim();
        String cardNumberOrder = lines[2].split(": ")[1].trim();
        String nameOrder = lines[3].split(": ")[1].trim();
        Assert.assertFalse("ID Order tidak boleh kosong!", idOrder.isEmpty());
        String expectedAmount = this.driver.findElement(this.totalPriceElement).getText().trim();
        Assert.assertTrue("Amount order tidak sesuai!", amountOrder.contains(expectedAmount));
        Assert.assertEquals("Nomor kartu tidak sesuai!", "112233", cardNumberOrder);
        Assert.assertEquals("Nama tidak sesuai!", "Akbar Ilham", nameOrder);
    }

    public void clickOkButtonOrder() {
        this.driver.findElement(this.okButtonOrder).click();
    }

    public void clickDeleteButton() {
        this.driver.findElement(this.deleteButtonItem).click();
        this.driver.navigate().refresh();
    }

    public void acceptAlertToFillData() {
        Alert alert = this.driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert Text: " + alertText);
        alert.accept();
    }
}
