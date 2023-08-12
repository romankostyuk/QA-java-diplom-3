import config.UserClient;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.Random;

import static config.AppConfig.BASE_URL;
import static config.WebDriverFactory.createWebDriver;

public class TestsWithoutAuth {
    public WebDriver driver;
    public UserClient userClient = new UserClient();
    String name;
    String email;
    String password;

    @Before
    public void setUp() {
        driver = createWebDriver();
        driver.get(BASE_URL);
        name = RandomStringUtils.randomAlphabetic(6);
        email = RandomStringUtils.randomAlphabetic(6) + "@random.org";
        password = RandomStringUtils.randomAlphabetic(6) + "123";
    }

    @After
    public void teardown() {
        driver.quit();
    }
}