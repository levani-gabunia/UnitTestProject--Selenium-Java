package Pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends CommonPage {
    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    By createAccBTn = By.linkText("Create New Account");
    By firstNameInput = By.xpath("//*[@name=\"firstname\"]");
    By lastNameInput = By.name("lastname");
    By emaiOrMobilelInput = By.name("reg_email__");
    By passwordInput = By.name("reg_passwd__");
    By birthDayInput = By.name("birthday_day");
    By birthMonthInput = By.name("birthday_month");
    By birthYearInput = By.name("birthday_year");
    By fameleSelector = By.xpath("//*[@name=\"sex\"][1]");
    By signUpIconIfDisplayed = By.xpath("//*[@id=\"facebook\"]/body/div[3]/div[2]/div/div/div[1]/div[1]");
    By getSignUpBtn = By.name("websubmit");

    @Step("Click Create Account Button")
    public RegistrationPage GotoCreateAccount() throws InterruptedException {
        driver.findElement(createAccBTn).click();
        Thread.sleep(3000);
        driver.findElement(signUpIconIfDisplayed).isDisplayed();
        return this;
    }
    @Step("Fill First Name: {0}")
    public RegistrationPage FillFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        return this;
    }
    @Step("Fill Last Name: {0}")
    public RegistrationPage FillLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
        return this;
    }
    @Step("Fill Last Name: {0}")
    public RegistrationPage FillMobileNumber(String mobile) {
        driver.findElement(emaiOrMobilelInput).sendKeys(mobile);
        return this;
    }
    @Step("Fill Last Name: {0}")
    public RegistrationPage FillPassowrd(String password) {
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }
    @Step("Fill Last Name: {0}")
    public RegistrationPage FillBirthMonth(String month) {
        Select selectDay = new Select(driver.findElement(birthMonthInput));
        selectDay.selectByVisibleText(month);
        return this;
    }
    @Step("Fill Last Name: {0}")
    public RegistrationPage FillBirthYear(String year) {
        Select selectDay = new Select(driver.findElement(birthYearInput));
        selectDay.selectByVisibleText(year);
        return this;
    }
    @Step("Fill Last Name: {0}")
    public RegistrationPage FillBirthDay(String day) {
        Select selectDay = new Select(driver.findElement(birthDayInput));
        selectDay.selectByVisibleText(day);
        return this;
    }
    @Step("Fill Last Name: {0}")
    public RegistrationPage SelectGender() {
        driver.findElement(fameleSelector).click();
        return this;
    }
    @Step("Fill Last Name: {0}")
    public RegistrationPage SignUpBtnClick() {
        driver.findElement(getSignUpBtn).click();
        return this;
    }
}