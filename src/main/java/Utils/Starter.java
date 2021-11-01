package Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.HashMap;
import java.util.Map;

public class Starter {
    protected WebDriver driver;

    @BeforeMethod(description = "Configure browser before tests")
    public void setUp() throws InterruptedException {
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs); //Chrome notification off
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://www.facebook.com/");
        Thread.sleep(5000);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
