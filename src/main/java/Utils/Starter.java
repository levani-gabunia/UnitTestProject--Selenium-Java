package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Starter {
    public WebDriver driver;
    public static ThreadLocal<WebDriver> baseDriver = new ThreadLocal<WebDriver>();

    public WebDriver initialize_driver() {
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs); //Chrome notification off
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://alta.ge/?sl=ge");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        baseDriver.set(driver);
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return baseDriver.get();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (ITestResult.FAILURE == result.getStatus()) {
            getScreenshot(result);  //take screenshot if test Fail in screenshots folder
        }
        driver.quit();
    }

    public String getScreenshot(ITestResult result) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/screenshots/" + result.getName() + ".png";
        File destination = new File(path);
        try {
            FileUtils.copyFile(src, destination);
        } catch (IOException e) {
            System.out.println("Capture Failed " + e.getMessage());
        }
        return path;
    }
}
