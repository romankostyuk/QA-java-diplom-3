package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ConstructorPage {
    private static final By bunSegment = By.xpath(".//h2[text()='Булки']");
    private static final By sauceSegment = By.xpath(".//h2[text()='Соусы']");
    private static final By fillingSegment = By.xpath(".//h2[text()='Начинки']");
    private final WebDriver driver;
    private final By bunHeader = By.xpath(".//div/span[text()='Булки']");
    private final By sauceHeader = By.xpath(".//div/span[text()='Соусы']");
    private final By fillingHeader = By.xpath(".//div/span[text()='Начинки']");

    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик на Булки")
    public void clickBunSegment() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(bunHeader));
        driver.findElement(bunHeader).click();
    }

    @Step("Клик на Соусы")
    public void clickSauceSegment() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(sauceHeader));
        driver.findElement(sauceHeader).click();
    }

    @Step("Клик на Начинки")
    public void clickFillingSegment() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(fillingHeader));
        driver.findElement(fillingHeader).click();
    }

    @Step("Булки отображаются")
    public boolean isBunSegmentDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(bunSegment));
        return driver.findElement(bunSegment).isDisplayed();
    }

    @Step("Соусы отображаются")
    public boolean isSauceSegmentDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(sauceSegment));
        return driver.findElement(sauceSegment).isDisplayed();
    }

    @Step("Начинки отображается")
    public boolean isFillingSegmentDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(fillingSegment));
        return driver.findElement(fillingSegment).isDisplayed();
    }
}