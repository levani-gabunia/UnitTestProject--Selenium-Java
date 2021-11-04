package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.Assert;

public class LoginPage extends CommonPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By emailInput = By.xpath("//*[@id=\"login_popup342\"]");
    By passwordInput = By.xpath("//*[@id=\"psw_popup342\"]");
    By loginSubmitBtn = By.name("dispatch[auth.login]");

    @Step("Click Login Account Button")
    public LoginPage GotoSignIn() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(createAccBTn).click();
        Thread.sleep(3000);
        driver.findElement(loginForm).isDisplayed();
        return this;
    }
    @Step("Fill Email Adress: {0}")
    public LoginPage FillMail(String mail) {
        driver.findElement(emailInput).sendKeys(mail);
        return this;
    }
    @Step("Fill Password: {0}")
    public LoginPage FillPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }
    @Step("Click Submit: {0}")
    public LoginPage LoginSubmit() throws InterruptedException {
        driver.findElement(loginSubmitBtn).click();
        String color = driver.findElement(UImessage).getCssValue("border-color");
        Assert.assertEquals(color, "rgb(139, 192, 69)");
        return this;
    }
    @Step("Click Submit: {0}")
    public LoginPage LoginSubmitNegativeResult() throws InterruptedException {
        driver.findElement(loginSubmitBtn).click();
        String color = driver.findElement(emailInput).getCssValue("border-color");
        String color1 = driver.findElement(passwordInput).getCssValue("border-color");
        Assert.assertEquals(color, "rgb(194, 201, 208)");
        Assert.assertEquals(color1, "rgb(194, 201, 208)");
        return this;
    }
    @Step("Empty Email Adress: {0}")
    public LoginPage EmptyMail() {
        driver.findElement(emailInput).sendKeys("");
        return this;
    }
    @Step("Empty Password: {0}")
    public LoginPage EmptyPassword() {
        driver.findElement(passwordInput).sendKeys("");
        return this;
    }
}
