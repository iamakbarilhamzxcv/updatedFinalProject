package pageWeb;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;
    By nameOfUser = By.id("nameofuser");
    By samsungGalaxys6 = By.cssSelector("#tbodyid > div:nth-child(1) > div > div > h4 > a");
    By laptopCategories = By.xpath("/html/body/div[5]/div/div[1]/div/a[3]");
    By macBookPro = By.cssSelector("#tbodyid > div:nth-child(6) > div > div > h4 > a");
    By cartMenu = By.xpath("//*[@id=\"cartur\"]");
    By logoutMenu = By.id("logout2");
    By contactMenu = By.xpath("//*[@id=\"navbarExample\"]/ul/li[2]/a");
    By inputContactEmail = By.cssSelector("#recipient-email");
    By inputContactName = By.cssSelector("#recipient-name");
    By inputMessage = By.cssSelector("#message-text");
    By sendMessageButton = By.cssSelector("#exampleModal > div > div > div.modal-footer > button.btn.btn-primary");
    By aboutUsMenu = By.xpath("//*[@id=\"navbarExample\"]/ul/li[3]/a");
    By playVideoButton = By.id("example-video");
    By closeVideoButton = By.cssSelector("#videoModal > div > div > div.modal-footer > button");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void validateOnHomePage() {
        WebElement nameOfUserElement = driver.findElement(nameOfUser);
        Assertions.assertTrue(nameOfUserElement.isDisplayed());
        Assertions.assertEquals("Welcome moblaze11", nameOfUserElement.getText());
    }

    public void clickAnItem() {
        driver.findElement(samsungGalaxys6).click();
    }

    public void clickLaptopsCategories() {
        driver.findElement(laptopCategories).click();
    }

    public void clickAnotherItem() {
        driver.findElement(macBookPro).click();
    }

    public void clickCartMenu() {
        driver.findElement(cartMenu).click();
    }

    public void clickLogoutMenu() {
        driver.findElement(logoutMenu).click();
    }

    public void clickContactMenu() {
        driver.findElement(contactMenu).click();
    }

    public void fillDataMessage() {
        driver.findElement(inputContactEmail).sendKeys("emailtujuan@gmail.com");
        driver.findElement(inputContactName).sendKeys("Sahabat Pena");
        driver.findElement(inputMessage).sendKeys("Id: 1968893 ->xpath: /html/body/div[10]/p/text()[1]\nAmount: 1460 USD -> xpath : /html/body/div[10]/p/text()[2]\nCard Number: 112233 -> xpath: /html/body/div[10]/p/text()[3]\nName: Akbar Ilham -> xpath: /html/body/div[10]/p/text()[4]\nDate: 29/0/2025 -> xpath: /html/body/div[10]/p/text()[5]");
    }

    public void clickSendMessage() {
        driver.findElement(sendMessageButton).click();
    }

    public void acceptAlertThanksMessage() {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert Text: " + alertText);
        alert.accept();
    }

    public void clickAboutUsMenu() {
        driver.findElement(aboutUsMenu).click();
    }

    public void playVideo() {
        driver.findElement(playVideoButton).click();
    }

    public void validateVideoPlayed() {
        WebElement video = driver.findElement(By.tagName("video"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        Boolean isPlaying = (Boolean)js.executeScript("return arguments[0].paused === false && arguments[0].readyState >= 3;", new Object[]{video});
        Assertions.assertTrue(isPlaying, "Video tidak berjalan dengan baik");
    }

    public void closeVideo() {
        driver.findElement(closeVideoButton).click();
    }
}
