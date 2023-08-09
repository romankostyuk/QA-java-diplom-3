import config.UserClient;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import static config.AppConfig.BASE_URL;
import static config.WebDriverFactory.createWebDriver;

public class TestsWithoutAuth {
    public WebDriver driver;
    public UserClient userClient = new UserClient();

    @Before
    public void setUp() {
        driver = createWebDriver();
        driver.get(BASE_URL);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}