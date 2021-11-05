package Meta.Security.Positive;

import Pages.RecoveryPage;
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
public class RecoveryTest extends Starter {
    @Test(retryAnalyzer = Retry.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Recovery with valid credentials")
    @Link(name = "alta", type = "https://alta.ge/")
    public void Recovery() throws InterruptedException {
        RecoveryPage rp = new RecoveryPage(driver);
        rp.GotoCreateAccount()
                .GoToRecovery()
                .FillMail(email)
                .ClickSubmit()
                .yahooLogin(email,password,city,adress);
    }
}