package Pages;

import io.qameta.allure.Step;
import org.checkerframework.checker.guieffect.qual.UI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RecoveryPage extends CommonPage {
    WebDriver driver;
    WebDriverWait wait;

    public RecoveryPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    By recoveryBtn = By.xpath("/html/body/div[4]/div[2]/div/div/div[3]/div[2]/a");
    By mailInput = By.xpath("//*[@id=\"login_id_popup\"]");
    By recoverySubmitBtn = By.name("dispatch[auth.recover_password]");
    By changePassBtn = By.xpath("/html/body/div[1]/div[4]/div[4]/div/div/div[2]/div/div/div/form/div[9]/button");
    By recoveryLink = By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div[2]/div[4]/ul/li/div/div/div[1]/div[2]/div/div/div/div/a");
    By yahooMailInput = By.xpath("//*[@id=\"login-username\"]");//*[@id="password1"]
    By yahooMailSubmitBtn = By.xpath("//*[@id=\"login-signin\"]");
    By yahooPassInput = By.xpath("//*[@id=\"login-passwd\"]");
    By yahooMailBoxBtb = By.id("ybarMailLink");
    By firstMail = By.xpath("//*[@id=\"mail-app-component\"]/div/div/div[2]/div/div/div[3]/div/div[1]/ul/li[3]/a");

    @Step("Click Create Account Button")
    public RecoveryPage GotoCreateAccount() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(createAccBTn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(loginForm)).isDisplayed();
        return this;
    }
    @Step("Click Recovery Button: {0}")
    public RecoveryPage GoToRecovery() {
        wait.until(ExpectedConditions.elementToBeClickable(recoveryBtn)).click();
        return this;
    }
    @Step("Fill Mail: {0}")
    public RecoveryPage FillMail(String mail) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(mailInput)).sendKeys(mail);
        return this;
    }
    @Step("Fill Mail: {0}")
    public RecoveryPage FillMailEmpty() {
        wait.until(ExpectedConditions.elementToBeClickable(mailInput)).sendKeys("");
        return this;
    }
    @Step("Click Submit: {0}")
    public RecoveryPage ClickSubmitForEmpty() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(recoverySubmitBtn)).click();
        String color = driver.findElement(mailInput).getCssValue("border-color");
        Assert.assertEquals(color, "rgb(191, 77, 77)");
        return this;
    }
    @Step("Click Submit: {0}")
    public RecoveryPage ClickSubmit() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(recoverySubmitBtn)).click();
        String color = wait.until(ExpectedConditions.elementToBeClickable(UImessage)).getText();
        Assert.assertEquals(color, "×\n" +
                "ინფორმაცია პაროლის აღდგენის ინსტრუქცია გაგზავნილია თქვენს ელ-პოსტაზე.");
        return this;
    }
    @Step("Yahoo Login - change Password: {0}")
    public RecoveryPage yahooLogin(String mail, String pass,String city, String adress) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://login.yahoo.com/?.lang=en-US&src=homepage&.done=https%3A%2F%2Fwww.yahoo.com%2F&pspid=2023538075&activity=ybar-signin");
        wait.until(ExpectedConditions.elementToBeClickable(yahooMailInput)).sendKeys(mail);
        wait.until(ExpectedConditions.elementToBeClickable(yahooMailSubmitBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(yahooPassInput)).sendKeys(pass);
        wait.until(ExpectedConditions.elementToBeClickable(yahooMailSubmitBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(yahooMailBoxBtb)).click();
        wait.until(ExpectedConditions.elementToBeClickable(firstMail)).click();
        wait.until(ExpectedConditions.elementToBeClickable(recoveryLink)).click();
        for(String winHandle : driver.getWindowHandles()){ //switch to linked tab
            driver.switchTo().window(winHandle);
        }
        wait.until(ExpectedConditions.elementToBeClickable(userDataPassInput)).sendKeys(pass);
        wait.until(ExpectedConditions.elementToBeClickable(userDataPass2Input)).sendKeys(pass);
        wait.until(ExpectedConditions.elementToBeClickable(userDataCityInput)).sendKeys(city);
        wait.until(ExpectedConditions.elementToBeClickable(userDataAdressInput)).sendKeys(adress);
        wait.until(ExpectedConditions.elementToBeClickable(changePassBtn)).click();
        String color = driver.findElement(UImessage).getCssValue("border-color");
        Assert.assertEquals(color, "rgb(139, 192, 69)");
        return this;
    }
}
