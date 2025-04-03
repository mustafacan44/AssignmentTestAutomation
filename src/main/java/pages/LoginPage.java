package pages;

import base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BaseTest {


    @Step("Username alani doldurulur")
    public LoginPage fillUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']"))).sendKeys(username);
        return this;
    }

    @Step("Password alani doldurulur")
    public LoginPage fillPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']"))).sendKeys(password);
        return this;
    }

    @Step("Login alanına tiklanir")
    public LoginPage clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();
        return this;
    }

    @Step("Hata mesaji kontrol edilir")
    public LoginPage errorMessageControl() {
        String text = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='oxd-text oxd-text--p oxd-alert-content-text']"))).getText();
        Assert.assertEquals(text, "Invalid credentials");
        screenshot();
        return this;
    }
}
