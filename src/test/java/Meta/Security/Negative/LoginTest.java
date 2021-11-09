package Meta.Security.Negative;

import Pages.LoginPage;
import Utils.Retry;
import Utils.Starter;
import Utils.TestAllureListener;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestAllureListener.class})
public class LoginTest  extends Starter {
    LoginPage loginPage;

    @BeforeMethod(description = "Configure browser before tests")
    public void setUp(){
        initialize_driver();
        loginPage = new LoginPage(driver);
    }

    @Test(retryAnalyzer = Retry.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Login with empty Fields")
    @Link(name = "alta", type = "https://alta.ge/")
    public void Login() throws InterruptedException {
        loginPage.GotoSignIn()
                .EmptyMail()
                .EmptyPassword()
                .LoginSubmitNegativeResult();
    }
}