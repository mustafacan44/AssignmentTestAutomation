package pages;

import base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class MainPage extends BaseTest {

    @Step("Dashboard sayfasi kontrol edilir")
    public MainPage dashboardControl(){
        String text = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"))).getText();
        Assert.assertEquals(text, "Dashboard");
        screenshot();
        return this;
    }
}
