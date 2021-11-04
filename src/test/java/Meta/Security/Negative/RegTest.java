package Meta.Security.Negative;

import Pages.RegistrationPage;
import Utils.Retry;
import Utils.Starter;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static DataObject.RegisterData.*;
import static DataObject.RegisterData.lastName;

public class RegTest extends Starter {
    @Test(retryAnalyzer = Retry.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Register with already existing Account")
    @Link(name = "alta", type = "https://alta.ge/")
    public void Registration() throws InterruptedException {
        RegistrationPage rp = new RegistrationPage(driver);
        rp.GotoCreateAccount()
                .FillMail(emailAlreadyRegistered)
                .FillPassword(password)
                .FillConfirmPassowrd(password)
                .FillFirstname(firstName)
                .FillLastname(lastName)
                .RegSubmitBtn("×\n" +
                        "შეცდომა მომხმარებლის სახელი ან ელ-ფოსტა უკვე არსებობს. სცადეთ სხვა მომხმარებლის სახელი ან პაროლი.");
    }
}