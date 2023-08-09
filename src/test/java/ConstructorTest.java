import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pages.ConstructorPage;


public class ConstructorTest extends TestsWithoutAuth {
    @Test
    @DisplayName("Переход к разделу с начинкой")
    public void gotoFillingSectionTest() {
        ConstructorPage page = new ConstructorPage(driver);
        page.clickFillingSegment();
        Assert.assertTrue(page.isFillingSegmentDisplayed());
    }

    @Test
    @DisplayName("Переход к разделу соусы из раздела с начинкой")
    public void gotoSauceSectionTest() {
        ConstructorPage page = new ConstructorPage(driver);
        page.clickFillingSegment();
        page.clickSauceSegment();
        Assert.assertTrue(page.isSauceSegmentDisplayed());
    }

    @Test
    @DisplayName("Переход к разделу булок из раздела с соусами")
    public void gotoBunSectionTest() {
        ConstructorPage page = new ConstructorPage(driver);
        page.clickSauceSegment();
        page.clickBunSegment();
        Assert.assertTrue(page.isBunSegmentDisplayed());
    }
}