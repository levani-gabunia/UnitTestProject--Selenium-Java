package Meta.Security.Negative;

import Pages.LoginPage;
import Utils.Retry;
import Utils.Starter;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static DataObject.RegisterData.email;
import static DataObject.RegisterData.password;

public class LoginTest extends Starter {
    @Test(retryAnalyzer = Retry.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Login with empty Fields")
    @Link(name = "alta", type = "https://alta.ge/")
    public void Login() throws InterruptedException {
        LoginPage rp = new LoginPage(driver);
        rp.GotoSignIn()
                .EmptyMail()
                .EmptyPassword()
                .LoginSubmitNegativeResult();
    }
}