import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pages.ConstructorPage;


public class ConstructorTest extends TestsWithoutAuth {
    @Test
    @DisplayName("Переход к Булки")
    public void BunTabActivatedTest() {
        ConstructorPage page = new ConstructorPage(driver);
        page.clickFillingTab();
        page.clickBunTab();
        Assert.assertTrue(page.getSelectedSection().contains("Булки"));
    }
    @Test
    @DisplayName("Переход к Начинки")
    public void fillingTabActivatedTest() {
        ConstructorPage page = new ConstructorPage(driver);
        page.clickFillingTab();
        Assert.assertTrue(page.getSelectedSection().contains("Начинки"));
    }

    @Test
    @DisplayName("Переход к Соусы")
    public void sauceTabActivatedTest() {
        ConstructorPage page = new ConstructorPage(driver);
        page.clickSauceTab();
        Assert.assertTrue(page.getSelectedSection().contains("Соусы"));
    }

    @Test
    @DisplayName("Раздел Булки активен по умолчанию")
    public void bunSectionActivatedByDefaultTest() {
        ConstructorPage page = new ConstructorPage(driver);
        Assert.assertTrue(page.getSelectedSection().contains("Булки"));
    }
}