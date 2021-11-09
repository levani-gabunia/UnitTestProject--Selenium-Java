package Meta.Security.Negative;

import Pages.LoginPage;
import Pages.RecoveryPage;
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
import static DataObject.RegisterData.email;

@Listeners({TestAllureListener.class})
public class RecoveryTest extends Starter {
    RecoveryPage RecoveryPage;

    @BeforeMethod(description = "Configure browser before tests")
    public void setUp(){
        initialize_driver();
        RecoveryPage = new RecoveryPage(driver);
    }

    @Test(retryAnalyzer = Retry.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Recovery with empty Field")
    @Link(name = "alta", type = "https://alta.ge/")
    public void Recovery() throws InterruptedException {
        RecoveryPage.GotoCreateAccount()
                .GoToRecovery()
                .FillMailEmpty()
                .ClickSubmitForEmpty();
    }
}