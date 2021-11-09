package Meta.Security.Negative;

import Pages.RegistrationPage;
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

import static DataObject.RegisterData.*;

@Listeners({TestAllureListener.class})
public class RegTest extends Starter {
    RegistrationPage RegistrationPage;

    @BeforeMethod(description = "Configure browser before tests")
    public void setUp(){
        initialize_driver();
        RegistrationPage = new RegistrationPage(driver);
    }

    @Test(retryAnalyzer = Retry.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Register with already existing Account")
    @Link(name = "alta", type = "https://alta.ge/")
    public void Registration() throws InterruptedException {
        RegistrationPage.GotoCreateAccount()
                .FillMail(emailAlreadyRegistered)
                .FillPassword(password)
                .FillConfirmPassowrd(password)
                .FillFirstname(firstName)
                .FillLastname(lastName)
                .RegSubmitBtn("×\n" +
                        "შეცდომა მომხმარებლის სახელი ან ელ-ფოსტა უკვე არსებობს. სცადეთ სხვა მომხმარებლის სახელი ან პაროლი.");
    }
}