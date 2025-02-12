package pageWeb;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
    WebDriver driver;
    By productImage = By.xpath("//*[@id=\"imgp\"]/div/img");
    By productDesc = By.id("more-information");
    By addToCartButton = By.cssSelector("#tbodyid > div.row > div > a");
    By homeMenu = By.xpath("//*[@id=\"navbarExample\"]/ul/li[1]/a");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void validateProductPictureExist() {
        WebElement imageElement = this.driver.findElement(this.productImage);
        Assert.assertTrue(imageElement.isDisplayed());
    }

    public void validateProductDescriptionExist() {
        WebElement descriptionElement = this.driver.findElement(this.productDesc);
        Assert.assertTrue(descriptionElement.isDisplayed());
    }

    public void clickAddToCart() {
        this.driver.findElement(this.addToCartButton).click();
    }

    public void acceptAlertProductAdded() {
        Alert alert = this.driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert Text: " + alertText);
        alert.accept();
    }

    public void clickHomeMenu() {
        this.driver.findElement(this.homeMenu).click();
    }
}
