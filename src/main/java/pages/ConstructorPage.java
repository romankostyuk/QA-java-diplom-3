package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ConstructorPage {
    //private static final By bunSegment = By.xpath(".//h2[text()='Булки']");
    //private static final By sauceSegment = By.xpath(".//h2[text()='Соусы']");
    //private static final By fillingSegment = By.xpath(".//h2[text()='Начинки']");
    private static final By selectedTab = By.xpath(".//div[contains(@class, 'tab_tab_type_current__2BEPc')]");
    private final WebDriver driver;
    private final By bunTabDefault = By.xpath(".//div/span[text()='Булки']");
    private final By sauceTabDefault = By.xpath(".//div/span[text()='Соусы']");
    private final By fillingTabDefault = By.xpath(".//div/span[text()='Начинки']");
    private final By bunTabNoSelect = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[2]/span[text()='Булки']");
    private final By sauceTabNoSelect = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[2]/span[text()='Соусы']");
    private final By fillingTabNoSelect = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[3]/span[text()='Начинки']");
    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик на Булки")
    public void clickBunTab() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(bunTabDefault));
        driver.findElement(bunTabDefault).click();
    }

    @Step("Клик на Соусы")
    public void clickSauceTab() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(sauceTabDefault));
        driver.findElement(sauceTabDefault).click();
    }

    @Step("Клик на Начинки")
    public void clickFillingTab() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(fillingTabDefault));
        driver.findElement(fillingTabDefault).click();
    }

    @Step("Вкладка Булки активна")
    public boolean isBunTabActivated() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(bunTabNoSelect));
        return driver.findElement(bunTabNoSelect).isDisplayed();
    }

    @Step("Вкладка Соусы активна")
    public boolean isSauceTabActivated() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(sauceTabNoSelect));
        return driver.findElement(sauceTabNoSelect).isDisplayed();
    }

    @Step("Вкладка Начинки активна")
    public boolean isFillingTabDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(fillingTabNoSelect));
        return driver.findElement(fillingTabNoSelect).isDisplayed();
    }

    public String getSelectedSection() {
        return driver.findElement(selectedTab).getText();
    }
}