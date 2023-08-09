package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    //Локаторы для кнопки/поля для входа в "Личный Кабинет"
    private final By loginButton = By.xpath("//button[text() = 'Войти в аккаунт']");
    private final By getOrderButton = By.xpath("//button[text() = 'Оформить заказ']");
    private final By emailForLogin = By.xpath("//label[text() = 'Email']/parent::*/input");
    private final By passwordForLogin = By.xpath("//label[text() = 'Пароль']/parent::*/input");
    private final By loginButtonOnRegister = By.xpath("//a[text() = 'Войти']");
    private final By loginButtonForLogin = By.xpath("//button[text() = 'Войти']");
    private final By nameForRegister = By.xpath("//label[text() = 'Имя']/parent::*/input");
    private final By emailForRegister = By.xpath("//label[text() = 'Email']/parent::*/input");
    private final By passwordForRegister = By.xpath("//label[text() = 'Пароль']/parent::*/input");
    private final By registerButtonForRegister = By.xpath("//button[text() = 'Зарегистрироваться']");
    private final By buttonForLoginAfterRegister = By.xpath("//button[text() = 'Войти']");
    private final By buttonForRestPassword = By.xpath("//a[text() = 'Восстановить пароль']");
    private final By buttonForLoginInResetPassword = By.xpath("//a[text() = 'Войти']");
    private final WebDriver driver;
    private final By registrationLinkButton = By.xpath("//a[text() = 'Зарегистрироваться']");
    private final By incorrectPassword = By.xpath("//*[text() = 'Некорректный пароль']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Перейти на страницу входа")
    public void gotoLoginPageByEnterAccountButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Перейти на страницу регистрации")
    public void gotoRegistrationPage() {
        this.gotoLoginPageByEnterAccountButton();
        WebElement element = driver.findElement(registrationLinkButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    @Step("Регистрация нового аккаунта")
    public void registerNewAccount(String name, String email, String password) {
        driver.findElement(nameForRegister).clear();
        driver.findElement(nameForRegister).sendKeys(name);
        driver.findElement(emailForRegister).clear();
        driver.findElement(emailForRegister).sendKeys(email);
        driver.findElement(passwordForRegister).clear();
        driver.findElement(passwordForRegister).sendKeys(password);
        driver.findElement(registerButtonForRegister).click();
    }

    public boolean isIncorrectPasswordDisplayed() {
        return driver.findElement(incorrectPassword).isDisplayed();
    }

    public void goToLoginPageByHeaderLink() {
        driver.findElement(loginButton).click();
    }

    public void loginAccount(String email, String password) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(loginButtonForLogin));
        driver.findElement(emailForLogin).clear();
        driver.findElement(emailForLogin).sendKeys(email);
        driver.findElement(passwordForLogin).clear();
        driver.findElement(passwordForLogin).sendKeys(password);
        driver.findElement(loginButtonForLogin).click();
    }

    public boolean isCheckoutButtonDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(getOrderButton));
        return driver.findElement(getOrderButton).isDisplayed();
    }

    public boolean isLogButtonDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonForLoginAfterRegister));
        return driver.findElement(buttonForLoginAfterRegister).isDisplayed();
    }

    public void gotoLoginPageFromRegistration() {
        this.gotoRegistrationPage();
        WebElement element = driver.findElement(loginButtonOnRegister);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public void gotoForgotPasswordPage() {
        this.gotoLoginPageByEnterAccountButton();
        WebElement element = driver.findElement(buttonForRestPassword);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public void gotoLoginPageFromForgotPassword() {
        this.gotoForgotPasswordPage();
        WebElement element = driver.findElement(buttonForLoginInResetPassword);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }
}
