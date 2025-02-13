package pageWeb;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;
    By loginMenu = By.xpath("//*[@id=\"login2\"]");
    By usernameInputText = By.id("loginusername");
    By passwordInputText = By.id("loginpassword");
    By loginButton = By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToLoginPage() {
        driver.get("https://www.demoblaze.com/");
    }

    public void validateOnLoginPage() {
        WebElement loginElement = driver.findElement(loginMenu);
        Assertions.assertTrue(loginElement.isDisplayed());
        Assertions.assertEquals("Log in", loginElement.getText());
    }

    public void clickLoginMenu() {
        driver.findElement(loginMenu).click();
    }

    public void inputUsername(String username) {
        driver.findElement(usernameInputText).sendKeys(username);
    }

    public void inputPassword(String password) {
        driver.findElement(passwordInputText).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void acceptAlertWrongPasswordLogin() {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert Text: " + alertText);
        alert.accept();
    }
}
