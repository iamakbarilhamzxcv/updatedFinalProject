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
        WebElement nameOfUserElement = this.driver.findElement(this.nameOfUser);
        Assertions.assertTrue(nameOfUserElement.isDisplayed());
        Assertions.assertEquals("Welcome moblaze11", nameOfUserElement.getText());
    }

    public void clickAnItem() {
        this.driver.findElement(this.samsungGalaxys6).click();
    }

    public void clickLaptopsCategories() {
        this.driver.findElement(this.laptopCategories).click();
    }

    public void clickAnotherItem() {
        this.driver.findElement(this.macBookPro).click();
    }

    public void clickCartMenu() {
        this.driver.findElement(this.cartMenu).click();
    }

    public void clickLogoutMenu() {
        this.driver.findElement(this.logoutMenu).click();
    }

    public void clickContactMenu() {
        this.driver.findElement(this.contactMenu).click();
    }

    public void fillDataMessage() {
        this.driver.findElement(this.inputContactEmail).sendKeys(new CharSequence[]{"emailtujuan@gmail.com"});
        this.driver.findElement(this.inputContactName).sendKeys(new CharSequence[]{"Sahabat Pena"});
        this.driver.findElement(this.inputMessage).sendKeys(new CharSequence[]{"Id: 1968893 ->xpath: /html/body/div[10]/p/text()[1]\nAmount: 1460 USD -> xpath : /html/body/div[10]/p/text()[2]\nCard Number: 112233 -> xpath: /html/body/div[10]/p/text()[3]\nName: Akbar Ilham -> xpath: /html/body/div[10]/p/text()[4]\nDate: 29/0/2025 -> xpath: /html/body/div[10]/p/text()[5]"});
    }

    public void clickSendMessage() {
        this.driver.findElement(this.sendMessageButton).click();
    }

    public void acceptAlertThanksMessage() {
        Alert alert = this.driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert Text: " + alertText);
        alert.accept();
    }

    public void clickAboutUsMenu() {
        this.driver.findElement(this.aboutUsMenu).click();
    }

    public void playVideo() {
        this.driver.findElement(this.playVideoButton).click();
    }

    public void validateVideoPlayed() {
        WebElement video = this.driver.findElement(By.tagName("video"));
        JavascriptExecutor js = (JavascriptExecutor)this.driver;
        Boolean isPlaying = (Boolean)js.executeScript("return arguments[0].paused === false && arguments[0].readyState >= 3;", new Object[]{video});
        Assertions.assertTrue(isPlaying, "Video tidak berjalan dengan baik");
    }

    public void closeVideo() {
        this.driver.findElement(this.closeVideoButton).click();
    }
}
