package Pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegistrationPage extends CommonPage {
    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
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
        Thread.sleep(3000);
        driver.findElement(createAccBTn).click();
        Thread.sleep(3000);
        driver.findElement(loginForm).isDisplayed();
        driver.findElement(registrationBtn).click();
        return this;
    }
    @Step("Fill Email Adress: {0}")
    public RegistrationPage FillMail(String mail) {
        driver.findElement(physicalPersonSlc).isSelected();
        driver.findElement(emailInput).sendKeys(mail);
        return this;
    }
    @Step("Fill Password: {0}")
    public RegistrationPage FillPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }
    @Step("Fill Confirm Password: {0}")
    public RegistrationPage FillConfirmPassowrd(String password) {
        driver.findElement(confirmPassInput).sendKeys(password);
        return this;
    }
    @Step("Fill First Name: {0}")
    public RegistrationPage FillFirstname(String firstname) {
        driver.findElement(firstnameInput).sendKeys(firstname);
        return this;
    }
    @Step("Fill Last Name: {0}")
    public RegistrationPage FillLastname(String lastname) {
        driver.findElement(lastnameInput).sendKeys(lastname);
        return this;
    }
    @Step("Click SubmitBtn: {0}")
    public RegistrationPage RegSubmitBtn(String txt) throws InterruptedException {
        driver.findElement(regSubmitBtn).click();
        Thread.sleep(3000);
        String color = driver.findElement(UImessage).getText();
        Assert.assertEquals(color,txt);
        return this;
    }
}