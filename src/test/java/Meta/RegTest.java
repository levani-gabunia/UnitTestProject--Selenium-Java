package Meta;
import Utils.Retry;
import Utils.Starter;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import Pages.RegistrationPage;
import static DataObject.RegisterData.*;

public class RegTest extends Starter {
    @Test(retryAnalyzer = Retry.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Register with valid credentials")
    public void Registration() throws InterruptedException {
        RegistrationPage rp = new RegistrationPage(driver);
        rp.GotoCreateAccount()
                .FillFirstName(firstName)
                .FillLastName(lastName)
                .FillMobileNumber(phoneNumber)
                .FillBirthMonth(birthMonth)
                .FillBirthDay(birthDay)
                .FillBirthYear(birthYear)
                .SelectGender()
                .SignUpBtnClick();
    }
}