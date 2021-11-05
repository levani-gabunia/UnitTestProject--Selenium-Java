package Meta.Security.Positive;

import Pages.LoginPage;
import Utils.Retry;
import Utils.Starter;
import Utils.TestAllureListener;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static DataObject.RegisterData.*;

@Listeners({TestAllureListener.class})
public class LoginTest extends Starter{
    @Test(retryAnalyzer = Retry.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Login with valid credentials")
    @Link(name = "alta", type = "https://alta.ge/")
    public void Login() throws InterruptedException {
        LoginPage rp = new LoginPage(driver);
        rp.GotoSignIn()
                .FillMail(email)
                .FillPassword(password)
                .LoginSubmit();
    }
}
