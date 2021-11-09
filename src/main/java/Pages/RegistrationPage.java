package Pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RegistrationPage extends CommonPage {
    WebDriver driver;
    WebDriverWait wait;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    By registrationBtn = By.className("ty-login-reglink__a");
    By physicalPersonSlc = By.xpath("//*[@id=\"user_type\"]/input[1]");
    By emailInput = By.name("user_data[email]");
    By passwordInput = By.name("user_data[password1]");
    By confirmPassInput = By.name("user_data[password2]");
    By firstnameInput = By.name("user_data[firstname]");
    By lastnameInput = By.name("user_data[lastname]");
    By regSubmitBtn = By.name("dispatch[profiles.update]");

    @Step("Click Create Account Button")
    public RegistrationPage GotoCreateAccount() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(createAccBTn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(registrationBtn)).click();
        return this;
    }
    @Step("Fill Email Adress: {0}")
    public RegistrationPage FillMail(String mail) {
        wait.until(ExpectedConditions.elementToBeClickable(physicalPersonSlc)).isSelected();
        wait.until(ExpectedConditions.elementToBeClickable(emailInput)).sendKeys(mail);
        return this;
    }
    @Step("Fill Password: {0}")
    public RegistrationPage FillPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordInput)).sendKeys(password);
        return this;
    }
    @Step("Fill Confirm Password: {0}")
    public RegistrationPage FillConfirmPassowrd(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(confirmPassInput)).sendKeys(password);

        return this;
    }
    @Step("Fill First Name: {0}")
    public RegistrationPage FillFirstname(String firstname) {
        wait.until(ExpectedConditions.elementToBeClickable(firstnameInput)).sendKeys(firstname);

        return this;
    }
    @Step("Fill Last Name: {0}")
    public RegistrationPage FillLastname(String lastname) {
        wait.until(ExpectedConditions.elementToBeClickable(lastnameInput)).sendKeys(lastname);
        return this;
    }
    @Step("Click SubmitBtn: {0}")
    public RegistrationPage RegSubmitBtn(String txt) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(regSubmitBtn)).click();
        String color = wait.until(ExpectedConditions.elementToBeClickable(UImessage)).getText();
        Assert.assertEquals(color,txt);
        return this;
    }
}