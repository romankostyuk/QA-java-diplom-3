import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pages.ConstructorPage;


public class ConstructorTest extends TestsWithoutAuth {
    @Test
    @DisplayName("Переход к Начинки")
    public void fillingTabActivatedTest() {
        ConstructorPage page = new ConstructorPage(driver);
        page.clickFillingTab();
        Assert.assertTrue(page.isFillingTabDisplayed());
    }

    @Test
    @DisplayName("Переход к Соусы")
    public void sauceTabActivatedTest() {
        ConstructorPage page = new ConstructorPage(driver);
        page.clickSauceTab();
        Assert.assertTrue(page.isSauceTabActivated());
    }

    @Test
    @DisplayName("Раздел Булки активен по умолчанию")
    public void bunSectionActivatedByDefaultTest() {
        ConstructorPage page = new ConstructorPage(driver);
        Assert.assertTrue(page.isBunTabActivated());
    }
}