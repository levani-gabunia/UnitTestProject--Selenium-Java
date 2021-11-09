package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends CommonPage {
    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    By emailInput = By.xpath("//*[@id=\"login_popup342\"]");
    By passwordInput = By.xpath("//*[@id=\"psw_popup342\"]");
    By loginSubmitBtn = By.name("dispatch[auth.login]");
/*          same:
        @FindBy(xpath = "//*[@id=\'login_popup342\"]")
    By emailInput;

    @FindBy(xpath = "//*[@id=\"psw_popup342\"]")
    By passwordInput;

    @FindBy(name = "dispatch[auth.login]")
    By loginSubmitBtn;*/

    @Step("Click Login Account Button")
    public LoginPage GotoSignIn() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(createAccBTn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(loginForm)).isDisplayed();
        return this;
    }
    @Step("Fill Email Adress: {0}")
    public LoginPage FillMail(String mail) {
        wait.until(ExpectedConditions.elementToBeClickable(emailInput)).sendKeys(mail);
        return this;
    }
    @Step("Fill Password: {0}")
    public LoginPage FillPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordInput)).sendKeys(password);
        return this;
    }
    @Step("Click Submit: {0}")
    public LoginPage LoginSubmit() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(loginSubmitBtn)).click();
        String color = wait.until(ExpectedConditions.elementToBeClickable(UImessage)).getCssValue("border-color");
        Assert.assertEquals(color, "rgb(139, 192, 69)");
        return this;
    }
    @Step("Click Submit: {0}")
    public LoginPage LoginSubmitNegativeResult() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(loginSubmitBtn)).click();
        String color = wait.until(ExpectedConditions.elementToBeClickable(emailInput)).getCssValue("border-color");
        String color1 = wait.until(ExpectedConditions.elementToBeClickable(passwordInput)).getCssValue("border-color");
        Assert.assertEquals(color, "rgb(194, 201, 208)");
        Assert.assertEquals(color1, "rgb(194, 201, 208)");
        return this;
    }
    @Step("Empty Email Adress: {0}")
    public LoginPage EmptyMail() {
        wait.until(ExpectedConditions.elementToBeClickable(emailInput)).sendKeys("");
        return this;
    }
    @Step("Empty Password: {0}")
    public LoginPage EmptyPassword() {
        wait.until(ExpectedConditions.elementToBeClickable(passwordInput)).sendKeys("");
        return this;
    }
}
