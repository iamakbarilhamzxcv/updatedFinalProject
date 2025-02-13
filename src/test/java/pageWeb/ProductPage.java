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
        WebElement imageElement = driver.findElement(productImage);
        Assert.assertTrue(imageElement.isDisplayed());
    }

    public void validateProductDescriptionExist() {
        WebElement descriptionElement = driver.findElement(productDesc);
        Assert.assertTrue(descriptionElement.isDisplayed());
    }

    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void acceptAlertProductAdded() {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert Text: " + alertText);
        alert.accept();
    }

    public void clickHomeMenu() {
        driver.findElement(homeMenu).click();
    }
}
