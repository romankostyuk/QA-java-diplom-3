import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;
import pages.ProfilePage;


public class ProfilePageTest extends TestsWithAuth {
    @Test
    @DisplayName("Переход в Личный Кабинет")
    public void checkTransitionToProfilePageTest() {
        LoginPage page = new LoginPage(driver);
        page.goToLoginPageByHeaderLink();
        page.loginAccount(email, password);
        ProfilePage pPage = new ProfilePage(driver);
        pPage.goToProfilePage();
        Assert.assertTrue(pPage.isExitFromAccountDisplayed());
    }

    @Test
    @DisplayName("Переход из личного кабинета")
    public void checkTransitionToConstructorFromProfilePageTest() {
        LoginPage page = new LoginPage(driver);
        page.goToLoginPageByHeaderLink();
        page.loginAccount(email, password);
        ProfilePage pPage = new ProfilePage(driver);
        pPage.goToProfilePage();
        pPage.goToConstructor();
        Assert.assertTrue(pPage.isConstructorDisplayed());
    }

    @Test
    @DisplayName("Выход из личного кабинета")
    public void exitFromProfilePageTest() {
        LoginPage page = new LoginPage(driver);
        page.goToLoginPageByHeaderLink();
        page.loginAccount(email, password);
        ProfilePage pPage = new ProfilePage(driver);
        pPage.goToProfilePage();
        pPage.exitFromAccount();
        Assert.assertTrue(pPage.isExitDisplayed());
    }
}