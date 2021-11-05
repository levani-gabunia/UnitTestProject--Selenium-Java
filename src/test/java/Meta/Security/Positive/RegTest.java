package Meta.Security.Positive;

import Utils.Retry;
import Utils.Starter;
import Utils.TestAllureListener;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Pages.RegistrationPage;
import static DataObject.RegisterData.*;

@Listeners({TestAllureListener.class})
public class RegTest extends Starter {
    @Test(retryAnalyzer = Retry.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Register with valid credentials")
    @Link(name = "alta", type = "https://alta.ge/")
    public void Registration() throws InterruptedException {
        RegistrationPage rp = new RegistrationPage(driver);
        rp.GotoCreateAccount()
                .FillMail(email)
                .FillPassword(password)
                .FillConfirmPassowrd(password)
                .FillFirstname(firstName)
                .FillLastname(lastName)
/*                .RegSubmitBtn("×\n" +
                        "ინფორმაცია ანგარიში წარმატებით შეიქმნა.")*/;
    }
}