import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;

public class LoginTests extends BaseTest {
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();

    @Test(description ="Basarili kullanici girisi")
    public void SuccessfulLogin() {
        loginPage.fillUsername(username)
                .fillPassword(password)
                .clickLoginButton();
        mainPage.dashboardControl();
    }

    @Test(description = "Basarisiz kullanici girisi")
    public void UnsuccessfulLogin() {
        loginPage.fillUsername(username)
                .fillPassword("test123")
                .clickLoginButton()
                .errorMessageControl();
    }

    @Test(description = "Minimum karakter girisi")
    public void minCharacterControl() {
        loginPage.fillUsername("a")
                .fillPassword("1")
                .clickLoginButton()
                .errorMessageControl();
    }

    @Test(description = "Maximum karakter girisi")
    public void maxCharacterControl() {
        loginPage.fillUsername("aasdklekrlekrlaekrlaekrlaekrelarkalekrleakrlaekraelrklaerkkkkkkkkealrkealkrelakrcalekralmmmmmmmmmmmmmmmmmmmmmmmmmmevnvlsntvldsdsbndsmfbndmföbndsfbmmndsfbmnsdbnsdfmbndsfbdlladlaeodlaodleaodleodlaodlaodlasoldasoldasoldasodlasodlasodlasodlasodl")
                .fillPassword("acasnmdcbsamdncbasmndcbasdmöcbnsadmncbsadcnbsdmcbnsdancbasdmncbsdncbasömdcbasdmncbsadnmcbsdmncbasmdncbasmndcbsdnmcbasdmncbasmndcbasmdncbsadmncbsadmncbsadmncbsadmncbsadnmcbsadnmcbsadmncbsdmnsdbcmansdbcmnsdbcsadmncbsdmncbsmdncbsdmncbsdmncbsdmn")
                .clickLoginButton()
                .errorMessageControl();
    }
}
