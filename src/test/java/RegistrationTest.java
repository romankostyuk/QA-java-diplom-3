import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;

public class RegistrationTest extends TestsWithoutAuth {
    @Test
    @DisplayName("Регистрация аккаунта")
    public void registrationTest() {
        LoginPage page = new LoginPage(driver);
        page.gotoRegistrationPage();
        page.registerNewAccount("roman", "rkostyuk123@gmail.com", "Zxc567Zxc");
        Assert.assertTrue(page.isLogButtonDisplayed());
        userClient.delete("rkostyuk@gmail.com", "qwerty45678");
    }

    @Test
    @DisplayName("Регистрации аккаунта с неправильным паролем")
    public void registrationWithWrongPasswordTest() {
        LoginPage page = new LoginPage(driver);
        page.gotoRegistrationPage();
        page.registerNewAccount("roman", "rkostyuk123@gmail.com", "1");
        Assert.assertTrue(page.isIncorrectPasswordDisplayed());
    }
}