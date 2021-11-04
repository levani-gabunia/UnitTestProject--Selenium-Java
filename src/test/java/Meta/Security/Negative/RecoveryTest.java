package Meta.Security.Negative;

import Pages.RecoveryPage;
import Utils.Retry;
import Utils.Starter;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static DataObject.RegisterData.email;

public class RecoveryTest extends Starter {
    @Test(retryAnalyzer = Retry.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Recovery with empty Field")
    @Link(name = "alta", type = "https://alta.ge/")
    public void Recovery() throws InterruptedException {
        RecoveryPage rp = new RecoveryPage(driver);
        rp.GotoCreateAccount()
                .GoToRecovery()
                .FillMail(email)
                .ClickSubmit();
    }
}