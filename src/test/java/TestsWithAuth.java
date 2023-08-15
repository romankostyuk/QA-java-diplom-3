import config.UserClient;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import static config.AppConfig.BASE_URL;
import static config.WebDriverFactory.createWebDriver;

public class TestsWithAuth {
    public WebDriver driver;
    public UserClient userClient = new UserClient();
    public String email;
    public String password;

    @Before
    public void setUp() {
        driver = createWebDriver();
        driver.get(BASE_URL);

        email = "rkostiuk123@gmail.com";
        password = "ZXcv12345";
        userClient.register(email, password, "roman");
    }

    @After
    public void teardown() {
        userClient.delete(email, password);
        driver.quit();
    }
}